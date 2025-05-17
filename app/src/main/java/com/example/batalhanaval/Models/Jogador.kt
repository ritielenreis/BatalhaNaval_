package com.example.batalhanaval.Models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class Jogador(
        tabuleiroProprio: Tabuleiro = Tabuleiro()
        ) : ViewModel() {

    val tabuleiroProprio = MutableLiveData(tabuleiroProprio)

    fun definirNavio(id: Int){

       //this.tabuleiroProprio.posicionarNavio(id)
    }
}