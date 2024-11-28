import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SistemaPrincipal {
    public static void main(String[] args) {
        GestorBiblioteca gestor = new GestorBiblioteca();
        Livro livro = new Livro("Java para Iniciantes", 1, "Deitel");

        gestor.registrarItem(livro);

        Aluno aluno = new Aluno("João", "12345678900", true);

        try {
            aluno.realizarEmprestimo(livro);
            gestor.emprestarItem(livro);
            gestor.salvarItensEmArquivo("biblioteca.txt");
            gestor.carregarItensDeArquivo("biblioteca.txt");
        } catch (ItemNaoDisponivelException | UsuarioNaoAutorizadoException | IOException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
