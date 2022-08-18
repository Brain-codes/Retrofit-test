package com.brain.yashretrofit

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brain.yashretrofit.adapter.MyAdaptar
import com.brain.yashretrofit.repository.Repository

class MainActivity : AppCompatActivity() {
    //    INITIALIZE OUR VIEW MODEL
    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy {MyAdaptar()}

    val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerview()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        //INITIALIZE OUR VIEW MODEL
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getCustomPosts(2, "id", "desc")
        viewModel.myCustomPosts.observe(this, Observer{response ->
            if (response.isSuccessful) {
                response.body()?.let { myAdapter.setData(it) }
            } else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun setupRecyclerview() {
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager  = LinearLayoutManager(this)
    }
}