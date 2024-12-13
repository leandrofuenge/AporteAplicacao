package com.example.AporteAplicacao.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Double rentabilidade;
    private String tipoFundo;
    private Integer duracaoMinima;
    private String modalidade;
    private String perfilInvestidor;
    private BigDecimal taxaAdministracao; // Utilizando BigDecimal para valores monetários
    private BigDecimal taxaCarregamento;
    private LocalDate dataLancamento;
    private String status;
    private String publicoAlvo;

    @ElementCollection
    private List<String> beneficiosAdicionais;

    @ElementCollection
    private List<String> opcoesResgate;

    // Getters e Setters

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getRentabilidade() {
        return rentabilidade;
    }

    public void setRentabilidade(Double rentabilidade) {
        this.rentabilidade = rentabilidade;
    }

    public String getTipoFundo() {
        return tipoFundo;
    }

    public void setTipoFundo(String tipoFundo) {
        this.tipoFundo = tipoFundo;
    }

    public Integer getDuracaoMinima() {
        return duracaoMinima;
    }

    public void setDuracaoMinima(Integer duracaoMinima) {
        this.duracaoMinima = duracaoMinima;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getPerfilInvestidor() {
        return perfilInvestidor;
    }

    public void setPerfilInvestidor(String perfilInvestidor) {
        this.perfilInvestidor = perfilInvestidor;
    }

    public BigDecimal getTaxaAdministracao() {
        return taxaAdministracao;
    }

    public void setTaxaAdministracao(BigDecimal taxaAdministracao) {
        this.taxaAdministracao = taxaAdministracao;
    }

    public BigDecimal getTaxaCarregamento() {
        return taxaCarregamento;
    }

    public void setTaxaCarregamento(BigDecimal taxaCarregamento) {
        this.taxaCarregamento = taxaCarregamento;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPublicoAlvo() {
        return publicoAlvo;
    }

    public void setPublicoAlvo(String publicoAlvo) {
        this.publicoAlvo = publicoAlvo;
    }

    public List<String> getBeneficiosAdicionais() {
        return beneficiosAdicionais;
    }

    public void setBeneficiosAdicionais(List<String> beneficiosAdicionais) {
        this.beneficiosAdicionais = beneficiosAdicionais;
    }

    public List<String> getOpcoesResgate() {
        return opcoesResgate;
    }

    public void setOpcoesResgate(List<String> opcoesResgate) {
        this.opcoesResgate = opcoesResgate;
    }
}
