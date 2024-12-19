package com.example.AporteAplicacao.service;

import com.example.AporteAplicacao.entity.Cliente;
import com.example.AporteAplicacao.entity.Plano;
import com.example.AporteAplicacao.repository.ClienteRepository;
import com.example.AporteAplicacao.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Plano cadastrarPlano(Plano plano) {
        if (plano.getNome() == null || plano.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do plano é obrigatório.");
        }
        if (plano.getRentabilidade() == null || plano.getRentabilidade() <= 0) {
            throw new IllegalArgumentException("A rentabilidade do plano deve ser maior que zero.");
        }
        if (plano.getRegras() == null || plano.getRegras().isEmpty()) {
            throw new IllegalArgumentException("As regras do plano são obrigatórias.");
        }

        return planoRepository.save(plano);
    }

    public void contratarPlano(String cpf, Plano plano) {
        Cliente cliente = clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new IllegalArgumentException("Cliente com CPF " + cpf + " não encontrado."));

        Plano planoExistente = planoRepository.findById(plano.getPlanoId())
                .orElseThrow(() -> new IllegalArgumentException("Plano com ID " + plano.getPlanoId() + " não encontrado."));

        planoExistente.setCliente(cliente); // Associar o cliente ao plano
        planoExistente.setDataContratacao(new java.util.Date()); // Adicionar a data de contratação

        planoRepository.save(planoExistente); // Salvar o plano atualizado
    }

    public void resgatarPlano(String cpf, Plano plano) {
        Cliente cliente = clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new IllegalArgumentException("Cliente com CPF " + cpf + " não encontrado."));

        Plano planoExistente = planoRepository.findById(plano.getPlanoId())
                .orElseThrow(() -> new IllegalArgumentException("Plano com ID " + plano.getPlanoId() + " não encontrado."));

        if (!planoExistente.getCliente().getId().equals(cliente.getId())) {
            throw new IllegalArgumentException("O plano não pertence ao cliente com CPF " + cpf + ".");
        }

        planoRepository.delete(planoExistente); // Excluir o plano
    }
}
