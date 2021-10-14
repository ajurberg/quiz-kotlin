package br.com.letscode.quizkotlin.repository

import br.com.letscode.quizkotlin.model.Filme
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FilmeRepository: JpaRepository<Filme, Int>
