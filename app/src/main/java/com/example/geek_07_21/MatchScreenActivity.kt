package com.example.geek_07_21

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MatchScreenActivity : AppCompatActivity() {

    private lateinit var player1Health: ProgressBar
    private lateinit var player2Health: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_match_screen)

        player1Health = findViewById(R.id.player1Health)
        player2Health = findViewById(R.id.player2Health)

        findViewById<ImageView>(R.id.iv_menuIcon).setOnClickListener {
            showMenuDialog()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Simulating health bar updates
        updateHealthBars(100, 40)
    }

    private fun showMenuDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_menu, null)
        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        dialogView.findViewById<Button>(R.id.btn_settings).setOnClickListener {
            Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        dialogView.findViewById<Button>(R.id.btn_exit).setOnClickListener {
            finish()
        }

        dialogView.findViewById<Button>(R.id.btn_cancel).setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun updateHealthBars(player1HealthValue: Int, player2HealthValue: Int) {
        player1Health.progress = player1HealthValue
        player2Health.progress = player2HealthValue
    }
}
