package com.fatec.produto.services;

import com.fatec.produto.model.entities.Catalogo;
import com.fatec.produto.model.entities.Imagem;
import com.fatec.produto.model.entities.Produto;
import com.fatec.produto.model.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService implements IProdutoService {

    @Autowired
    IProdutoRepository repositoryP;
    @Autowired
    ImagemService imagemServico;
    public List<Catalogo> consultaCatalogo() {

        Catalogo c = null;
        List<Catalogo> lista = new ArrayList<Catalogo>();
        List<Produto> listaP = repositoryP.findAll();
        List<Imagem> listaI = imagemServico.getAll();
        for (Produto p : listaP) {
            for (Imagem i : listaI) {
                if (p.getId().equals(i.getId())) {
                    c = new Catalogo(p.getId(), p.getDescricao(), p.getCategoria(),
                            p.getQuantidadeNoEstoque(), p.getCusto(), i.getArquivo());
                    lista.add(c);
                }
            }
        }
        return lista;
    }
}

