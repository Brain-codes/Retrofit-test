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
    val getCustomPosts:  MutableLiveData<Response<List<Post>>> = MutableLiveData()

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
    fun getCustomPosts(userId : Int) {
        viewModelScope.launch {
            val response : Response<List<Post>> = repository.getCustomPosts(userId)
            getCustomPosts.value = response
        }
    }
}