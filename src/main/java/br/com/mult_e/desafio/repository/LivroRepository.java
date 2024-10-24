package br.com.mult_e.desafio.repository;

import br.com.mult_e.desafio.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
