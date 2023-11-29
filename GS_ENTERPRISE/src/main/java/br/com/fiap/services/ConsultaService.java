package br.com.fiap.services;

import br.com.fiap.entities.Consulta;
import br.com.fiap.repositories.ConsultaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public Consulta buscarConsultaID(Long id) {
        return consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrado com o ID"));
    }

    public List<Consulta> buscarConsulta() {
        return consultaRepository.findAll();
    }

    public Consulta criarConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    @Transactional
    public Consulta atualizarDepartment(Long id, Consulta consulta) {
        Consulta buscarConsulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrado com o ID"));

        buscarConsulta.setEspecialidade(consulta.getEspecialidade());
        buscarConsulta.setData(consulta.getData());

        return buscarConsulta;
    }

    public void deletarConsulta(Long id) {
        consultaRepository.deleteById(id);
    }
}
