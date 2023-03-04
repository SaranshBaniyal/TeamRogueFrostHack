package com.example.startup

import android.os.Bundle
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

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityLogInBinding
    private lateinit var edusername: EditText
    private lateinit var edpassword: EditText
    private lateinit var btLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        edpassword = findViewById(R.id.edusername)
        edpassword = findViewById(R.id.edpassword)
        btLogin = findViewById(R.id.btLogin)

        btLogin.setOnClickListener {
            val username = edusername.text.toString()
            val password = edpassword.text.toString()

            logInFunc("johndoe","mypassword")
        }
    }


    private fun logInFunc(username: String, password: String) {
        val client = OkHttpClient()

        val requestBody = FormBody.Builder()
            .add("username", username)
            .add("password", password)
            .build()

        val headers = Headers.Builder()
//            .add("Authorization", "Bearer <your_token>")
            .add("Content-Type", "application/json")
            .add("ngrok-skip-browser-warning", "abc")
            .build()

        val request = Request.Builder()
            .url(" https://3ac5-152-58-108-241.in.ngrok.io/api/accounts/login/")
            .post(requestBody)
            .headers(headers)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                // Handle successful response here
//                val jsonObject = JSONTokener(response.body.toString()).nextValue() as JSONObject
//                val success = jsonObject.getString("success")
//                if (success.equals("True"))
//                    Toast.makeText(baseContext, "success", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call, e: IOException) {
                // Handle error response here
            }
        })

    }

}
