package com.compasso.avaliacao.controller.dto;

import com.compasso.avaliacao.modelo.Carro;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class CarroDto {
    private String chassi;
    private String nome;
    private String marca;
    private String cor;
    private BigDecimal valor;
    private Integer anoFabricacao;

    public CarroDto(Carro carro){
        this.chassi = carro.getChassi();
        this.nome = carro.getNome();
        this.marca = carro.getMarca();
        this.cor = carro.getCor();
        this.valor = carro.getValor();
        this.anoFabricacao = carro.getAnoFabricacao();
    }

    public String getChassi() {
        return chassi;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public String getCor() {
        return cor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public static List<CarroDto> converter(List<Carro> carros) {
        return carros.stream().map(CarroDto::new).collect(Collectors.toList());
    }
}
