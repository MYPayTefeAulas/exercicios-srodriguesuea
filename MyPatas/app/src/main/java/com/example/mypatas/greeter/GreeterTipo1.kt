package com.example.mypatas.greeter

class GreeterTipo1 (val cumprimento: String) {

    fun greet(nome: String): String {
        val cumprimentoCompleto = "$cumprimento $nome"
        return  cumprimentoCompleto
    }
}