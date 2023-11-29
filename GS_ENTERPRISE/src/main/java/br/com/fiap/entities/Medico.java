package br.com.fiap.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Medico")
public class Medico extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "especialidade_medico")
    private String especialidade;

    @OneToMany(mappedBy = "medico", orphanRemoval = true)
    private List<Exame> exames;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }
}
