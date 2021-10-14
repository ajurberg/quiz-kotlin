package br.com.letscode.quizkotlin.repository

import br.com.letscode.quizkotlin.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository: JpaRepository<Usuario, Int>