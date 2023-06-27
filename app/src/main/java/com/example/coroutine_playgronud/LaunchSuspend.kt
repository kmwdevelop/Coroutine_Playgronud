package com.example.coroutine_playgronud

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

suspend fun doWork1(): String {
    delay(1000L)
    return "Work1"
}

suspend fun doWork2(): String {
    delay(1000L)
    return "Work2"
}

private fun worksInSerial(): Job {
    return GlobalScope.launch {
        val one = doWork1()
        println("Kotlin One : $one")
        val two = doWork2()
        println("Kotlin Two : $two")
    }
}

fun main() {
    runBlocking {

        val time = measureTimeMillis {
            worksInSerial().join()
        }

        println(time)
    }
}