package com.example.AporteAplicacao.service;

import com.example.AporteAplicacao.entity.Plano;
import com.example.AporteAplicacao.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    public boolean podeContratarPlano(Long clienteId, BigDecimal aporteInicial, Long planoId) {
        Optional<Plano> plano = planoRepository.findByIdAndAtivoTrue(planoId);
        if (plano.isPresent()) {
            Plano p = plano.get();
            LocalDate hoje = LocalDate.now();
            return aporteInicial.compareTo(p.getValorMinimoContratacao()) >= 0 &&
                    (hoje.isAfter(p.getDataInicioVenda()) && hoje.isBefore(p.getDataFimVenda()));
        }
        return false;
    }
    
    public boolean podeResgatarPlano(Long clienteId, Long planoId) {
    	Optional<Plano> plano = planoRepository.findByIdAndAtivoTrue(planoId);
    	if(plano.isPresent()) {
    		Plano p = plano.get();
    	    LocalDate hoje = LocalDate.now();
            return p.getSaldo().compareTo(BigDecimal.ZERO) > 0 &&
    	    		hoje.isAfter(p.getDataInicioVenda().plusMonths(p.getTempoCarencia()));
    	}
    	return false;
    }
    
    public void realizarResgate(Long planoId) {
        Optional<Plano> plano = planoRepository.findByIdAndAtivoTrue(planoId);
        if (plano.isPresent()) {
            Plano p = plano.get();
            p.setSaldo(BigDecimal.ZERO);
            p.setAtivo(false); // Cancelar o plano automaticamente
            planoRepository.save(p);
        }
    }
}