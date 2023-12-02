package br.com.flowlife.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Beneficiario")
public class Beneficiario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_beneficiario")
    private Long id;
    @Column(name = "nome_beneficiario")
    private String nome;
    @Column(name = "email_beneficiario")
    private String email;
    @Column(name = "cpf_beneficiario")
    private String cpf;
    @Column(name = "data_nascimento")
    private Date data;
    @Column(name = "cep_beneficiario")
    private Integer cep;
    @Column(name = "senha_beneficiario")
    private String senha;

    @OneToMany(mappedBy = "beneficiario", orphanRemoval = true)
    private List<Consulta> consultas;

    @OneToMany(mappedBy = "beneficiario", orphanRemoval = true)
    private List<Exame> exames;

    @OneToOne(mappedBy = "beneficiario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Plano plano;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }
}
