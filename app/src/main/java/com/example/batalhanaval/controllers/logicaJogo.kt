package com.example.batalhanaval.controllers

import com.example.batalhanaval.Models.Jogador
import com.example.batalhanaval.Models.Jogo

object Lixo {}

/*

    Troca de Tabuleiro
    private fun atualizarTabuleiro(tabuleiro: GridLayout, jogador: List<Coordenada>) {
        for (view in tabuleiro.children) {
            if (view is ImageButton) {
                val id = try { view.tag.toString().toInt() } catch (e: Exception) { -1 }
                if (id == -1) continue


                val coordenada = jogador[id]

                when {
                    coordenada.foiAtacada && coordenada.temNavio -> view.setImageResource(R.drawable.naviodestruido)
                    coordenada.foiAtacada && !coordenada.temNavio -> view.setImageResource(R.drawable.splash)
                    !coordenada.foiAtacada && coordenada.temNavio -> view.setImageResource(R.drawable.naviointeiro)
                    else -> view.setImageResource(R.drawable.borda)
                }
            }
        }
    }



    switchTabuleiro.setOnCheckedChangeListener { _, isChecked ->
            tabuleiroJogador.visibility = if (isChecked) View.GONE else View.VISIBLE
            tabuleiroOponente.visibility = if (isChecked) View.VISIBLE else View.GONE
            textTabuleiro.text = if (isChecked) "Tabuleiro Próprio" else "Tabuleiro Inimigo"


            //**************************** DEFINE AS IMAGENS INICIAS E O ESTADO DO BOTAO (SE ATIROU PASSA A INATIVO) *********************************
            if (isChecked) {
                var jogadorInimigo = if (JogoController.jogadorAtual() == 1) JogoController.getJogador2() else JogoController.getJogador1()
                atualizarTabuleiro(tabuleiroOponente, jogadorInimigo) // função que atualiza só as views do oponente

            } else {
                var jogadorAtual = if (JogoController.jogadorAtual() == 1) JogoController.getJogador1() else JogoController.getJogador2()
                atualizarTabuleiro(tabuleiroJogador, jogadorAtual)
            }

        }

private fun atualizarTabuleiro(tabuleiro: GridLayout, jogador: List<Coordenada>) {
        for (view in tabuleiro.children) {
            if (view is ImageButton) {
                val id = try { view.tag.toString().toInt() } catch (e: Exception) { -1 }
                if (id == -1) continue


                val coordenada = jogador[id]

                when {
                    coordenada.foiAtacada && coordenada.temNavio -> view.setImageResource(R.drawable.naviodestruido)
                    coordenada.foiAtacada && !coordenada.temNavio -> view.setImageResource(R.drawable.splash)
                    !coordenada.foiAtacada && coordenada.temNavio -> view.setImageResource(R.drawable.naviointeiro)
                    else -> view.setImageResource(R.drawable.borda)
                }
            }
        }
    }

}
    //Instanciar o jogos, Jogador, Tabuleiro e coordenadas

    //Trazer todos os métodos para cá e utilizálos nas Activitys

 */