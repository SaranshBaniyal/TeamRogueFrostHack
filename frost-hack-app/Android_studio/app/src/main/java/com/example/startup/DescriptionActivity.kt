package com.example.startup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DescriptionActivity : AppCompatActivity() {
    private lateinit var edsave: Button
    private lateinit var eddescription: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        edsave= findViewById(R.id.edsave)
        eddescription= findViewById(R.id.eddescription)
        edsave.setOnClickListener {
            val retrofitbuilder = Retrofit.Builder()
                .baseUrl(StoreObj.baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val myApi = retrofitbuilder.create(MyAPI::class.java)

            GlobalScope.launch(Dispatchers.Main) {
                var postob = postData(StoreObj.username,eddescription.text.toString())
                val data: Call<postRes> = myApi.postentry(postob)
                val intent = Intent(this@DescriptionActivity,MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

}