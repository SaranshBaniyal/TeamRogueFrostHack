package com.example.startup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.startup.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import okio.IOException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

//    private lateinit var next: Button
//    private var plus=findViewById<Button>(R.id.edadd)
    private val client = OkHttpClient.Builder()
        .connectionSpecs(listOf(ConnectionSpec.CLEARTEXT, ConnectionSpec.MODERN_TLS))
        .build()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//            Log.d("MainActivity","Button Clicked")

//            val jsonBody:String = """ "username", "johndoe", "date", "2023-03-03" """

//            val headers = Headers.Builder()
//                .add("Content-Type","application/json")
//                .add("ngrok-skip-browser-warning", "abc")
//                .build()
//            val requestBody = jsonBody.toRequestBody("application/json".toMediaTypeOrNull())
//            val request = Request.Builder()
//                .url("https://3ac5-152-58-108-241.in.ngrok.io/api/accounts/output/")
//                .post(requestBody)
//                .headers(headers)
//                .build()
//
//            client.newCall(request).enqueue(object : Callback {
//                override fun onResponse(call: Call, response: Response) {
//                    Toast.makeText(baseContext,"response.body?.toString()",Toast.LENGTH_SHORT).show()
//                }
//
//                override fun onFailure(call: Call, e: IOException) {
//                    val errorMessage = e.message ?: "Unknown error"
//                    runOnUiThread {
//                        Log.e("MainActivity", "Network request failed: $errorMessage")
//                        Toast.makeText(baseContext, "Network request failed: $errorMessage", Toast.LENGTH_LONG).show()
//                    }
//                }
//            })


        val retrofitbuilder = Retrofit.Builder()
            .baseUrl("https://1f60-152-58-108-67.in.ngrok.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val myApi = retrofitbuilder.create(MyAPI::class.java)
        val datalist: RecyclerView = findViewById(R.id.datalist)
        datalist.layoutManager = LinearLayoutManager(this)

        val sharedPref = applicationContext.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val token = sharedPref.getString("username", "")

        GlobalScope.launch(Dispatchers.Main) {
            val user = User(token.toString(), "2023-03-03")
            val data = myApi.getData(user)
            datalist.adapter = MyAdapter(data)
        }

        binding.edadd.setOnClickListener {
            val intent = Intent(this, DescriptionActivity::class.java)
            startActivity(intent)
        }

    }
}