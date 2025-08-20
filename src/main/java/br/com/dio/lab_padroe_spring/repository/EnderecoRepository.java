package br.com.dio.lab_padroe_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dio.lab_padroe_spring.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, String>{

}
