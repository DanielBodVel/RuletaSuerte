package com.example.ruletadelasuerte

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class PlayerSelect : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_player_select)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val playerName = findViewById<TextInputEditText>(R.id.nameIn)

        findViewById<Button>(R.id.next)?.setOnClickListener {
            val playerInputName = playerName.text.toString().trim()
            if (playerInputName.isEmpty()) {
                AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("¡No hay ningún nombre!")
                    .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                    .show()
            } else {
                val intent = Intent(this, TalkActivity::class.java)
                intent.putExtra("PlayerName", playerInputName)
                //intent.putExtra("PlayerColor")
                startActivity(intent)
            }
        }
    }
}