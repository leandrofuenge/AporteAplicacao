package com.example.AporteAplicacao.services;

import com.example.AporteAplicacao.entity.Cliente;
import com.example.AporteAplicacao.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Recupera todos os clientes
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    // Recupera um cliente pelo ID
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    // Recupera um cliente pelo CPF
    public Optional<Cliente> findByCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

    // Cria ou atualiza um cliente
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Deleta um cliente pelo ID
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}
