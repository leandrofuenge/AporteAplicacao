package com.example.AporteAplicacao.service;

import com.example.AporteAplicacao.entity.Produto;
import com.example.AporteAplicacao.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Salvar novo produto
    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    // Listar todos os produtos
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    // Buscar produto por ID
    public Produto buscarPorId(Long id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        return produtoOptional.orElse(null);
    }

    // Atualizar produto existente
    public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isPresent()) {
            Produto produtoExistente = produtoOptional.get();

            // Atualizando os campos necessários
            produtoExistente.setNome(produtoAtualizado.getNome());
            produtoExistente.setDescricao(produtoAtualizado.getDescricao());
            produtoExistente.setRentabilidade(produtoAtualizado.getRentabilidade());
            produtoExistente.setTipoFundo(produtoAtualizado.getTipoFundo());
            produtoExistente.setDuracaoMinima(produtoAtualizado.getDuracaoMinima());
            produtoExistente.setModalidade(produtoAtualizado.getModalidade());
            produtoExistente.setPerfilInvestidor(produtoAtualizado.getPerfilInvestidor());
            produtoExistente.setTaxaAdministracao(produtoAtualizado.getTaxaAdministracao());
            produtoExistente.setTaxaCarregamento(produtoAtualizado.getTaxaCarregamento());
            produtoExistente.setDataLancamento(produtoAtualizado.getDataLancamento());
            produtoExistente.setStatus(produtoAtualizado.getStatus());
            produtoExistente.setPublicoAlvo(produtoAtualizado.getPublicoAlvo());
            produtoExistente.setBeneficiosAdicionais(produtoAtualizado.getBeneficiosAdicionais());
            produtoExistente.setOpcoesResgate(produtoAtualizado.getOpcoesResgate());

            return produtoRepository.save(produtoExistente);
        } else {
            return null;
        }
    }

    // Deletar produto por ID
    public boolean deletarProduto(Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
