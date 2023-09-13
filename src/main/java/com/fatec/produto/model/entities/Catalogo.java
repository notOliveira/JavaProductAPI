package com.fatec.produto.model.entities;

public class Catalogo {

    private Long id;
    private String descricao;
    private String categoria;
    private int quantidadeNoEstoque;
    private double custo;
    private byte[] imagem;

    public Catalogo(Long id, String descricao, String categoria, int quantidadeNoEstoque, double custo, byte[] imagem) {
        this.id = id;
        this.descricao = descricao;
        this.categoria = categoria;
        this.quantidadeNoEstoque = quantidadeNoEstoque;
        this.custo = custo;
        this.imagem = imagem;
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

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public int getQuantidadeNoEstoque() {
        return quantidadeNoEstoque;
    }

    public void setQuantidadeNoEstoque(int quantidadeNoEstoque) {
        this.quantidadeNoEstoque = quantidadeNoEstoque;
    }
}
