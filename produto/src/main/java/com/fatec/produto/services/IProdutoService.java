package com.fatec.produto.services;

import com.fatec.produto.model.entities.Produto;

import java.util.List;

public interface IProdutoService {
    public List<Produto> consultaCatalogo();
}
