package com.example.AporteAplicacao.controller;

import com.example.AporteAplicacao.service.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/plano")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @PostMapping("/contratar")
    public ResponseEntity<String> contratarPlano(@RequestParam Long clienteId, @RequestParam Long planoId, @RequestParam BigDecimal aporteInicial) {
        if (planoService.podeContratarPlano(clienteId, aporteInicial, planoId)) {
            return ResponseEntity.ok("Plano contratado com sucesso.");
        }
        return ResponseEntity.badRequest().body("Não é possível contratar este plano.");
    }

    @PostMapping("/resgatar")
    public ResponseEntity<String> resgatarPlano(@RequestParam Long clienteId, @RequestParam Long planoId) {
        if (planoService.podeResgatarPlano(clienteId, planoId)) {
            planoService.realizarResgate(planoId);
            return ResponseEntity.ok("Resgate realizado com sucesso.");
        }
        return ResponseEntity.badRequest().body("Não é possível realizar o resgate.");
    }
}
