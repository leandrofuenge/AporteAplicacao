package com.example.AporteAplicacao.controller;

import com.example.AporteAplicacao.entity.Plano;
import com.example.AporteAplicacao.service.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/plano")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Plano> cadastrarPlano(@RequestBody Plano plano) {
        try {
            Plano novoPlano = planoService.cadastrarPlano(plano);
            return new ResponseEntity<>(novoPlano, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/contratar")
    public ResponseEntity<String> contratarPlano(@RequestParam String cpf, @RequestBody Plano plano) {
        try {
            planoService.contratarPlano(cpf, plano);
            return new ResponseEntity<>("Plano contratado com sucesso!", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao contratar o plano.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/resgatar")
    public ResponseEntity<String> resgatarPlano(@RequestParam String cpf, @RequestBody Plano plano) {
        try {
            planoService.resgatarPlano(cpf, plano);
            return new ResponseEntity<>("Plano resgatado com sucesso!", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao resgatar o plano.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
