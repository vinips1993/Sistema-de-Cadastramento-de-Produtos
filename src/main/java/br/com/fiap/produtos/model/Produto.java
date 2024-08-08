package br.com.fiap.produtos.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Produto {

    Long id;
    String nome;
    String descricao;
    BigDecimal preco;
    LocalDateTime dataDeCadastro;
    Categoria categoria;

    public Produto(){

    }

    public Produto(Long id, String nome, String descricao, BigDecimal preco, LocalDateTime dataDeCadastro,
                   Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.dataDeCadastro = dataDeCadastro;
        this.categoria = categoria;
    }

    public Produto(String nome, String descricao, BigDecimal preco, LocalDateTime dataDeCadastro,
                   Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.dataDeCadastro = dataDeCadastro;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public LocalDateTime getDataDeCadastro() {
        return dataDeCadastro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setDataDeCadastro(LocalDateTime dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id.equals(produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return nome.toUpperCase();
    }
}
