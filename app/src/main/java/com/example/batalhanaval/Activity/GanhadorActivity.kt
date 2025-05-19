package com.example.batalhanaval.Activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.batalhanaval.R
import com.example.batalhanaval.controllers.JogoController

class GanhadorActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ganhador)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //definir o TextVencedor para o nome do jogador
        var vencedor = intent.getStringExtra("jogador")

        if (vencedor != null) {
            val textView = findViewById<TextView>(R.id.textJogadorVencedor)
            textView.text = vencedor
        }

    }

    fun jogarNovamente(view: View) {
        JogoController.novoJogo()
        val intent = Intent(this, DefineNavioActivity::class.java)
        startActivity(intent)
    }
}