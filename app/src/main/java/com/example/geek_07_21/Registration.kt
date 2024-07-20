package com.example.geek_07_21

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import androidx.fragment.app.Fragment




class Registration : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val back_button = view.findViewById<Button>(R.id.back)

        back_button.setOnClickListener {
            // FragmentManagerの取得
            val pfm = parentFragmentManager

            // トラン
            // ザクションの生成・コミット
            val ft = pfm.beginTransaction()
            ft.apply {
                replace(R.id.MainContainer, Login())
                commit()
            }

        }
    }
}
