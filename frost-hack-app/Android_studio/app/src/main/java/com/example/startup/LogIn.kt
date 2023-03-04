package com.example.startup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.startup.databinding.ActivityLogInBinding
import com.google.android.material.snackbar.Snackbar
import okhttp3.*
import okio.IOException
import org.json.JSONObject

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



        binding.btLogin.setOnClickListener {
            val username = binding.edusername.text.toString()
            val password = binding.edpassword.text.toString()


            logInFunc(username,password)
        }

        binding.tvsignup.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
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
                    finish()
                }
                else{
                    val snackbar = Snackbar.make(binding.root, "Invalid Credentials", Snackbar.LENGTH_SHORT)
                    snackbar.setAction("Retry") {
                        binding.edusername.text.clear()
                        binding.edpassword.text.clear()
                    }
                    snackbar.show()
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                val snackbar = Snackbar.make(binding.root, "Network Error", Snackbar.LENGTH_SHORT)
                snackbar.setAction("Retry") {
                    binding.edusername.text.clear()
                    binding.edpassword.text.clear()
                }
                snackbar.show()
            }
        })

    }

}
