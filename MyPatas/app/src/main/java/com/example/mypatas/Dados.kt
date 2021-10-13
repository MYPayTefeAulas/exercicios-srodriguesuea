package com.example.mypatas

class Dados (val numeroLados: Int) {

    private var qntLados = mutableListOf<Int>()
    private var i = 1

    fun lancar(): String {
        while (i<= numeroLados){
            qntLados.add(i)
            i++
        }
        return "${qntLados.shuffled().first()}"

    }
}