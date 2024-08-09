package br.com.fiap.produtos;

import br.com.fiap.produtos.Repositorio.CategoriaCollectionRepository;
import br.com.fiap.produtos.Repositorio.ProdutoCollectionRepository;
import br.com.fiap.produtos.model.Categoria;
import br.com.fiap.produtos.model.Produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Produto produto = new Produto();
            produto .setNome("Kindle");
                    produto.setDescricao("E-reader");
                    produto.setCategoria(CategoriaCollectionRepository.findByNome("eletrônicos").get(0));
                    produto.setDataDeCadastro(LocalDateTime.now());
                    produto.setPreco(BigDecimal.valueOf(800));

        Produto produto1 = ProdutoCollectionRepository.save(produto);

        System.out.println(("ID: " + produto1.getId() + " Nome do Produto: " + produto1.getNome()));


    }
}