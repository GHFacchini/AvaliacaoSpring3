package com.compasso.avaliacao.controller.form;

import com.compasso.avaliacao.modelo.Carro;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import javax.validation.constraints.*;

public class CarroForm {
    @NotNull @NotEmpty @Length(min = 17, max = 17)
    private String chassi;

    @NotNull @NotEmpty
    private String nome;

    @NotNull @NotEmpty
    private String marca;

    @NotNull @NotEmpty
    private String cor;

    @NotNull @DecimalMin("0")
    private BigDecimal valor;

    //não consegui colocar dinamicamente como LocalDate.now().getYear()
    @NotNull @Min(1769) @Max(2021)
    private Integer anoFabricacao;

    public Carro converter() {
        return new Carro(chassi,nome,marca,cor,valor,anoFabricacao);
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
}
