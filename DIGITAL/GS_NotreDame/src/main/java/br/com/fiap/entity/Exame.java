package br.com.fiap.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Exame")
public class Exame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exame")
    private Long id;
    @Column(name = "especialidade_exame")
    private String especialidade_exame;
    @Column(name = "data_exame")
    private Date data_exame;

    @ManyToOne
    @JoinColumn(name = "beneficiario_id")
    private Beneficiario beneficiario;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEspecialidade_exame() {
        return especialidade_exame;
    }

    public void setEspecialidade_exame(String especialidade_exame) {
        this.especialidade_exame = especialidade_exame;
    }

    public Date getData_exame() {
        return data_exame;
    }

    public void setData_exame(Date data_exame) {
        this.data_exame = data_exame;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
