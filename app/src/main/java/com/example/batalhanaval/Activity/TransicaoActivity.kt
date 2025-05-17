package com.example.batalhanaval.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.batalhanaval.R
import com.example.batalhanaval.controllers.JogoController

class TransicaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_transicao)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var jogador = intent.getStringExtra("jogador")

        if (jogador != null) {
            val textView = findViewById<TextView>(R.id.textViewJogadorTransicao)
            textView.text = jogador
        }

    }




    fun proxJogador(view: View) {
        val intent = Intent(this, GanhadorActivity::class.java)

        if (JogoController.jogadorAtual == 1){
            JogoController.jogadorAtual = 2
            intent.putExtra("jogador","Jogador 2")
        } else{
            JogoController.jogadorAtual = 1
            intent.putExtra("jogador","Jogador 1")
        }

        startActivity(intent)
    }

}