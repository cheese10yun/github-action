package com.github.action

import kong.unirest.Unirest
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDateTime

@Configuration
class SimpleJobConfig(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory
) {

    @Bean
    fun simpleJob(): Job {
        return jobBuilderFactory.get("simpleJob")
            .incrementer(RunIdIncrementer())
            .start(simpleStep())
            .build()
    }

    private fun simpleStep(): Step {
        return stepBuilderFactory.get("simpleStep1")
            .tasklet { _, _ ->

                Unirest.post("https://hooks.slack.com/services/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")
                    .header("Content-Type", "application/json")
                    .body("""
                        {
                            "text": "${LocalDateTime.now()}"
                        }
                    """.trimIndent())
                    .asString()

                RepeatStatus.FINISHED
            }
            .build()
    }
}