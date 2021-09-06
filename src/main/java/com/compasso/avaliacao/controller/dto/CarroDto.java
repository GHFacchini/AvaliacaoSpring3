package com.compasso.avaliacao.controller.dto;

import com.compasso.avaliacao.modelo.Carro;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

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

    public static Page<CarroDto> converter(Page<Carro> carros) {
        return carros.map(CarroDto::new);
    }
}
