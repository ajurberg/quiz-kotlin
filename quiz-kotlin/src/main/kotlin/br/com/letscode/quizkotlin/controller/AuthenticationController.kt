package br.com.letscode.quizkotlin.controller

import br.com.letscode.quizkotlin.dto.UsuarioAutenticacaoDTO
import br.com.letscode.quizkotlin.model.Usuario
import br.com.letscode.quizkotlin.service.UsuarioService
import br.com.letscode.quizkotlin.utils.JwtTokenUtil
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

data class JWT(
    val token: String
)

@RestController
@RequestMapping("authentication")
class AuthenticationController(val service: UsuarioService,
                               val authenticationManager: AuthenticationManager) {

    @PostMapping
    fun login(@RequestBody usuario: UsuarioAutenticacaoDTO): ResponseEntity<JWT> = run {
        val jwt = service.validarLogin(
            Usuario(
            login = usuario.login,
            senha = usuario.senha,
            nome = "")
        ).let {
            setUser(it)
            JwtTokenUtil.generateToken(it)
        }
        ResponseEntity.ok(JWT(jwt))
    }

    fun setUser(usuario: Usuario) {
        authenticationManager.authenticate(UsernamePasswordAuthenticationToken(usuario.login, usuario.senha))
    }

}