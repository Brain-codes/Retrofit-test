package com.brain.yashretrofit

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.brain.yashretrofit.repository.Repository

class MainActivity : AppCompatActivity() {
    //    INITIALIZE OUR VIEW MODEL
    private lateinit var viewModel: MainViewModel

    val userid_txt = findViewById<TextView>(R.id.userId_txt)


    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        //INITIALIZE OUR VIEW MODEL
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

    }

}