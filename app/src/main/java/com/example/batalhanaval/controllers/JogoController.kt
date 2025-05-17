package com.example.batalhanaval.controllers

import com.example.batalhanaval.Models.Jogador

object JogoController {
    // ***********  VARIAVEIS  ***********
    private var jogador1: Jogador = Jogador()
    private var jogador2: Jogador = Jogador()

    private var vencedor: String =""    //UTILIZADA APENAS NO FINAL DO JOGO

    private var jogadorAtual: Int = 1   //UTILIZADO PARA REVESAR OS TURNOS (1 OU 2)

    private var jogoFinalizado: Boolean = false //UTILIZADO ENCERRAR O JOGO E DEFINIR O VENCEDOR

    private var naviosDefinidosRestantes1: Int = 2 //TOTAL DE NAVIOS QUE O JOGADOR TERÁ
    private var naviosDefinidosRestantes2: Int = 2 //TOTAL DE NAVIOS QUE O JOGADOR TERÁ
    private var tabuleiroDefinido1: Boolean = false //UTILIZADO PARA QUE O BOTÃO SEJA ATIVADO (AO TERMINAR DE DEFINIR OS NAVIOS)
    private var tabuleiroDefinido2: Boolean = false //UTILIZADO PARA QUE O BOTÃO SEJA ATIVADO (AO TERMINAR DE DEFINIR OS NAVIOS)


    // ***********  FUNCOES  ***********
    fun novoJogo(){
        this.jogador1 = Jogador()
        this.jogador2 = Jogador()
    }





/*
    fun posicionarNavio(id: Int, jogadoratual: Jogador):Boolean {

        //definir a coordenada do navio
        if(jogadoratual == jogador1){
        }

        //falta definir a logica de posicionar o navio e atualizar o tabuleiro definido se os naviosRestantes chegar a 0
    }

    fun tabuleiroDefinido():Boolean{


    }

*/
    fun jogadorAtual(): Int {
        if (jogadorAtual == 1){
            return 1
        } else{
            return 2
        }
    }


    fun mudarTurno(){

        if (jogadorAtual == 1){
            this.jogadorAtual =2
        } else{
            this.jogadorAtual = 1
        }

    }


    fun realizarTiro(){


    }




    fun posicionarNavioJogador(id: Int, Int: Jogador):Boolean {



        /*

        if (naviosDefinidosRestantes1 > 0 && jogadorAtual.tabuleiroProprio.value?.posicionarNavio(id) == true) {
            naviosRestantes.value = navios - 1
        }

        if (naviosRestantes.value == 0) {
            jogadorAdversario._tabuleiroDefinido.value = true
        }
        */
        return true
    }



}

    //Instanciar o jogos, Jogador, Tabuleiro e coordenadas

    //Trazer todos os métodos para cá e utilizálos nas Activitys
