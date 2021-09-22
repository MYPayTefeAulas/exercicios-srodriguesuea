package com.example.mypatas

class Agenda {
    private val listacontatos = mutableListOf<Pessoa>()
    private var indiceAtual = 0

    fun salvarContato (novoContato: Pessoa){
        listacontatos.add(novoContato)
    }
    fun imprimirNomeContatos():String{
        if(indiceAtual == listacontatos.size)
            indiceAtual = 0
        val pessoaAtual = listacontatos[indiceAtual]
        indiceAtual++
        return "${pessoaAtual.nome}"
    }
    fun imprimirTelefoneContatos():String{
        indiceAtual-=1
        if(indiceAtual == listacontatos.size)
            indiceAtual = 0
        val pessoaAtual = listacontatos[indiceAtual]
        indiceAtual++
        return "${pessoaAtual.telefone}"
    }
    fun deletarContato(){
        if(indiceAtual >=1){
            indiceAtual-=1
            val pessoaAtual = listacontatos[indiceAtual]
            listacontatos.remove(pessoaAtual)
        } else{
            val pessoaAtual = listacontatos[indiceAtual]
            listacontatos.remove(pessoaAtual)
        }

    }
    fun retornarNumeroContato():Int{
        return listacontatos.size
    }
}