package com.github.action

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ActionApplication

fun main(args: Array<String>) {
    runApplication<ActionApplication>(*args)
}
