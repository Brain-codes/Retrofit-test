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

    suspend fun getCustomPosts(userId : Int, sort : String, order : String) : Response<List<Post>> {
        return RetrofitInstance.api.getCustomPosts(userId, sort, order)
    }

//    QUERY MAP
suspend fun getCustomPosts2(userId : Int, options : Map <String, String>) : Response<List<Post>> {
    return RetrofitInstance.api.getCustomPosts2(userId, options)
}

//FOR PUSH POST @POST
    suspend fun pushPost(post : Post) : Response<Post> {
        return RetrofitInstance.api.pushPost(post)
    }

    //FOR PUSH POST FORM ENCODED @POST
    suspend fun pushPost2( userId: Int, id : Int, body : String, title: String) : Response<Post> {
        return RetrofitInstance.api.pushPost2(userId, id, body, title)
    }

}