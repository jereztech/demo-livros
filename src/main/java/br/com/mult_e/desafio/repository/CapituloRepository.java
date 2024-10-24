package br.com.mult_e.desafio.repository;

import br.com.mult_e.desafio.model.Capitulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CapituloRepository extends JpaRepository<Capitulo, Long> {
}
