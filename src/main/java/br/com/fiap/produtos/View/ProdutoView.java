package br.com.fiap.produtos.View;

import br.com.fiap.produtos.Repositorio.ProdutoCollectionRepository;
import br.com.fiap.produtos.model.Categoria;
import br.com.fiap.produtos.model.Produto;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProdutoView {

    public static Produto form(Produto produto) {
        Categoria categoria = null;

        do {
            categoria = CategoriaView.select(produto.getCategoria());
        } while (categoria==null);

        String nome = "";

        do {
            nome = JOptionPane.showInputDialog(null,"Informe o nome do produto!"
                    ,produto.getNome());
        }while (nome.equals(""));

        String descricao = "";

        do {
            descricao = JOptionPane.showInputDialog(null,"Informe a Descrição do Produto!"
                    ,produto.getDescricao());
        }while (descricao.equals(""));

        double preco = 0;

        do {
            try {
                preco = Double.parseDouble(JOptionPane.
                        showInputDialog(null,"Informe o Preço ddo Produto!" ,produto.getPreco()));
            } catch (Exception e) {
                preco = 0;
            }
        } while (preco<=0);

        Produto ret = produto;
        ret.setCategoria(categoria)
                .setNome(nome)
                .setDescricao(descricao)
                .setDataDeCadastro(LocalDateTime.now())
                .setPreco(BigDecimal.valueOf(preco));

        return ret;
    }

    public static void sucesso() {
        JOptionPane.showMessageDialog(null,
                "O Produto foi Salvo com Sucesso!");
    }

    public static void sucesso(Produto produto) {
        JOptionPane.showMessageDialog(null, "O Produto " + produto.getNome() +
                " foi salvo com sucesso!");
    }

    public static Produto select(Produto produto) {
        Produto ret = (Produto) JOptionPane.showInputDialog(
                null,
                "Selecione um Produto",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                ProdutoCollectionRepository.findAll().toArray(),
                produto == null ? 1 : produto);
        return ret;
    }

    public static void update(Produto produto){
        form(produto);
        sucesso(produto);
        show(produto);
    }

    public static void show(Produto p) {
        System.out.println(p);

        String textoFormatado = String.format(
                "Produto: " + p.getNome() + System.lineSeparator() +
                "Descrição: " + p.getDescricao() + System.lineSeparator() +
                "Categoria: " + p.getCategoria().toString() + System.lineSeparator() +
                "Preço: %,.2f", p.getPreco());

        JOptionPane.showMessageDialog(null, textoFormatado);
    }
}
