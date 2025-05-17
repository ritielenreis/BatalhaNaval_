package com.example.batalhanaval.controllers

import com.example.batalhanaval.Models.Jogador

object JogoController {
    // ***********  VARIAVEIS  ***********
    var jogador1: Jogador = Jogador()
    var jogador2: Jogador = Jogador()
    var vencedor: String =""
    var jogadorAtual: Int = 1
    var jogoFinalizado: Boolean = false
    var naviosRestantes1: Int = 2
    var naviosRestantes2: Int = 2
    var tabuleiroDefinido1: Boolean = false
    var tabuleiroDefinido2: Boolean = false

    // ***********  FUNCOES  ***********
    fun novoJogo(){
        this.jogador1 = Jogador()
        this.jogador2 = Jogador()
    }

    fun realizarTiro(){


    }

    fun posicionarNavioJogador(id: Int, jogadorAtual: Jogador, jogadorAdversario: Jogador) {
        /*
        val navios = jogadorAdversario.naviosRestantes.value ?: return

        if (navios > 0 && jogadorAtual.tabuleiroProprio.value?.posicionarNavio(id) == true) {
            naviosRestantes.value = navios - 1
        }
        if (naviosRestantes.value == 0) {
            jogadorAdversario._tabuleiroDefinido.value = true
        }
        */
    }



}

    //Instanciar o jogos, Jogador, Tabuleiro e coordenadas

    //Trazer todos os métodos para cá e utilizálos nas Activitys
