package com.example.startup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.startup.databinding.ActivityLogInBinding
import okhttp3.*
import okio.IOException
import org.json.JSONObject
import org.json.JSONTokener

class LogIn : AppCompatActivity() {

//    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityLogInBinding
    private lateinit var edusername: EditText
    private lateinit var edpassword: EditText
    private lateinit var btLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        edpassword = findViewById(R.id.edusername)
//        edpassword = findViewById(R.id.edpassword)
//        btLogin = findViewById(R.id.btLogin)

        binding.btLogin.setOnClickListener {
            val username = binding.edusername.text.toString()
            val password = binding.edpassword.text.toString()

//            val username ="johndoe"
//            val password = "mypassword"
            logInFunc(username,password)
        }
    }


    private fun logInFunc(username: String, password: String) {
        val client = OkHttpClient()

        val requestBody = FormBody.Builder()
            .add("username", username)
            .add("password", password)
            .build()

        val headers = Headers.Builder()
            .add("Content-Type", "application/json")
            .add("ngrok-skip-browser-warning", "abc")
            .build()

        val request = Request.Builder()
            .url("${StoreObj.baseurl}/api/accounts/login/")
            .post(requestBody)
            .headers(headers)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                // Handle successful response here
                val ans:String = response.body!!.string()
                Log.d("Result",ans)
                val json = JSONObject(ans)
                val success = json.getBoolean("success")

                if (success){
                    Log.d("Result",username)
                    StoreObj.username = username
                    val intent = Intent(this@LogIn, MainActivity::class.java)
                    startActivity(intent)
                }
//                    Toast.makeText(this, "success.toString()", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call, e: IOException) {
                // Handle error response here
            }
        })

    }

}
