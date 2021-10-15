package br.com.letscode.quizkotlin.service

import br.com.letscode.quizkotlin.repository.FilmeRepository
import org.springframework.stereotype.Service

@Service
class FilmeService(val repository: FilmeRepository)