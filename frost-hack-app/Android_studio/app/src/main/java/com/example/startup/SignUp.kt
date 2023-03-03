package com.example.startup

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.startup.databinding.ActivitySignUpBinding
import okhttp3.*
import okio.IOException

class SignUp : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var edUserName: EditText
    private lateinit var edemail: EditText
    private lateinit var edpassword: EditText
    private lateinit var edfull_name: EditText
    private lateinit var btSignUp: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        edUserName= findViewById(R.id.edUserName)
        edfull_name= findViewById(R.id.edfull_name)
        edemail= findViewById(R.id.edemail)
        edpassword= findViewById(R.id.edpassword)
        btSignUp= findViewById(R.id.btSignUp)

        btSignUp.setOnClickListener {
            val username=edUserName.text.toString()
            val full_name=edfull_name.text.toString()
            val email=edemail.text.toString()
            val password=edpassword.text.toString()

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
            .url(" https://3ac5-152-58-108-241.in.ngrok.io/api/accounts/signup/")
            .post(requestBody)
            .headers(headers)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                // Handle successful response here
            }

            override fun onFailure(call: Call, e: IOException) {
                // Handle error response here
            }
        })

    }


}