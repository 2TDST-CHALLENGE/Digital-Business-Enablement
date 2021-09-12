package com.digital.backend.repository;

import java.util.List;

import com.digital.backend.model.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {
    List<Estabelecimento> findByNomeContaining(String nome);
}
