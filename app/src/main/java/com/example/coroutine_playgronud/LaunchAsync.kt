package com.example.coroutine_playgronud

import kotlinx.coroutines.*


private fun worksInParallel(): Job {
    val one = GlobalScope.async {
        doWork1()
    }

    val two = GlobalScope.async {
        doWork2()
    }

    return GlobalScope.launch {
        val combined = one.await() + "_" + two.await()
        println("Kotlin Combined: $combined")
    }
}

fun main() {
    runBlocking {
        worksInParallel().join()
    }

}