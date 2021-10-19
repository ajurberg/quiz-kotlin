package br.com.letscode.quizkotlin.model

import javax.persistence.*

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
    @Id @GeneratedValue val id: Int = 0,
    val nome: String,
    @Column(name = "login") val login: String,
    val senha: String,
    val qntVida: Int = 3,
    val pontos: Int = 0
    )