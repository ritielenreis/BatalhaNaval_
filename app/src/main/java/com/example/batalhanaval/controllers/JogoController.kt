package com.example.batalhanaval.controllers

import com.example.batalhanaval.Models.Coordenada
import kotlin.collections.mutableListOf

object JogoController {
    // ***********  VARIAVEIS  ***********
    private val jogador1 = mutableListOf<Coordenada>()
    private val jogador2 = mutableListOf<Coordenada>()

    private var jogadorAtual: Int = 1   //UTILIZADO PARA REVESAR OS TURNOS (1 OU 2)

    private var naviosJogador1: Int = 2  //TOTAL DE NAVIOS QUE O JOGADOR TERÁ
    private var naviosJogador2: Int = 2  //TOTAL DE NAVIOS QUE O JOGADOR TERÁ

    private var naviosAfundados1: Int = 0  //TOTAL DE NAVIOS QUE O JOGADOR TERÁ
    private var naviosAfundados2: Int = 0  //TOTAL DE NAVIOS QUE O JOGADOR TERÁ

    private var tabuleiroDefinido1: Boolean = false //UTILIZADO PARA QUE O BOTÃO SEJA ATIVADO (AO TERMINAR DE DEFINIR OS NAVIOS)
    private var tabuleiroDefinido2: Boolean = false //UTILIZADO PARA QUE O BOTÃO SEJA ATIVADO (AO TERMINAR DE DEFINIR OS NAVIOS)

    // ***********  FUNCOES  ***********
    fun novoJogo(){
        for (id in 1..25) {
            this.jogador1.add(Coordenada(id = id))
            this.jogador1[id].temNavio = false
            this.jogador1[id].foiAtacada = false
        }
        for (id in 1..25) {
            this.jogador2.add(Coordenada(id = id))
            this.jogador2[id].temNavio = false
            this.jogador2[id].foiAtacada = false
        }
        this.jogadorAtual = 1
        this.naviosJogador1 = 2
        this.naviosJogador2 = 2
        this.naviosAfundados1 = 0
        this.naviosAfundados2 = 0
        this.tabuleiroDefinido1 = false
        this.tabuleiroDefinido2 = false
    }

    fun getJogador1(): List<Coordenada> {
        return jogador1
    }

    fun getJogador2(): List<Coordenada> {
        return jogador2
    }

    fun posicionarNavio(id: Int, jogadorAtual: Int): Boolean {
        val coordenada = if (jogadorAtual == 1) jogador1[id] else jogador2[id]

        if (!coordenada.temNavio) {
            coordenada.temNavio = true

            if (jogadorAtual == 1) {
                if (--naviosJogador1 == 0) tabuleiroDefinido1 = true
            } else {
                if (--naviosJogador2 == 0) tabuleiroDefinido2 = true
            }
            return true
        }

        return false
    }

    fun afundarNavio(){
        if (jogadorAtual == 1) ++naviosAfundados2 else ++naviosAfundados1
    }

    fun verificarFim(): Boolean{
        if((jogadorAtual == 1) && naviosAfundados2 == 2) return true
        else if((jogadorAtual == 2) && naviosAfundados1 == 2) return true
        else return false
    }

    fun naviosRestates(jogadorAtual:Int):Int {
        return if (jogadorAtual == 1) naviosJogador1 else naviosJogador2
    }

    fun tabuleiroDefinido(jogadorAtual :Int):Boolean{
        return if (jogadorAtual == 1) tabuleiroDefinido1 else tabuleiroDefinido2
    }

    fun jogadorAtual(): Int {
        jogadorAtual = if (jogadorAtual == 1) return 1 else return 2
    }

    fun mudarTurno(){
        jogadorAtual = if (jogadorAtual == 1) 2 else 1
    }


}
