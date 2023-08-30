package com.fatec.produto.services;

import com.fatec.produto.model.entities.Produto;
import com.fatec.produto.model.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService implements IProdutoService {
    @Autowired
    private IProdutoRepository repository;
    @Override
    public List<Produto> consultaCatalogo() {
        return repository.findAll();
    }
}
