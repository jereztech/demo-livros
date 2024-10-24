package br.com.mult_e.desafio.repository;

import br.com.mult_e.desafio.model.Pagina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaginaRepository extends JpaRepository<Pagina, Long> {
}
