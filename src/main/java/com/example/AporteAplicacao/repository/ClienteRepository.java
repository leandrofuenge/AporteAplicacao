package com.example.AporteAplicacao.repository;

import com.example.AporteAplicacao.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Método para buscar clientes por nome completo
    List<Cliente> findByNomeCompleto(String nomeCompleto);

    // Método para buscar clientes por email
    List<Cliente> findByEmail(String email);

    // Método para buscar clientes por CPF
    Optional<Cliente> findByCpf(String cpf);
    
    boolean existsByCpf(String cpf);  // Método para verificar se o cliente existe pelo CPF
}
