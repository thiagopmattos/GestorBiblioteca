import java.io.*;
import java.util.*;

public class GestorBiblioteca extends OperacaoBiblioteca {
    private List<ItemBiblioteca> itens = new ArrayList<>();
    private Set<String> historicoEmprestimos = new HashSet<>();

    @Override
    public void registrarItem(ItemBiblioteca item) {
        itens.add(item);
        System.out.println("Item registrado: " + item.getTitulo());
    }

    @Override
    public List<ItemBiblioteca> listarItens() {
        return itens;
    }

    public void emprestarItem(ItemBiblioteca item) throws ItemNaoDisponivelException {
        if (!itens.contains(item)) {
            throw new ItemNaoDisponivelException("Item não disponível.");
        }
        historicoEmprestimos.add(item.getTitulo());
        System.out.println("Item emprestado: " + item.getTitulo());
    }

    public void salvarItensEmArquivo(String caminhoArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (ItemBiblioteca item : itens) {
                writer.write(item.toString());
                writer.newLine();
            }
        }
    }

    public void carregarItensDeArquivo(String caminhoArquivo) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println("Carregado do arquivo: " + linha);
            }
        }
    }
}
