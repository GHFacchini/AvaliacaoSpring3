package com.compasso.avaliacao.repository;

import com.compasso.avaliacao.modelo.Carro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarroRepository extends JpaRepository<Carro, String> {

    Page<Carro> findByMarca(String marca, Pageable paginacao);

    Page<Carro> findByNome(String nome, Pageable paginacao);

    Page<Carro> findByCor(String cor, Pageable paginacao);

}
