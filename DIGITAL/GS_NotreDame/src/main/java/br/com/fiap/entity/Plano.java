package br.com.fiap.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Plano")
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plano")
    private Long id;
    @Column(name = "data_contratacao")
    private Date data_contratacao;

    @OneToOne
    @JoinColumn(name = "beneficiario_id", unique = true)
    private Beneficiario beneficiario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData_contratacao() {
        return data_contratacao;
    }

    public void setData_contratacao(Date data_contratacao) {
        this.data_contratacao = data_contratacao;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }
}
