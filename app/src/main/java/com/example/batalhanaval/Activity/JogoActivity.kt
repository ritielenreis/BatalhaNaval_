package com.example.batalhanaval.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.children
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
        iniciarTabuleiros()


    }


    fun mudarTabuleiro(){


    }

    fun atirar(view: View) {

        //RECEBE O OBJETO BOTAO QUE DEU O CLIQUE (1 a 25)
        val cooderdana = view as ImageButton

        //RECEBE O NUMERO DA COORDENADA QUE DEU O CLIQUEI (1 A 25)
        val id = cooderdana.tag.toString().toInt()

        cooderdana.isEnabled = false
        cooderdana.setImageDrawable(null)
        cooderdana.setBackgroundResource(R.drawable.splash)


        val tabuleiroJogador = findViewById<GridLayout>(R.id.tabuleiroProprio)
        val tabuleiroOponente = findViewById<GridLayout>(R.id.tabuleiroInimigo)

        val botaoPassarTurno = findViewById<Button>(R.id.btnProx)

        botaoPassarTurno.isEnabled = true

        //var jogadorAtual = JogoController.jogadorAtual()
        //JogoController.posicionarNavio(id,jogadorAtual)


        /*
        if (JogoController.posicionarNavio(id,jogadorAtual)){

            //DEFINE AS IMAGENS DO BOTAO


            //TORNA O BOTÃO INATIVO

        }
        */


        //logica para ativar o botao de mudar turno
        //if()

    }



    //**************  BOTAO PARA PASSAR TURNO  **************
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

        if (JogoController.jogadorAtual() == 1){
            intent.putExtra("jogador","Jogador 1")
            val intent = Intent(this, TransicaoActivity::class.java)
        } else{
            intent.putExtra("jogador","Jogador 2")
        }


        startActivity(intent)
    }


    fun iniciarTabuleiros(){

        val switchTabuleiro = findViewById<Switch>(R.id.switch1)

        val tabuleiroJogador = findViewById<GridLayout>(R.id.tabuleiroProprio)
        val tabuleiroOponente = findViewById<GridLayout>(R.id.tabuleiroInimigo)
        val textTabuleiro = findViewById<TextView>(R.id.textTabuleiro)


        tabuleiroJogador.visibility = View.VISIBLE
        tabuleiroOponente.visibility = View.GONE

        //está definindo a função do botao
        switchTabuleiro.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                tabuleiroJogador.visibility = View.GONE
                tabuleiroOponente.visibility = View.VISIBLE
                textTabuleiro.setText("Tabuleiro Próprio")


            } else {
                tabuleiroJogador.visibility = View.VISIBLE
                tabuleiroOponente.visibility = View.GONE
                textTabuleiro.setText("Tabuleiro Inimigo")
            }
        }

        //**************************** DEFINE AS IMAGENS INICIAS E O ESTADO DO BOTAO (SE ATIROU PASSA A INATIVO) *********************************

        if(JogoController.jogadorAtual()==1){
            for (view in tabuleiroJogador.children) {
                if (view is ImageButton) {

                   // view.setImageDrawable(null)
                   // view.setBackgroundResource(R.drawable.naviointeiro)

                    val tag = view.tag?.toString()?.toInt()

                }
            }
        } else{
            for (view in tabuleiroOponente.children) {
                if (view is ImageButton) {
                  //  view.setImageDrawable(null)
                 //   view.setBackgroundResource(R.drawable.naviointeiro)
                    val tag = view.tag?.toString()?.toInt()
                    if(tag==1){

                    }
                }
            }
        }

    }










}



