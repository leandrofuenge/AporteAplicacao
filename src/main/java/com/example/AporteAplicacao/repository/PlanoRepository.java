package com.example.AporteAplicacao.repository;

import com.example.AporteAplicacao.entity.Plano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long> {

    Optional<Plano> findByIdAndAtivoTrue(Long id);

    Optional<Plano> findByNomeAndAtivoTrue(String nome);
}
