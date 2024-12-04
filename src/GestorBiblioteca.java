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
        File arquivo = new File(caminhoArquivo);
        arquivo.getParentFile().mkdirs();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (ItemBiblioteca item : itens) {
                writer.write(item.getTitulo() + "," + item.getCodigo() + "," + (item instanceof Livro ? ((Livro) item).getAutor() : ""));
                writer.newLine();
            }
        }
    }

    public void carregarItensDeArquivo(String caminhoArquivo) throws IOException {
        File arquivo = new File(caminhoArquivo);
        if (!arquivo.exists()) {
            System.out.println("Arquivo não encontrado. Criando um novo arquivo.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 3) {
                    Livro livro = new Livro(dados[0], Integer.parseInt(dados[1]), dados[2]);
                    itens.add(livro);
                }
            }
        }
    }
}
