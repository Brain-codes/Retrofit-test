package com.brain.yashretrofit.repository

import com.brain.yashretrofit.api.RetrofitInstance
import com.brain.yashretrofit.model.Post
import retrofit2.Response

class Repository {
//    suspend fun getPost(): Post {
        suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
}