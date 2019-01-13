package net.simplifiedcoding.myapplication

import android.app.Application
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class VolleySingleton : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    val requestQueue: RequestQueue? = null

    get() {
        if (field == null){
            return Volley.newRequestQueue(applicationContext)
        }
        return field
    }

    companion object {
        private val TAG = VolleySingleton::class.java.simpleName
        @get:Synchronized var instance: VolleySingleton? = null
        private set
    }
}