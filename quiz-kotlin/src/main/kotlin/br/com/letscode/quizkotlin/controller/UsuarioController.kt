package br.com.letscode.quizkotlin.controller

import br.com.letscode.quizkotlin.dto.UsuarioCreateDTO
import br.com.letscode.quizkotlin.dto.UsuarioDTO
import br.com.letscode.quizkotlin.model.Usuario
import br.com.letscode.quizkotlin.service.UsuarioService
import br.com.letscode.quizkotlin.utils.convertToDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("usuario")
class UsuarioController(val service: UsuarioService) {

    @PostMapping
    fun create(@RequestBody usuarioCreateDTO: UsuarioCreateDTO): ResponseEntity<UsuarioDTO> = run {
        val usuario = Usuario(
            nome = usuarioCreateDTO.nome,
            login = usuarioCreateDTO.login,
            senha = usuarioCreateDTO.senha
        )
        val usuarioDTO = service.create(usuario).convertToDTO()
        ResponseEntity.ok(usuarioDTO)
    }

    @GetMapping
    fun getAll(): List<UsuarioDTO> = service.getAll().map(Usuario::convertToDTO)

}