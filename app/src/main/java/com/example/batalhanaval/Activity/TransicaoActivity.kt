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
        definirTextoInicial()
    }


    //**************  DEFINE O TEXTO DO JOGADOR AO INICIAR A ACTIVITY  **************
    private fun definirTextoInicial() {
        val textoTabuleiro = findViewById<TextView>(R.id.textTransicao)  //faz o texto da tela ser dinâmico

        val jogadorAtual = JogoController.jogadorAtual()
        textoTabuleiro.setText("Jogador $jogadorAtual")


    }


    //************** USADO NO BOTAO PARA PASSAR TURNO  **************
    fun passarTurno(view: View) {
        val jogadorAtual = JogoController.jogadorAtual()

        //SE O JOGADOR 2 NAO DEFINIU NAVIO IRÁ PARA DEFINE ACTIVITY
        if (jogadorAtual == 2 && !JogoController.tabuleiroDefinido(2)){
            val intent = Intent(this, DefineNavioActivity::class.java)
            startActivity(intent)
        } else{
            val intent = Intent(this, JogoActivity::class.java)
            startActivity(intent)
        }
    }

}