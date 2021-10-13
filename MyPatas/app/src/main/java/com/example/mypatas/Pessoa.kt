package com.example.mypatas

class Pessoa(val nome: String, val idade: Int?, val telefone: String?) {

    fun verificaNomeVazio(): Boolean{
        return nome == ""
    }
    fun verificaTelefoneVazio(): Boolean{
        return telefone == ""
    }
}
