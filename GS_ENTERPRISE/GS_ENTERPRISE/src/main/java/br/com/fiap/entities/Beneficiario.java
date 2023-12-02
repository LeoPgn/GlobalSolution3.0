package br.com.fiap.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Beneficiario")
public class Beneficiario extends Pessoa{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
