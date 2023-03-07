package com.bhkpo.springboot.helloboot

interface HelloRepository {
    fun findHello(name: String): Hello?

    fun increaseCount(name: String)

    fun countOf(name: String): Int {
        return findHello(name)?.count ?: 0
    }
}