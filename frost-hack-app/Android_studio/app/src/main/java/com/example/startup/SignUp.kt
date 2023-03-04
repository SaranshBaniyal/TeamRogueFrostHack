package com.example.startup

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.startup.databinding.ActivitySignUpBinding
import com.google.android.material.snackbar.Snackbar
import okhttp3.*
import okio.IOException

class SignUp : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btSignUp.setOnClickListener {
            val username=binding.edUserName.text.toString()
            val full_name=binding.edfullName.text.toString()
            val email= binding.edemail.text.toString()
            val password=binding.edpassword.text.toString()

            signUpFunc(username,full_name,email,password);
        }
    }

    private fun signUpFunc(username: String, full_name: String, email: String, password: String){
        val client = OkHttpClient()

        val requestBody = FormBody.Builder()
            .add("username", username)
            .add("full_name", full_name)
            .add("email", email)
            .add("password", password)
            .build()

        val headers = Headers.Builder()
//            .add("Authorization", "Bearer <your_token>")
            .add("Content-Type", "application/json")
            .add("ngrok-skip-browser-warning", "abc")
            .build()

        val request = Request.Builder()
            .url("${StoreObj.baseurl}/api/accounts/signup/")
            .post(requestBody)
            .headers(headers)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                StoreObj.username = username
                val intent = Intent(this@SignUp, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

            override fun onFailure(call: Call, e: IOException) {
                val snackbar = Snackbar.make(binding.root, "Network Error", Snackbar.LENGTH_SHORT)
                snackbar.setAction("Retry") {
                    binding.edUserName.text.clear()
                    binding.edpassword.text.clear()
                    binding.edemail.text.clear()
                    binding.edfullName.text.clear()
                }
                snackbar.show()
            }
        })

    }


}