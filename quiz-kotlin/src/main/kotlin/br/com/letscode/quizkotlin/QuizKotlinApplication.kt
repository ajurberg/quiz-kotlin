package br.com.letscode.quizkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class QuizKotlinApplication

fun main(args: Array<String>) {
	runApplication<QuizKotlinApplication>(*args)
}
