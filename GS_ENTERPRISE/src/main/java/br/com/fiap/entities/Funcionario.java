package br.com.fiap.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Funcionario")
public class Funcionario extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "funcionario", orphanRemoval = true)
    private List<Consulta> consultas;

    @OneToMany(mappedBy = "funcionario", orphanRemoval = true)
    private List<Exame> exames;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }
}
