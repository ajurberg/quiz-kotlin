package br.com.letscode.quizkotlin.service

import br.com.letscode.quizkotlin.exception.AuthenticationException
import br.com.letscode.quizkotlin.exception.LoginException
import br.com.letscode.quizkotlin.model.Usuario
import br.com.letscode.quizkotlin.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(val repository: UsuarioRepository) {

    fun create(usuario: Usuario): Usuario = run {
        validarUsuarioCadastrado(usuario.login)
        repository.save(usuario).also {
            println("Usuario criado com sucesso")
        }
    }

    fun validarUsuarioCadastrado(login: String) {
        repository.findByLogin(login).also {
            if (it !== null) throw LoginException("Login já cadastrado")
        }
    }

    fun getUsuarioByLogin(login: String): Usuario? = repository.findByLogin(login)

    fun getAll(): List<Usuario> = repository.findAll()

    fun validarLogin(usuario: Usuario): Usuario = run {
        val usuarioBanco = repository.findByLogin(usuario.login)
        if (usuarioBanco === null || usuarioBanco.senha != usuario.senha)
            throw AuthenticationException("Login e/ou senha inválidos.")
        usuarioBanco
    }

}