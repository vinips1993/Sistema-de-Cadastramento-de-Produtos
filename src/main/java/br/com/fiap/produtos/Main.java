package br.com.fiap.produtos;

import br.com.fiap.produtos.Repositorio.CategoriaCollectionRepository;
import br.com.fiap.produtos.Repositorio.ProdutoCollectionRepository;
import br.com.fiap.produtos.View.CategoriaView;
import br.com.fiap.produtos.View.Opcao;
import br.com.fiap.produtos.View.OpcaoView;
import br.com.fiap.produtos.model.Categoria;
import br.com.fiap.produtos.model.Produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Opcao opcao = null;

        do{
            opcao = OpcaoView.select();
            switch (opcao){
                case CADASTRAR_CATEGORIA -> cadastrarCategoria();
                case CADASTRAR_PRODUTO -> cadastrarProduto();
                case CONSULTAR_PRODUTO_POR_ID -> consultarProdutoPorId();
                case CONSULTAR_PRODUTO_POR_CATEGORIA -> consultarProdutoPorCategoria();
                case ALTERAR_PRODUTO -> alterarProduto();
                case ENCERRAR_SISTEMA -> encerrarSistema();
            }

        }while (opcao != Opcao.ENCERRAR_SISTEMA);

    }

    private static void cadastrarCategoria() {

        CategoriaView view = new CategoriaView();
        Categoria categoria = view.form();
        CategoriaCollectionRepository.save(categoria);
        view.sucesso(categoria);

    }

    private static void cadastrarProduto(){

    }

    private static void consultarProdutoPorId(){

    }

    private static void consultarProdutoPorCategoria(){

    }

    private static void alterarProduto(){

    }

    private static void encerrarSistema(){
        System.out.println("Sistema Encerrado!");
    }
}