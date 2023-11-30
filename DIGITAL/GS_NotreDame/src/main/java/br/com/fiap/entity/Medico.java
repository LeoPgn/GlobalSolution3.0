package br.com.fiap.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private Long id;
    @Column (name = "nome_medico")
    private String nome_medico;
    @Column(name = "cpf_medico")
    private String cpf_medico;
    @Column(name = "data_nascimento")
    private Date data_nascimento;
    @Column(name = "cep_medico")
    private Integer cep_medico;
    @Column(name = "especialidade_medico")
    private String especialidade_medico;

    @OneToMany(mappedBy = "medico", orphanRemoval = true)
    private List<Exame> exames;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_medico() {
        return nome_medico;
    }

    public void setNome_medico(String nome_medico) {
        this.nome_medico = nome_medico;
    }

    public String getCpf_medico() {
        return cpf_medico;
    }

    public void setCpf_medico(String cpf_medico) {
        this.cpf_medico = cpf_medico;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Integer getCep_medico() {
        return cep_medico;
    }

    public void setCep_medico(Integer cep_medico) {
        this.cep_medico = cep_medico;
    }

    public String getEspecialidade_medico() {
        return especialidade_medico;
    }

    public void setEspecialidade_medico(String especialidade_medico) {
        this.especialidade_medico = especialidade_medico;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }
}
