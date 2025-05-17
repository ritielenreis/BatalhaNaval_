package com.example.batalhanaval.Models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class Jogador(
    tabuleiroProprio: Tabuleiro = Tabuleiro()
) : ViewModel() {

    val tabuleiroProprio = MutableLiveData(tabuleiroProprio)

    private val _naviosRestantes = MutableLiveData(2)
    val naviosRestantes: LiveData<Int> get() = _naviosRestantes

    private val _tabuleiroDefinido = MutableLiveData(false)
    val tabuleiroDefinido: LiveData<Boolean> get() = _tabuleiroDefinido


    fun posicionarNavioJogador(id: Int,jogadorAtual:Jogador, jogadorAdversario:Jogador) {
        val navios = jogadorAdversario._naviosRestantes.value ?: return

        if (navios > 0 && jogadorAtual.tabuleiroProprio.value?.posicionarNavio(id) == true) {
            _naviosRestantes.value = navios - 1
        }

        if (naviosRestantes.value == 0) {
            jogadorAdversario._tabuleiroDefinido.value = true
        }
}

}