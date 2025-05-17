package com.example.batalhanaval.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.batalhanaval.R
import com.example.batalhanaval.controllers.JogoController

class JogoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_jogo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



    }

    fun proximoTurno(view: View) {
        //val intent = Intent(this, JogoActivity::class.java)

        //val tiroRealizado = verificarCondicao() //recebe o resultado da funcao e define a view de acordo


        /*
        val intent = if (tiroRealizado) {
            Intent(this, jogo::class.java)
        } else {
            Intent(this, defineNavio::class.java)
        }
        startActivity(intent)
        */
        val intent = Intent(this, TransicaoActivity::class.java)

        if (JogoController.jogadorAtual == 1){
            intent.putExtra("jogador","Jogador 1")
            val intent = Intent(this, TransicaoActivity::class.java)
        } else{
            intent.putExtra("jogador","Jogador 2")
        }


        startActivity(intent)
    }
}