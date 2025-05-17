package com.example.batalhanaval.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.children
import com.example.batalhanaval.R
import com.example.batalhanaval.controllers.JogoController

class DefineNavioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_define_navio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        definirTextoInicial()   //texto inicial jogador atual
    }



    //**************  BOTAO PARA DEFINIR NAVIO  **************
    fun definirNavio(view: View) {
        val cooderdana = view as ImageButton                    //RECEBE O OBJETO BOTAO QUE DEU O CLIQUE (1 a 25)
        val id = cooderdana.tag.toString().toInt()              //RECEBE O NUMERO DA COORDENADA QUE DEU O CLIQUEI (1 A 25)
        val jogadorAtual = JogoController.jogadorAtual()
        val botaoPassarTurno = findViewById<Button>(R.id.btn0)

        //************** DEFINIR LOGICA DE TODOS OS NAVIOS COLOCADOS PARA ATIVAR O BOTAO DE PASSAR TURNO **************
        if(JogoController.posicionarNavio(id,jogadorAtual)){

            cooderdana.isEnabled = false
            cooderdana.setImageDrawable(null)
            cooderdana.setBackgroundResource(R.drawable.naviointeiro)

            var texto = "Restantes: " + JogoController.naviosRestates(jogadorAtual)
            findViewById<TextView>(R.id.textNaviosRestantes).setText(texto)


            //SE TODOS OS NAVIOS FORAM DEFINIDOS IRÁ INATIVAR TODOS OS BOTOES E ATIVAR O PASSAR TURNO
            if( JogoController.tabuleiroDefinido(jogadorAtual) ){
                botaoPassarTurno.isEnabled = true

                val tabuleiroJogador = findViewById<GridLayout>(R.id.tabuleiroDefineNavio)
                for (view in tabuleiroJogador.children) {
                    if (view is ImageButton) {
                        view.isEnabled = false
                    }
                }
            }
        }
    }


    fun teste(view: View){
        val cooderdana = view as ImageButton                    //RECEBE O OBJETO BOTAO QUE DEU O CLIQUE (1 a 25)
        val id = cooderdana.tag.toString().toInt()              //RECEBE O NUMERO DA COORDENADA QUE DEU O CLIQUEI (1 A 25)

        val jogadorAtual = JogoController.jogadorAtual()
        val botaoPassarTurno = findViewById<Button>(R.id.btn0)
        val textoTabuleiro = findViewById<TextView>(R.id.textTabuleiro)
    }


    //**************  DEFINE O TEXTO DO JOGADOR AO INICIAR A ACTIVITY  **************
    private fun definirTextoInicial() {
        val textoTabuleiro = findViewById<TextView>(R.id.textJogadorDN)
        val jogadorAtual = JogoController.jogadorAtual()
        if (jogadorAtual == 1) {
            textoTabuleiro.setText("Jogador 1")
        } else {
            textoTabuleiro.setText("Jogador 2")
        }
    }


    //************** USADO NO BOTAO PARA PASSAR TURNO  **************
    fun passarTurno(view: View) {
        JogoController.mudarTurno()
        val intent = Intent(this, TransicaoActivity::class.java)
        startActivity(intent)
    }
}