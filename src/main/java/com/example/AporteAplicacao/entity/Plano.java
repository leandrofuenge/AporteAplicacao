package com.example.AporteAplicacao.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plano_id")
    private Long planoId; // Identificador único do plano

    private String nome;
    private String descricao;
    private Double rentabilidade;
    private String regras;

    // Construtores
    public Plano() {}

    public Plano(String nome, String descricao, Double rentabilidade, String regras) {
        this.nome = nome;
        this.descricao = descricao;
        this.rentabilidade = rentabilidade;
        this.regras = regras;
    }

    // Getters e Setters
    public Long getPlanoId() {
        return planoId;
    }

    public void setPlanoId(Long planoId) {
        this.planoId = planoId;
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

    public String getRegras() {
        return regras;
    }

    public void setRegras(String regras) {
        this.regras = regras;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plano plano = (Plano) o;
        return Objects.equals(planoId, plano.planoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planoId);
    }

    @Override
    public String toString() {
        return "Plano{" +
                "planoId=" + planoId +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", rentabilidade=" + rentabilidade +
                ", regras='" + regras + '\'' +
                '}';
    }

	public void setCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	public Cliente getCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDataContratacao(Date date) {
		// TODO Auto-generated method stub
		
	}
}
