package com.example.geek_07_21

import MainFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle



class MainActivity : AppCompatActivity() {

    private val fm = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fm.beginTransaction().apply {
            replace(R.id.activity_container, MainFragment())
            commit()
        }
    }
}


