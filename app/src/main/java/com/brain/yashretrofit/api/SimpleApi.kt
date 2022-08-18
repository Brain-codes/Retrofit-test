package com.brain.yashretrofit.api

import com.brain.yashretrofit.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SimpleApi {

    @GET("posts/1")
  //  suspend fun getPost() : Post
    //HANDLING IF ITS A 404 ERROR
    suspend fun getPost() :  Response<Post>

//    DYNAMICALLY GETTING POST
    @GET ("posts/{postNumber}")
    suspend fun  getPost2(
        @Path("postNumber")  number : Int
    ): Response<Post>


//    ADDING QUERY IN GET REQUEST
    @GET ("posts")
    suspend fun getCustomPosts(
    @Query("userId")  userId : Int
    ): Response<List<Post>>
}