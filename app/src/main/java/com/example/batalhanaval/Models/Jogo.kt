package com.example.batalhanaval.Models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Jogo(
    jogador1Inicial: Jogador = Jogador(),
    jogador2Inicial: Jogador = Jogador(),
    jogadorAtualInicial:Jogador = Jogador()
) : ViewModel() {

    private val _jogador1 = MutableLiveData(jogador1Inicial)
    val jogador1: LiveData<Jogador> get() = _jogador1

    private val _jogador2 = MutableLiveData(jogador2Inicial)
    val jogador2: LiveData<Jogador> get() = _jogador2

    private val _jogoFinalizado = MutableLiveData(false)
    val jogoFinalizado: LiveData<Boolean> get() = _jogoFinalizado

    private val _jogadorAtual = MutableLiveData(jogadorAtualInicial)
    val jogadorAtual: LiveData<Jogador> get() = _jogadorAtual

    fun alternarTurno(){

    }
    fun reiniciarJogo() {
        _jogador1.value = Jogador()
        _jogador2.value = Jogador()
        _jogoFinalizado.value = false
    }

    fun checarFim() {
        val jogador1 = _jogador1.value
        val jogador2 = _jogador2.value

        if (jogador1?.tabuleiroProprio?.value?.todosNaviosDestruidos() == true ||
            jogador2?.tabuleiroProprio?.value?.todosNaviosDestruidos() == true) {
            _jogoFinalizado.value = true
        }
    }
}