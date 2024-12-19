package com.example.AporteAplicacao.service;

import com.example.AporteAplicacao.entity.Cliente;
import com.example.AporteAplicacao.entity.Plano;
import com.example.AporteAplicacao.repository.ClienteRepository;
import com.example.AporteAplicacao.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;




@Service
public class PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    

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
        // Encontrar o cliente pelo CPF
        Cliente cliente = clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new IllegalArgumentException("Cliente com CPF " + cpf + " não encontrado."));

        // Verificar se o plano existe
        if (plano == null || plano.getPlanoId() == null) {
            throw new IllegalArgumentException("Plano inválido.");
        }

        // Atualizar o plano com o cliente e a data de contratação
        String sql = "UPDATE plano SET cliente_id = ?, data_contratacao = ? WHERE plano_id = ?";
        int rowsAffected = jdbcTemplate.update(sql, cliente.getId(), LocalDateTime.now(), plano.getPlanoId());

        // Se o plano não for encontrado ou atualizado, lançar exceção
        if (rowsAffected == 0) {
            throw new IllegalArgumentException("Plano com ID " + plano.getPlanoId() + " não encontrado.");
        }

        // Associar o cliente ao plano e definir a data de contratação
        plano.setCliente(cliente);
        plano.setDataContratacao(LocalDateTime.now());

        // Salvar o plano atualizado
        planoRepository.save(plano);
    }



    
    
    
    
    
    
    
    
    
    
    
    

    public void resgatarPlano(String cpf, Plano plano) {
        // Verifica se o cliente existe
        Cliente cliente = clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new IllegalArgumentException("Cliente com CPF " + cpf + " não encontrado."));

        // Verifica se o plano existe
        Plano planoExistente = planoRepository.findById(plano.getPlanoId())
                .orElseThrow(() -> new IllegalArgumentException("Plano com ID " + plano.getPlanoId() + " não encontrado."));

        // Verifica se o plano está associado ao cliente
        if (planoExistente.getCliente() == null || !planoExistente.getCliente().getId().equals(cliente.getId())) {
            throw new IllegalArgumentException("O plano não pertence ao cliente com CPF " + cpf + ".");
        }

        // Exclui o plano
        planoRepository.delete(planoExistente); // Excluir o plano
    }
}
