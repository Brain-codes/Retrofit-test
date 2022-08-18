package com.brain.yashretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import com.brain.yashretrofit.repository.Repository

class MainActivity : AppCompatActivity() {
//    INITIALIZE OUR VIEW MODEL
    private lateinit var viewModel: MainViewModel
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.bdy)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        //INITIALIZE OUR VIEW MODEL
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
         viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                Log.d("Response", response.body()?.userId.toString())
                Log.d("Response", response.body()?.id.toString())
                Log.d("Response", response.body()?.title!!)
                tv.text = response.body()?.title!!
                Log.d("Response", response.body()?.body!!)
            }else {
                Log.d("Response", response.errorBody().toString())
                tv.text = response.errorBody().toString()

            }

        })
    }
}