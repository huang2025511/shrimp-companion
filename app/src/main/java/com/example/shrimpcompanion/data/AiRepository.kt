package com.example.shrimpcompanion.data

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AiRepository(context: Context) {
    private val apiKey = BuildConfig.API_KEY
    
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder()
                .header("Authorization", "Bearer $apiKey")
                .build()
            chain.proceed(request)
        }
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openai.com/v1/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(AiApiService::class.java)

    suspend fun getResponse(messages: List<ChatMessage>): String? {
        return try {
            val request = ChatRequest(messages = messages)
            val response = apiService.sendMessage(request)
            if (response.isSuccessful) {
                response.body()?.choices?.firstOrNull()?.message?.content
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }
}
