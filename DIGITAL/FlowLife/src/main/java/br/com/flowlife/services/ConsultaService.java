package br.com.flowlife.services;

import br.com.flowlife.entities.Consulta;
import br.com.flowlife.repositories.ConsultaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public Consulta buscarConsultaID(Long id) {
        return consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada com o ID"));
    }

    public List<Consulta> procurarConsulta() {
        return consultaRepository.findAll();
    }

    public Page<Consulta> procurarConsultaPage(Pageable pageable) {
        return consultaRepository.findAll(pageable);
    }

    public Consulta criarConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    @Transactional
    public Consulta atualizarConsulta(Long id, Consulta newConsulta) {
        Consulta existingConsulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada com o ID"));

        existingConsulta.setEspecialidade(newConsulta.getEspecialidade());
        existingConsulta.setData(newConsulta.getData());

        return existingConsulta;
    }

    public void deletarConsulta(Long id) {
        consultaRepository.deleteById(id);
    }

}
