package br.com.fiap.repositories;

import br.com.fiap.entities.Plano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanoRepository extends JpaRepository<Plano, Long> {
}
