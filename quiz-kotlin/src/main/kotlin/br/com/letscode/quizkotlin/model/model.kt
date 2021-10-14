package br.com.letscode.quizkotlin.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table
data class Filme(
    @Id @GeneratedValue val id: Int,
    val nome: String,
    val ano: Int,
    val nota: Float
    )

@Entity
@Table
data class Usuario(
    @Id @GeneratedValue val id: Int,
    val nome: String,
    val login: String,
    val senha: String,
    val qntVida: Int,
    val pontos: Int
    )