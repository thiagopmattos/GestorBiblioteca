import java.io.*;
import java.util.*;

public class SistemaPrincipal {
    private static GestorBiblioteca gestor = new GestorBiblioteca();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        carregarDados();
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Adicionar livro");
            System.out.println("2. Listar livros");
            System.out.println("3. Deletar livro");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarLivro();
                    break;
                case 2:
                    listarLivros();
                    break;
                case 3:
                    deletarLivro();
                    break;
                case 0:
                    salvarDados();
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void carregarDados() {
        try {
            gestor.carregarItensDeArquivo("C:\\Users\\thiag\\OneDrive\\Área de Trabalho\\biblioteca\\GestorBiblioteca\\src\\csv livros_files\\livros.csv");
            System.out.println("Dados carregados com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao carregar dados: " + e.getMessage());
        }
    }

    private static void salvarDados() {
        try {
            gestor.salvarItensEmArquivo("C:\\Users\\thiag\\OneDrive\\Área de Trabalho\\biblioteca\\GestorBiblioteca\\src\\csv livros_files\\livros.csv");
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    private static void adicionarLivro() {
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite o código do livro: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o autor do livro: ");
        String autor = scanner.nextLine();

        Livro livro = new Livro(titulo, codigo, autor);
        gestor.registrarItem(livro);
        System.out.println("Livro adicionado com sucesso.");
    }

    private static void listarLivros() {
        List<ItemBiblioteca> livros = gestor.listarItens();
        for (ItemBiblioteca livro : livros) {
            livro.exibirDetalhes();
        }
    }

    private static void deletarLivro() {
        System.out.print("Digite o código do livro para deletar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        List<ItemBiblioteca> livros = gestor.listarItens();
        ItemBiblioteca livroParaDeletar = null;
        for (ItemBiblioteca livro : livros) {
            if (livro.getCodigo() == codigo) {
                livroParaDeletar = livro;
                break;
            }
        }

        if (livroParaDeletar != null) {
            livros.remove(livroParaDeletar);
            System.out.println("Livro deletado com sucesso.");
        } else {
            System.out.println("Livro não encontrado.");
        }
    }
}
