package online.linhir.app.network

import android.content.Context
import android.content.SharedPreferences

class UserSessionManager(context: Context) {

    companion object {
        private const val PREF_NAME = "linhir_user_session"
        private const val KEY_TOKEN = "user_token"
        private const val KEY_USER_ID = "user_id"
        private const val KEY_USER_NAME = "user_name"
        private const val KEY_IS_LOGGED_IN = "is_logged_in"
    }

    private val prefs: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun saveUserSession(token: String, userId: String, userName: String) {
        prefs.edit().apply {
            putString(KEY_TOKEN, token)
            putString(KEY_USER_ID, userId)
            putString(KEY_USER_NAME, userName)
            putBoolean(KEY_IS_LOGGED_IN, true)
            apply()
        }
    }

    fun getToken(): String? = prefs.getString(KEY_TOKEN, null)

    fun getUserId(): String? = prefs.getString(KEY_USER_ID, null)

    fun getUserName(): String? = prefs.getString(KEY_USER_NAME, null)

    fun isLoggedIn(): Boolean = prefs.getBoolean(KEY_IS_LOGGED_IN, false)

    fun clearSession() {
        prefs.edit().clear().apply()
    }

    data class UserSession(
        val token: String,
        val userId: String,
        val userName: String
    )

    fun getUserSession(): UserSession? {
        val token = getToken()
        val userId = getUserId()
        val userName = getUserName()

        return if (token != null && userId != null && userName != null && isLoggedIn()) {
            UserSession(token, userId, userName)
        } else {
            null
        }
    }
}