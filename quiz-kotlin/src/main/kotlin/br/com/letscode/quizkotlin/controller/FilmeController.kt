package br.com.letscode.quizkotlin.controller

import br.com.letscode.quizkotlin.service.FilmeService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("filme")
class FilmeController(
    val service: FilmeService
)