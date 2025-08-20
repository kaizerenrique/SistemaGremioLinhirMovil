package online.linhir.app

import android.app.Application
import online.linhir.app.network.ApiClient

class LinhirApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ApiClient.initialize(this)
    }
}