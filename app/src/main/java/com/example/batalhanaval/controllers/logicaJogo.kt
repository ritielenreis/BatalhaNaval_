package com.example.batalhanaval.controllers

import com.example.batalhanaval.Models.Jogador
import com.example.batalhanaval.Models.Jogo

object ControladorJogo {

    // ***********  VARIAVEIS  ***********
    lateinit var jogador1: Jogador
    lateinit var jogador2: Jogador

    var jogadorAtual: Int = 1
    var jogoFinalizado: Boolean = false

    lateinit var vencedor: String

    var naviosRestantes1: Int = 0
    var naviosRestantes2: Int = 0

    var tabuleiroDefinido1: Boolean = false
    var tabuleiroDefinido2: Boolean = false



    // ***********  FUNCOES  ***********
    fun iniciarJogo() {
        jogador1 = Jogador()
        jogador2 = Jogador()

    }

    fun resetarJogo(){
        this.jogador1 = Jogador()
        this.jogador2 = Jogador()
    }

    fun realizarTiro(){
    }
}

    //Instanciar o jogos, Jogador, Tabuleiro e coordenadas

    //Trazer todos os métodos para cá e utilizálos nas Activitys
