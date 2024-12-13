package com.example.AporteAplicacao.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private BigDecimal valorMinimoContratacao;
    private BigDecimal saldo;
    private LocalDate dataInicioVenda;
    private LocalDate dataFimVenda;
    private Integer tempoCarencia; // em meses
    private Boolean ativo;

    // Construtores, Getters e Setters

    public Plano() {
    }

    public Plano(String nome, BigDecimal valorMinimoContratacao, BigDecimal saldo, LocalDate dataInicioVenda, LocalDate dataFimVenda, Integer tempoCarencia, Boolean ativo) {
        this.nome = nome;
        this.valorMinimoContratacao = valorMinimoContratacao;
        this.saldo = saldo;
        this.dataInicioVenda = dataInicioVenda;
        this.dataFimVenda = dataFimVenda;
        this.tempoCarencia = tempoCarencia;
        this.ativo = ativo;
    }

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

    public BigDecimal getValorMinimoContratacao() {
        return valorMinimoContratacao;
    }

    public void setValorMinimoContratacao(BigDecimal valorMinimoContratacao) {
        this.valorMinimoContratacao = valorMinimoContratacao;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public LocalDate getDataInicioVenda() {
        return dataInicioVenda;
    }

    public void setDataInicioVenda(LocalDate dataInicioVenda) {
        this.dataInicioVenda = dataInicioVenda;
    }

    public LocalDate getDataFimVenda() {
        return dataFimVenda;
    }

    public void setDataFimVenda(LocalDate dataFimVenda) {
        this.dataFimVenda = dataFimVenda;
    }

    public Integer getTempoCarencia() {
        return tempoCarencia;
    }

    public void setTempoCarencia(Integer tempoCarencia) {
        this.tempoCarencia = tempoCarencia;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
