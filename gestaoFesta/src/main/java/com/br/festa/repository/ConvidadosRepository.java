package com.br.festa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.festa.model.Convidado;

public interface ConvidadosRepository extends JpaRepository<Convidado, Long> {

}
