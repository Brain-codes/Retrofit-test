package com.brain.yashretrofit.repository

import com.brain.yashretrofit.api.RetrofitInstance
import com.brain.yashretrofit.model.Post
import retrofit2.Response

class Repository {
//    suspend fun getPost(): Post {
        suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

//    DYNAMIC SITUATION FOR GETTING POST
    suspend fun  getPost2(number : Int): Response<Post> {
        return RetrofitInstance.api.getPost2(number)
    }

    //QUERY FOR GETTING LIST OF CUSTOM POST

    suspend fun getCustomPosts(userId : Int) : Response<List<Post>> {
        return RetrofitInstance.api.getCustomPost(userId)
    }

}