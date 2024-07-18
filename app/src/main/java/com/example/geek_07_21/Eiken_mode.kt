package com.example.geek_07_21

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment




class Eiken_Mode : Fragment(R.layout.fragment_eiken_mode) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // フラグメントのレイアウトをインフレートする
        val view = inflater.inflate(R.layout.fragment_eiken_mode, container, false)

        return view
    }
}
