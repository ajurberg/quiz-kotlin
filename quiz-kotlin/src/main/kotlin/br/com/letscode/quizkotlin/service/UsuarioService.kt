package br.com.letscode.quizkotlin.service

import br.com.letscode.quizkotlin.exception.LoginException
import br.com.letscode.quizkotlin.model.Usuario
import br.com.letscode.quizkotlin.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    val repository: UsuarioRepository
) {
    fun create(usuario: Usuario): Usuario = run {
        validarLogin(usuario.login)
        repository.save(usuario).also {
            println("Usuario criado com sucesso")
        }
    }

    fun validarLogin(login: String) {
        repository.findByLogin(login).also {
            if (it !== null) throw LoginException("Login já cadastrado")
        }
    }

}