package com.brain.yashretrofit.api

import com.brain.yashretrofit.model.Post
import retrofit2.http.GET

interface SimpleApi {

    @GET("posts/1")
    suspend fun getPost() : Post
}