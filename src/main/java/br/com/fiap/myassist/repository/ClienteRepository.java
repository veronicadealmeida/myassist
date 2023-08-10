package br.com.fiap.myassist.repository;

import br.com.fiap.myassist.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByNomeIgnoreCase(String nome);

}
