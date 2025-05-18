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
import com.example.batalhanaval.Models.Coordenada
import com.example.batalhanaval.Models.Jogo
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
    var jogador = JogoController.jogadorAtual()

    //**************  DEFINE O TEXTO DO JOGADOR AO INICIAR A ACTIVITY  **************
    private fun definirTextoInicial() {
        val textoTabuleiro = findViewById<TextView>(R.id.textJogadorTiro)
        val jogadorAtual = JogoController.jogadorAtual()
        textoTabuleiro.setText("Jogador $jogadorAtual")
    }

    private fun mostrarTabuleiros(){
        val switchTabuleiro = findViewById<Switch>(R.id.switch1)

        val tabuleiroJogador = findViewById<GridLayout>(R.id.tabuleiroProprio)
        val tabuleiroOponente = findViewById<GridLayout>(R.id.tabuleiroInimigo)
        val textTabuleiro = findViewById<TextView>(R.id.textTabuleiro)

        tabuleiroJogador.visibility = View.VISIBLE
        tabuleiroOponente.visibility = View.GONE

        //está definindo a função do botao de troca de tabuleiro
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
                    val id = view.tag.toString().toInt()
                    """
                    val jogador = if (JogoController.jogadorAtual()== 1) JogoController.getJogador1() else JogoController.getJogador2() //
                    val coordenada = jogador[id]
                    when {

                        coordenada.foiAtacada && coordenada.temNavio -> view.setImageResource(R.drawable.naviodestruido)
                        coordenada.foiAtacada && !coordenada.temNavio -> view.setImageResource(R.drawable.splash)
                    }"""
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

    fun atirar(view: View) {

        //RECEBE O OBJETO BOTAO QUE DEU O CLIQUE (1 a 25)
        val btnCoordenada = view as ImageButton

        //RECEBE O NUMERO DA COORDENADA QUE DEU O CLIQUE (1 A 25)
        val id = btnCoordenada.tag.toString().toInt()

        val jogador = if (JogoController.jogadorAtual()== 1) JogoController.getJogador1() else JogoController.getJogador2() //
        val coordenada = jogador[id]                                                                                        //



        if (tiroRealizado || coordenada.foiAtacada){
            btnCoordenada.isEnabled = false

        }else if (!coordenada.foiAtacada && !tiroRealizado) {
            coordenada.foiAtacada = true
            tiroRealizado = true
            btnCoordenada.isEnabled = false
            btnCoordenada.setBackgroundResource(R.drawable.splash)
            JogoController.afundarNavio()

            if (JogoController.verificarFim()==true){
                val vencedor = JogoController.jogadorAtual()
                val intent = Intent(this, GanhadorActivity::class.java)
                intent.putExtra("jogadorVencedor", vencedor)
                startActivity(intent)
                finish()
            }

            val tabuleiroJogador = findViewById<GridLayout>(R.id.tabuleiroProprio)
            val tabuleiroOponente = findViewById<GridLayout>(R.id.tabuleiroInimigo)


            val botaoPassarTurno = findViewById<Button>(R.id.btnProx)
            botaoPassarTurno.isEnabled = true

            /*
        if (JogoController.posicionarNavio(id,jogadorAtual)){
            //DEFINE AS IMAGENS DO BOTAO
            //TORNA O BOTÃO INATIVO}
        */
            //logica para ativar o botao de mudar turno
            //if()
        }

    }


    //**************  BOTAO PARA PASSAR TURNO  **************
    fun proximoTurno(view: View) {
        JogoController.mudarTurno()
        tiroRealizado = false
        val intent = Intent(this, TransicaoActivity::class.java)
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

