package br.com.letscode.quizkotlin.dto

data class UsuarioDTO(
    val nome: String = "",
    val login: String = ""
    )

data class UsuarioCreateDTO(
    val nome: String = "",
    val login: String = "",
    val senha: String = ""
)