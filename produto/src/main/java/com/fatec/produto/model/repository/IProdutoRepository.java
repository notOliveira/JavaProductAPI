package com.fatec.produto.model.repository;

import com.fatec.produto.model.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProdutoRepository extends JpaRepository <Produto, Long> {
    public List<Produto> findAllByDescricaoIgnoreCaseContaining(String descricao);
}
