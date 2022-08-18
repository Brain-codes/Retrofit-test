package com.brain.yashretrofit.repository

import com.brain.yashretrofit.api.RetrofitInstance
import com.brain.yashretrofit.model.Post

class Repository {
    suspend fun getPost(): Post {
        return RetrofitInstance.api.getPost()
    }
}