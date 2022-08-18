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

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.bdy)
        val btn = findViewById<Button>(R.id.button)
        val numberPut = findViewById<EditText>(R.id.number_editText)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        //INITIALIZE OUR VIEW MODEL
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
//         viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                Log.d("Response", response.body()?.userId.toString())
                Log.d("Response", response.body()?.id.toString())
                Log.d("Response", response.body()?.title!!)
                //  tv.text = response.body()?.title!!
                Log.d("Response", response.body()?.body!!)
            } else {
                Log.d("Response", response.errorBody().toString())
                //  tv.text = response.errorBody().toString()
            }

        })


        // DYNAMIC POST GETTING
        btn.setOnClickListener {
            val myNumber = numberPut.text.toString()


// viewModel.getPost2(Integer.parseInt(myNumber))
// viewModel.myResponse2.observe(this, Observer { response ->


        // CHANGING IT TO QUERY, GETTING DYNAMIC CUSTOM POST
            viewModel.getCustomPosts(Integer.parseInt(myNumber))
            viewModel.getCustomPosts.observe(this, Observer { response ->
                if (response.isSuccessful) {
                    tv.text = response.body().toString()
//                    LOGGING FOR EACH POST AND ID
                    response.body()?.forEach{
                        Log.d("Response", it.userId.toString())
                        Log.d("Response", it.id.toString())
                        Log.d("Response", it.title)
                        Log.d("Response", it.body)
                        Log.d("Response", "------------------")
                    }
                } else {
                    tv.text = response.code().toString()
                }

            })

        }
    }
}