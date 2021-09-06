package com.compasso.avaliacao.controller;


import com.compasso.avaliacao.controller.dto.CarroDto;
import com.compasso.avaliacao.controller.form.CarroForm;
import com.compasso.avaliacao.modelo.Carro;
import com.compasso.avaliacao.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarrosController {

    @Autowired
    private CarroRepository carroRepository;

    @GetMapping
    public Page<CarroDto> lista(@RequestParam(required = false) String marcaCarro,
                                @RequestParam(required = false) String corCarro,
                                @RequestParam(required = false) String nomeCarro,
                                @PageableDefault() Pageable paginacao) {
        //Como não vimos no curso como utilizar multiplos filtros foi a gambiarra que eu consegui
        if ((marcaCarro != null) && (corCarro == null) && (nomeCarro == null)) {
            Page<Carro> carros = carroRepository.findByMarca(marcaCarro, paginacao);
            return CarroDto.converter(carros);
        } else if ((marcaCarro == null) && (corCarro != null) && (nomeCarro == null)) {
            Page<Carro> carros = carroRepository.findByCor(corCarro, paginacao);
            return CarroDto.converter(carros);
        } else if ((marcaCarro == null) && (corCarro == null) && (nomeCarro != null)) {
            Page<Carro> carros = carroRepository.findByNome(nomeCarro, paginacao);
            return CarroDto.converter(carros);
        } else {
            Page<Carro> carros = carroRepository.findAll(paginacao);
            return CarroDto.converter(carros);
        }
    }

    @PostMapping
    public ResponseEntity<CarroDto> cadastrar(@RequestBody @Valid CarroForm carroForm, UriComponentsBuilder uriBuilder) {
        Carro carro = carroForm.converter();
        carroRepository.save(carro);

        URI uri = uriBuilder.path("/carros/{id}").buildAndExpand(carro.getChassi()).toUri();
        return ResponseEntity.created(uri).body(new CarroDto(carro));
    }


}
