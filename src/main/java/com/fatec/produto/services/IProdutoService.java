package com.fatec.produto.services;

import com.fatec.produto.model.entities.Catalogo;
import com.fatec.produto.model.entities.Produto;

import java.util.List;

public interface IProdutoService {
    public List<Catalogo> consultaCatalogo();

}
