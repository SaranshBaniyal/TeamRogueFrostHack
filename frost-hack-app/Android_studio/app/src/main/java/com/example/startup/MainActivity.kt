package com.example.startup


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.startup.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private val client = OkHttpClient.Builder()
        .connectionSpecs(listOf(ConnectionSpec.CLEARTEXT, ConnectionSpec.MODERN_TLS))
        .build()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val retrofitbuilder = Retrofit.Builder()
            .baseUrl(StoreObj.baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val myApi = retrofitbuilder.create(MyAPI::class.java)
//        val datalist: RecyclerView = findViewById(R.id.datalist)
        binding.datalist.layoutManager = LinearLayoutManager(this)


        GlobalScope.launch(Dispatchers.Main) {
            val user = User(StoreObj.username, "2023-03-03")
            val data = myApi.getData(user)
            binding.datalist.adapter = MyAdapter(data)
        }

        binding.edadd.setOnClickListener {
            val intent = Intent(this, DescriptionActivity::class.java)
            startActivity(intent)
        }

    }
}