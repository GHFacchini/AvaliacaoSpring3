package com.compasso.avaliacao.controller;


import com.compasso.avaliacao.controller.dto.CarroDto;
import com.compasso.avaliacao.modelo.Carro;
import com.compasso.avaliacao.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarrosController {

    @Autowired
    private CarroRepository carroRepository;

    @GetMapping
    public List<CarroDto> lista(){
        List<Carro> carros = carroRepository.findAll();
        return null;
    }



}
