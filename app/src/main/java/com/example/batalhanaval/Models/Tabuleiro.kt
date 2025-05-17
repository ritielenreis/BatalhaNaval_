package com.example.batalhanaval.Models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class Tabuleiro {

    // Lista de coordenadas observável
    private val _coordenadas = MutableLiveData<List<Coordenada>>()
    val coordenadas: LiveData<List<Coordenada>> get() = _coordenadas

    init {
        val novaLista = (0 until 25).map { id ->
            Coordenada(id = id, temNavio = false, foiAtacada = false)
        }
        _coordenadas.value = novaLista

        //resetarTabuleiro()
    }

    /*
    // Redefine todas as coordenadas do tabuleiro
    fun resetarTabuleiro() {
        val novaLista = (0 until 25).map { id ->
            Coordenada(id = id, temNavio = false, foiAtacada = false)
        }
        _coordenadas.value = novaLista
    }
    */


    // Posiciona um navio se ainda não houver um

    public fun posicionarNavio(id: Int): Boolean {
        val listaAtual = _coordenadas.value?.toMutableList() ?: return false
        val coordenada = listaAtual[id]

        if (coordenada.temNavio == false) {
            listaAtual[id] = coordenada.copy(temNavio = true)
            _coordenadas.value = listaAtual
            return true
        }
        return false
    }

    // Marca a coordenada como atacada, se ainda não foi
    fun atacarCoordenada(id: Int): Boolean {
        val listaAtual = _coordenadas.value?.toMutableList() ?: return false
        val coordenada = listaAtual[id]

        if (coordenada.foiAtacada == false) {
            listaAtual[id] = coordenada.copy(foiAtacada = true)
            _coordenadas.value = listaAtual
            return true
        }
        return false
    }

    // Verifica se todos os navios foram destruídos
    fun todosNaviosDestruidos(): Boolean {
        return _coordenadas.value?.none { it.temNavio && !it.foiAtacada } ?: false
    }
}