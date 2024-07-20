package com.example.geek_07_21

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException




class Login : Fragment() {

    private val apiManager = ApiManager()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val usernameEditText = view.findViewById<EditText>(R.id.id)
        val passwordEditText = view.findViewById<EditText>(R.id.password)
        val loginButton = view.findViewById<Button>(R.id.login)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            val json = JSONObject().apply {
                put("username", username)
                put("password", password)
            }

            val requestBody = json.toString().toRequestBody("application/json; charset=utf-8".toMediaType())

            apiManager.sendPostRequest("localhost:8080", "login", requestBody, object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    // エラーハンドリング
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    if (response.isSuccessful) {
                        // レスポンスデータの処理
                        val responseData = response.body?.string()
                        // データを使用
                    } else {
                        // エラーハンドリング
                    }
                }
            })
        }
    }
}
