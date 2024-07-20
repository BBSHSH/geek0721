package com.example.geek_07_21

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import androidx.fragment.app.Fragment




class Login : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val registration_button = view.findViewById<Button>(R.id.regist)

        registration_button.setOnClickListener {
            // FragmentManagerの取得
            val pfm = parentFragmentManager

            // トラン
            // ザクションの生成・コミット
            val ft = pfm.beginTransaction()
            ft.apply {
                replace(R.id.MainContainer, Registration())
                commit()
            }
        }
    }
}
