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

        mostrarTabuleiros()
        definirTextoInicial()
        definirImagens()

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

        //DEFINE O ON/OFF DA VISIBILIDADE NDOS TABULEIROS
        switchTabuleiro.setOnCheckedChangeListener { _, isChecked ->
            val mostrarProprio = !isChecked

            tabuleiroProprio.visibility = if (mostrarProprio) View.VISIBLE else View.GONE
            tabuleiroInimigo.visibility = if (mostrarProprio) View.GONE else View.VISIBLE
            textTabuleiro.text = if (mostrarProprio) "Tabuleiro Inimigo" else "Tabuleiro Próprio"
        };

        tabuleiroProprio.setVisibility(View.VISIBLE);
        tabuleiroInimigo.setVisibility(View.GONE);

    }

    private fun definirImagens(){
        val tabuleiroProprio = findViewById<GridLayout>(R.id.tabuleiroProprio)
        val tabuleiroInimigo = findViewById<GridLayout>(R.id.tabuleiroInimigo)

        var jogadorAtual = JogoController.jogadorAtual()
        val meuTabuleiro = if (jogadorAtual == 1) JogoController.getJogador1() else JogoController.getJogador2()
        val tabuleiroDoInimigo = if (jogadorAtual == 1) JogoController.getJogador2() else JogoController.getJogador1()


        for(item in tabuleiroDoInimigo){
            val coordenada = tabuleiroProprio.children.firstOrNull {
                it is ImageButton && it.tag == item.id.toString()// RETORNA O BOTÃO CORRESPONDENTE Á COORDENADA
            } as? ImageButton

            if(item.foiAtacada && item.temNavio){
                //SE FOI ATACADO E TEM NAVIO
                coordenada?.setImageDrawable(null)
                coordenada?.setBackgroundResource(R.drawable.naviodestruido)

            } else if(item.foiAtacada){
                //SE FOI ATACADO E NAO TEM NAVIO
                coordenada?.setImageDrawable(null)
                coordenada?.setBackgroundResource(R.drawable.splash)
            }
        }

        for(item in meuTabuleiro){
            val coordenada = tabuleiroInimigo.children.firstOrNull {
                it is ImageButton && it.tag == item.id.toString()
            } as? ImageButton

            if(item.foiAtacada && item.temNavio){
                //SE FOI ATACADO E TEM NAVIO

                coordenada?.setImageDrawable(null)
                coordenada?.setBackgroundResource(R.drawable.naviodestruido)

            } else if(item.foiAtacada){
                //SE FOI ATACADO E NAO TEM NAVIO
                coordenada?.setImageDrawable(null)
                coordenada?.setBackgroundResource(R.drawable.splash)

            } else if(item.temNavio){
                //SE NAO FOI ATACADO E TEM NAVIO
                coordenada?.setImageDrawable(null)
                coordenada?.setBackgroundResource(R.drawable.naviointeiro)
            }
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
            return //EVITA QUE O CODIGO O RESTANTE RODE DESNECESSARIAMENTE
        }

        coordenada.foiAtacada = true
        tiroRealizado = true
        btnCoordenada.isEnabled = false

        if (coordenada.temNavio) {
            JogoController.afundarNavio()
            btnCoordenada.setImageDrawable(null)
            btnCoordenada.setBackgroundResource(R.drawable.naviodestruido)
        } else {
            btnCoordenada.setImageDrawable(null)
            btnCoordenada.setBackgroundResource(R.drawable.splash)
        }

        if (JogoController.verificarFimJogo()){
            val vencedor = JogoController.jogadorAtual()
            val intent = Intent(this, GanhadorActivity::class.java)
            intent.putExtra("jogadorVencedor", vencedor)
            startActivity(intent)
            finish()
        }

        val botaoPassarTurno = findViewById<Button>(R.id.btnProx)
        botaoPassarTurno.isEnabled = true
    }

    fun proximoTurno(view: View) {
        JogoController.mudarTurno()
        tiroRealizado = false
        val intent = Intent(this, TransicaoActivity::class.java)
        startActivity(intent)
    }
}


