package br.com.fiap.repositories;

import br.com.fiap.entities.Exame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExameRepository extends JpaRepository<Exame, Long> {
}
