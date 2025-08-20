package online.linhir.app.network

import android.content.Context
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    private const val BASE_URL = "https://linhir.online/api/"
    private const val TIMEOUT_SECONDS = 60L

    @Volatile
    private var INSTANCE: Retrofit? = null

    @Volatile
    private var sessionManager: UserSessionManager? = null

    fun initialize(context: Context) {
        sessionManager = UserSessionManager(context)
    }

    fun getInstance(): Retrofit {
        return INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildRetrofit().also { INSTANCE = it }
        }
    }

    private fun buildRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(buildOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun buildOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(sessionManager))
            .addInterceptor(createLoggingInterceptor())
            .connectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .build()
    }

    private fun createLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private class AuthInterceptor(private val sessionManager: UserSessionManager?) : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val originalRequest = chain.request()

            // Si la petición ya tiene Authorization header, no agregamos token
            if (originalRequest.header("Authorization") != null) {
                return chain.proceed(originalRequest)
            }

            // Si no hay token disponible, proceder sin Authorization
            val token = sessionManager?.getToken()
            if (token.isNullOrEmpty()) {
                return chain.proceed(originalRequest)
            }

            // Agregar token al header
            val authenticatedRequest = originalRequest.newBuilder()
                .header("Authorization", "Bearer $token")
                .build()

            return chain.proceed(authenticatedRequest)
        }
    }

    // Metodo para crear servicios API
    inline fun <reified T> createService(serviceClass: Class<T>): T {
        return getInstance().create(serviceClass)
    }

    // Metodo para invalidar instancia
    fun reset() {
        INSTANCE = null
    }
}