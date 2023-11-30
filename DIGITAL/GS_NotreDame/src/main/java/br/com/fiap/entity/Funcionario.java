package br.com.fiap.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private Long id;
    @Column(name = "nome_funcionario")
    private String nome;
    @Column(name = "cpf_funcionario")
    private String cpf_funcionario;
    @Column(name = "data_nascimento")
    private Date data_nascimento;
    @Column(name = "cep_funcionario")
    private Integer cep_funcionario;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf_funcionario() {
        return cpf_funcionario;
    }

    public void setCpf_funcionario(String cpf_funcionario) {
        this.cpf_funcionario = cpf_funcionario;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Integer getCep_funcionario() {
        return cep_funcionario;
    }

    public void setCep_funcionario(Integer cep_funcionario) {
        this.cep_funcionario = cep_funcionario;
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

