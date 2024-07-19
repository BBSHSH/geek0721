package com.example.geek_07_21

import MainFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import androidx.fragment.app.Fragment




class Eiken_Mode : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_eiken_mode, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.back)
        button.setOnClickListener {
            // FragmentManagerの取得
            val pfm = parentFragmentManager

            // トランザクションの生成・コミット
            val ft = pfm.beginTransaction()
            ft.apply {
                replace(R.id.MainContainer, MainFragment())
                commit()
            }
        }
    }
}
