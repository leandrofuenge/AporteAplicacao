package com.example.AporteAplicacao.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;
    private String endereco;
    private String email;
    private String telefone;
    private String profissao;
    private String contaBancaria;
    private BigDecimal rendaMensal;
    private String perfilInvestidor;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cliente_id") // Liga beneficiários ao cliente
    private List<Beneficiario> beneficiarios;

    private Integer prazoInvestimentoDesejado;

    // Construtor padrão
    public Cliente() {}

    // Construtor com parâmetros
    public Cliente(String nomeCompleto, String cpf, LocalDate dataNascimento, String endereco, String email, String telefone, 
                   String profissao, String contaBancaria, BigDecimal rendaMensal, String perfilInvestidor, 
                   List<Beneficiario> beneficiarios, Integer prazoInvestimentoDesejado) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.profissao = profissao;
        this.contaBancaria = contaBancaria;
        this.rendaMensal = rendaMensal;
        this.perfilInvestidor = perfilInvestidor;
        this.beneficiarios = beneficiarios;
        this.prazoInvestimentoDesejado = prazoInvestimentoDesejado;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNomeCompleto() { return nomeCompleto; }
    public void setNomeCompleto(String nomeCompleto) { this.nomeCompleto = nomeCompleto; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getProfissao() { return profissao; }
    public void setProfissao(String profissao) { this.profissao = profissao; }
    public String getContaBancaria() { return contaBancaria; }
    public void setContaBancaria(String contaBancaria) { this.contaBancaria = contaBancaria; }
    public BigDecimal getRendaMensal() { return rendaMensal; }
    public void setRendaMensal(BigDecimal rendaMensal) { this.rendaMensal = rendaMensal; }
    public String getPerfilInvestidor() { return perfilInvestidor; }
    public void setPerfilInvestidor(String perfilInvestidor) { this.perfilInvestidor = perfilInvestidor; }
    public List<Beneficiario> getBeneficiarios() { return beneficiarios; }
    public void setBeneficiarios(List<Beneficiario> beneficiarios) { this.beneficiarios = beneficiarios; }
    public Integer getPrazoInvestimentoDesejado() { return prazoInvestimentoDesejado; }
    public void setPrazoInvestimentoDesejado(Integer prazoInvestimentoDesejado) { this.prazoInvestimentoDesejado = prazoInvestimentoDesejado; }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", endereco='" + endereco + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", profissao='" + profissao + '\'' +
                ", contaBancaria='" + contaBancaria + '\'' +
                ", rendaMensal=" + rendaMensal +
                ", perfilInvestidor='" + perfilInvestidor + '\'' +
                ", beneficiarios=" + beneficiarios +
                ", prazoInvestimentoDesejado=" + prazoInvestimentoDesejado +
                '}';
    }
}
