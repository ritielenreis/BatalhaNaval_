package com.example.batalhanaval.Activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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


    }


    //**************  BOTAO PARA DEFINIR NAVIO  **************
    fun definirNavio(view: View) {
        val cooderdana =
            view as ImageButton                    //RECEBE O OBJETO BOTAO QUE DEU O CLIQUE (1 a 25)
        val id = cooderdana.tag.toString()
            .toInt()              //RECEBE O NUMERO DA COORDENADA QUE DEU O CLIQUEI (1 A 25)

        val jogadorAtual = JogoController.jogadorAtual()

        val botaoPassarTurno = findViewById<Button>(R.id.btn0)


        //************** DEFINIR LOGICA DE TODOS OS NAVIOS COLOCADOS PARA ATIVAR O BOTAO DE PASSAR TURNO **************
        if(jogadorAtual == 1 ){


        }else{

        }

        cooderdana.isEnabled = false
        cooderdana.setImageDrawable(null)

        //INPLEMENTAR A LOGICA DE ACERTO
        cooderdana.setBackgroundResource(R.drawable.naviointeiro)




        //************** DEFINIR LOGICA DE TODOS OS NAVIOS COLOCADOS PARA ATIVAR O BOTAO DE PASSAR TURNO **************
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
    fun proxJogador(view: View) {

        val intent = Intent(this, JogoActivity::class.java)
        /*
        JogoController.mudarTurno()
        if(JogoController.jogadorAtual() ==1){
            val intent = Intent(this, DefineNavioActivity::class.java)
        } else{

        }
        */

        startActivity(intent)
    }
}




/*
* // ADICIONAR as imagens nos botões BOTÕES DAS COORDENADAS
        val grid = findViewById<GridLayout>(R.id.grid)

        for (i in 0 until grid.childCount) {

            val botao = grid.getChildAt(i) as ImageButton


            botao.setOnClickListener { view ->
                val tag = view.tag.toString()  // ex: "2,3"

                val coordenada = tag.toInt()
                // Exemplo: mudar imagem

                botao.setImageResource(R.drawable.navioDestruido)


                // Agora você sabe qual botão foi clicado
                Toast.makeText(this, "Clicou em $linha, $coluna", Toast.LENGTH_SHORT).show()

            }
        }
* */