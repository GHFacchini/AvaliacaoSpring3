package com.compasso.avaliacao.modelo;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Carro {
    @Id
    private String chassi;
    private String nome;
    private String marca;
    private String cor;
    private BigDecimal valor;
    private Integer anoFabricacao;

    public Carro() {
    }

    public Carro(String chassi, String nome, String marca, String cor, BigDecimal valor, Integer anoFabricacao) {
        this.chassi = chassi;
        this.nome = nome;
        this.marca = marca;
        this.cor = cor;
        this.valor = valor;
        this.anoFabricacao = anoFabricacao;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    //não tenho certeza se esse equals e hashcode estão 100% corretos mas foi o criado automaticamente pelo Intellij
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carro)) return false;
        Carro carro = (Carro) o;
        return chassi.equals(carro.chassi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chassi);
    }
}
