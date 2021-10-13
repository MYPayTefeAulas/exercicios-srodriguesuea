package com.example.mypatas

import com.example.mypatas.Pessoa

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
    fun existeTelefone(telefone: String): Boolean{
        for (contato in listacontatos){
           if (contato.telefone == telefone)
               return true
        }
        return false
    }

    fun existeContato(contatoExistente: Pessoa): Boolean {
        for (contato in listacontatos){
            if (contato.nome == contatoExistente.nome || contato.telefone == contatoExistente.telefone)
                return true
        }
        return false
    }
    fun imprimirNomePesquisa(contatoExistente: Pessoa):String{
        var encontrou: String = ""
        for (contato in listacontatos){
            if (contato.nome == contatoExistente.nome){
                encontrou = contato.nome
                break
            }
        }
        return encontrou
    }

    fun imprimirTelefonePesquisa(contatoExistente: Pessoa):String{
        var encontrou: String = ""
        for (contato in listacontatos){
            if (contato.nome == contatoExistente.nome){
                encontrou = contato.telefone.toString()
                break
            }
        }
        return encontrou
    }

    fun pesquisarContato(contatoExistente: Pessoa): Boolean {
        var encontrou = false
        for (contato in listacontatos){
            if (contato.nome == contatoExistente.nome){
                encontrou = true
                break
            }
        }
        return encontrou
    }

    fun checarVazio(): Boolean{
        return listacontatos.isEmpty()
    }
    fun checarContatoRepetido (contato: Pessoa): Boolean{
        var resultado: Boolean = false

        for (lista in listacontatos){
            if(lista.telefone == contato.telefone){
                resultado = true
                break
            }
        }
        return resultado
    }

}