package com.cadastros.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastros.apirest.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	Endereco findById(long id);
}
