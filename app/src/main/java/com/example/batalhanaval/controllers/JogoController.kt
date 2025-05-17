package com.example.batalhanaval.controllers

import com.example.batalhanaval.Models.Coordenada
import com.example.batalhanaval.Models.Jogador

object JogoController {
    // ***********  VARIAVEIS  ***********
    private val jogador1 = mutableListOf<Coordenada>()
    private val jogador2 = mutableListOf<Coordenada>()

    private var jogadorAtual: Int = 1   //UTILIZADO PARA REVESAR OS TURNOS (1 OU 2)

    private var naviosJogador1: Int = 3  //TOTAL DE NAVIOS QUE O JOGADOR TERÁ
    private var naviosJogador2: Int = 3  //TOTAL DE NAVIOS QUE O JOGADOR TERÁ

    private var tabuleiroDefinido1: Boolean = false //UTILIZADO PARA QUE O BOTÃO SEJA ATIVADO (AO TERMINAR DE DEFINIR OS NAVIOS)
    private var tabuleiroDefinido2: Boolean = false //UTILIZADO PARA QUE O BOTÃO SEJA ATIVADO (AO TERMINAR DE DEFINIR OS NAVIOS)


    // ***********  FUNCOES  ***********
    fun novoJogo(){
        for (id in 1..25) {
            this.jogador1.add(Coordenada(id = id))
        }
        for (id in 1..25) {
            this.jogador2.add(Coordenada(id = id))
        }
        this.jogadorAtual = 1
        this.naviosJogador1 = 3
        this.naviosJogador2 = 3
        this.tabuleiroDefinido1 = false
        this.tabuleiroDefinido2 = false
    }

    fun posicionarNavio(id: Int, jogador: Int):Boolean {

        if (jogador == 1){
            var coordenada = jogador1[id]
            if ( !coordenada.temNavio){
                coordenada.temNavio = true
                naviosJogador1 -= 1

                if(naviosJogador1==0){
                    tabuleiroDefinido1 = true
                    return true
                }
                return true
            }
        }
        else{
            var coordenada = jogador2[id]
            if ( !coordenada.temNavio ){
                coordenada.temNavio = true
                naviosJogador2 -= 1

                if(naviosJogador2==0){
                    tabuleiroDefinido2 = true
                    return true
                }
                return true
            }
        }
        return false
    }

    fun naviosRestates(jogador:Int):Int {
        if (jogador==1){
            return naviosJogador1
        } else{
            return naviosJogador2
        }
    }

    fun tabuleiroDefinido(jogador :Int):Boolean{
        if (jogador==1){
            if (tabuleiroDefinido1){
                return true
            }

        }else
        {
            if (tabuleiroDefinido2){
                return true
            }
        }
        return false
    }

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

}
