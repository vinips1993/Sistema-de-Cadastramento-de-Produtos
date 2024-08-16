package br.com.fiap.produtos;

import br.com.fiap.produtos.Repositorio.CategoriaCollectionRepository;
import br.com.fiap.produtos.Repositorio.ProdutoCollectionRepository;
import br.com.fiap.produtos.View.CategoriaView;
import br.com.fiap.produtos.View.Opcao;
import br.com.fiap.produtos.View.OpcaoView;
import br.com.fiap.produtos.View.ProdutoView;
import br.com.fiap.produtos.model.Categoria;
import br.com.fiap.produtos.model.Produto;

import javax.swing.*;
import java.util.List;

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
        Categoria categoria = view.form(new Categoria());
        CategoriaCollectionRepository.save(categoria);
        view.sucesso(categoria);

    }
    private static void cadastrarProduto(){
        Produto produto = ProdutoView.form(new Produto()); {
        ProdutoCollectionRepository.save(produto);
        ProdutoView.sucesso(produto);
        }
    }
    private static void consultarProdutoPorId() {
        // Solicita o ID do produto ao usuário
        String idStr = JOptionPane.showInputDialog("Informe o ID do produto:");

        // Converte o ID para o tipo correto (int, long, String, etc.)
        Long id = Long.parseLong(idStr);

        // Busca o produto pelo ID no repositório
        Produto produto = ProdutoCollectionRepository.findById(id);

        // Verifica se o produto foi encontrado
        if (produto != null) {
            // Exibe o produto
            ProdutoView.show(produto);
        } else {
            // Exibe uma mensagem caso o produto não seja encontrado
            JOptionPane.showMessageDialog(null, "Produto com ID " + id + " não encontrado.");
        }
    }

    private static void consultarProdutoPorCategoria(){

        Categoria categoria = CategoriaView.select(null);

        List<Produto> produtos = ProdutoCollectionRepository.findByCategoria(categoria);

        if(produtos.isEmpty()){
            JOptionPane.showMessageDialog(null,"Não encontramos produtos com a categoria: " +
                    categoria.getNome());
        } else {
            produtos.forEach(ProdutoView::show);
            produtos.forEach(System.out::println);
        }
    }

    private static void alterarProduto(){
        Produto produto = ProdutoView.select(null);
        ProdutoView.update(produto);
    }

    private static void encerrarSistema(){
        System.out.println("Sistema Encerrado!");
    }
}