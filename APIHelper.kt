package com.fleaudie.foodlator

import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class APIHelper {
    fun getCategoryInfo(categoryName: String, callback: (String?) -> Unit) {
        val url = "http://192.168.0.211:5000/categories/$categoryName"
        val request = Request.Builder()
            .url(url)
            .build()

        OkHttpClient().newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace() // Hata detaylarını logcat'e yazdır
                callback(null)
            }

            override fun onResponse(call: Call, response: Response) {
                val responseData = response.body?.string()
                callback(responseData)
            }
        })
    }
}