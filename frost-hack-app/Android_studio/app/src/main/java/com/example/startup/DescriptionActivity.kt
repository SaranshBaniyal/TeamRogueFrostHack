package com.example.startup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DescriptionActivity : AppCompatActivity() {
    var edsave = findViewById<Button>(R.id.edsave)
    var eddescription = findViewById<EditText>(R.id.eddescription)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        edsave.setOnClickListener {
            val retrofitbuilder = Retrofit.Builder()
                .baseUrl("https://1f60-152-58-108-67.in.ngrok.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val myApi = retrofitbuilder.create(MyAPI::class.java)

            GlobalScope.launch(Dispatchers.Main) {
                var postob = postData("johndoe",eddescription.text.toString())
                val data = myApi.postentry(postob)
                Toast.makeText(baseContext,data.toString(),Toast.LENGTH_SHORT).show()
            }
        }
    }

}