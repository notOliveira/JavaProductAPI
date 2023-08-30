package com.fatec.produto.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;
    private String categoria;
    private double custo;
    private int quantidadeNoEstoque;

    public Produto() {

    }
    public Produto(String descricao, String categoria, double custo, int quantidadeNoEstoque) {
        this.descricao = descricao;
        this.categoria = categoria;
        this.custo = custo;
        this.quantidadeNoEstoque = quantidadeNoEstoque;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) throws Exception {
        if(this.descricao == null || this.descricao.isBlank()) {
            throw new IllegalAccessException("A descrição não pode estar em branco");
        }
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) throws Exception {
        if(this.categoria == null || this.categoria.isBlank()) {
            throw new Exception("A categoria não pode estar em branco");
        }
        this.categoria = categoria;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) throws Exception {
        try {
            if (custo <= 0) {
                throw new IllegalAccessException("O custo deve ser maior que zero");
            } else {
                this.custo = custo;
            }
        } catch (Exception e) {
            throw new IllegalAccessException("O custo deve ser numérico");
        }
        this.custo = custo;
    }

    public int getQuantidadeNoEstoque() {
        return quantidadeNoEstoque;
    }

    public void setQuantidadeNoEstoque(int quantidadeNoEstoque) throws Exception {
        try {
            if (quantidadeNoEstoque <= 0) {
                throw new IllegalAccessException("A quantidade deve ser maior que zero");
            } else {
                this.quantidadeNoEstoque = quantidadeNoEstoque;
            }
        } catch (Exception e) {
            throw new IllegalAccessException("A quantidade deve ser numérico");
        }
    }
}
