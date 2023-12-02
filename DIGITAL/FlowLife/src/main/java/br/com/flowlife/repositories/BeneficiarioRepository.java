package br.com.flowlife.repositories;

import br.com.flowlife.entities.Beneficiario;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {

}