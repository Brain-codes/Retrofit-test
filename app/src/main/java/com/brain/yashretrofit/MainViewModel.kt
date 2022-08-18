package com.brain.yashretrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brain.yashretrofit.model.Post
import com.brain.yashretrofit.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {
    val myResponse:  MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2:  MutableLiveData<Response<Post>> = MutableLiveData()
    val myCustomPosts:  MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myCustomPosts2:  MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun getPost() {
            viewModelScope.launch {
                val response : Response<Post> = repository.getPost()
                myResponse.value = response
            }
    }

//    DYNAMIC POST GETTING
    fun getPost2(number : Int) {
        viewModelScope.launch {
            val response : Response<Post> = repository.getPost2(number)
            myResponse2.value = response
        }
    }

    //    GETTIN CUSTOM  POST WITH QUERY
    fun getCustomPosts(userId : Int, order :String, sort : String) {
        viewModelScope.launch {
            val response : Response<List<Post>> = repository.getCustomPosts(userId, order, sort)
            myCustomPosts.value = response
        }
    }

    //    GETTIN CUSTOM  POST WITH QUERY MAP
    fun getCustomPosts2(userId : Int, options : Map<String, String>) {
        viewModelScope.launch {
            val response : Response<List<Post>> = repository.getCustomPosts2(userId, options)
            myCustomPosts2.value = response
        }
    }
}