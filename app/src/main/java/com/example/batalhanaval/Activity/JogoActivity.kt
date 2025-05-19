package com.example.batalhanaval.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.Switch
import androidx.appcompat.widget.SwitchCompat
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

        mostrarTabuleiros()
        definirTextoInicial()
    }
    var tiroRealizado = false


    //**************  DEFINE O TEXTO DO JOGADOR AO INICIAR A ACTIVITY  **************
    private fun definirTextoInicial() {
        val textoTabuleiro = findViewById<TextView>(R.id.textJogadorTiro)
        val jogadorAtual = JogoController.jogadorAtual()
        textoTabuleiro.setText("Jogador $jogadorAtual")
    }

    private fun mostrarTabuleiros() {
        val tabuleiroProprio = findViewById<GridLayout>(R.id.tabuleiroProprio)
        val tabuleiroInimigo = findViewById<GridLayout>(R.id.tabuleiroInimigo)
        val textTabuleiro = findViewById<TextView>(R.id.textTabuleiro)
        val switchTabuleiro = findViewById<Switch>(R.id.switch1)

        var jogadorAtual = JogoController.jogadorAtual()
        val meuTabuleiro =
            if (jogadorAtual == 1) JogoController.getJogador1() else JogoController.getJogador2()
        val tabuleiroDoInimigo =
            if (jogadorAtual == 1) JogoController.getJogador2() else JogoController.getJogador1()


        //está definindo a função do botao de troca de tabuleiro
        switchTabuleiro.setOnCheckedChangeListener { _, isChecked ->
            val mostrarProprio = !isChecked

            tabuleiroProprio.visibility = if (mostrarProprio) View.VISIBLE else View.GONE
            tabuleiroInimigo.visibility = if (mostrarProprio) View.GONE else View.VISIBLE
            textTabuleiro.text = if (mostrarProprio) "Tabuleiro Próprio" else "Tabuleiro Inimigo"
        };

        tabuleiroProprio.setVisibility(View.VISIBLE);
        tabuleiroInimigo.setVisibility(View.GONE);

        //**************************** DEFINE AS IMAGENS INICIAS E O ESTADO DO BOTAO (SE ATIROU PASSA A INATIVO) *********************************


        for (view in tabuleiroProprio.children) {
            """
            if (view is ImageButton) {
                val id = view.tag.toString().toInt()
                val coordenada = meuTabuleiro[id]  // jogador1 aqui

                when {
                    coordenada.foiAtacada && coordenada.temNavio -> view.setImageResource(R.drawable.naviodestruido)
                    coordenada.foiAtacada && !coordenada.temNavio -> view.setImageResource(R.drawable.splash)
                    !coordenada.foiAtacada && coordenada.temNavio -> view.setImageResource(R.drawable.naviointeiro)
                    else -> view.setImageDrawable(null)
                }
            }"""
        }

        for (view in tabuleiroInimigo.children) {
"""
            if (view is ImageButton) {
                val id = view.tag.toString().toInt()
                val coordenada = tabuleiroDoInimigo[id]

                when {
                    coordenada.foiAtacada && coordenada.temNavio -> view.setImageResource(R.drawable.naviodestruido)
                    coordenada.foiAtacada && !coordenada.temNavio -> view.setImageResource(R.drawable.splash)
                    else -> view.setImageDrawable(null)
                }
            }"""
        }
    }



    fun atirar(view: View) {

        //RECEBE O OBJETO BOTAO QUE DEU O CLIQUE (1 a 25)
        val btnCoordenada = view as ImageButton

        //RECEBE O NUMERO DA COORDENADA QUE DEU O CLIQUE (1 A 25)
        val id = btnCoordenada.tag.toString().toInt()

        val jogadorAdversario = if (JogoController.jogadorAtual()== 1) JogoController.getJogador2() else JogoController.getJogador1() //
        val coordenada = jogadorAdversario[id]                                                                                        //

        if (tiroRealizado || coordenada.foiAtacada){
            btnCoordenada.isEnabled = false
            return

        }
        coordenada.foiAtacada = true
        tiroRealizado = true
        btnCoordenada.isEnabled = false

        if (coordenada.temNavio) {
            JogoController.afundarNavio()
            btnCoordenada.setBackgroundResource(R.drawable.naviodestruido)
        } else {
            btnCoordenada.setBackgroundResource(R.drawable.splash)
        }

        if (JogoController.verificarFim()){
            val vencedor = JogoController.jogadorAtual()
            val intent = Intent(this, GanhadorActivity::class.java)
            intent.putExtra("jogadorVencedor", vencedor)
            startActivity(intent)
            finish()
        }

        val botaoPassarTurno = findViewById<Button>(R.id.btnProx)
        botaoPassarTurno.isEnabled = true



    }

    //**************  BOTAO PARA PASSAR TURNO  **************
    fun proximoTurno(view: View) {
        JogoController.mudarTurno()
        tiroRealizado = false
        val intent = Intent(this, TransicaoActivity::class.java)
        startActivity(intent)
    }
}


