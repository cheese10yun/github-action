package com.github.action

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableBatchProcessing
class ActionApplication

fun main(args: Array<String>) {
    runApplication<ActionApplication>(*args)
}