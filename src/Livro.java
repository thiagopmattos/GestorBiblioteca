public class Livro extends ItemBiblioteca {
    private String autor;

    public Livro(String titulo, int codigo, String autor) {
        super(titulo, codigo);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Livro{" +
                "titulo='" + getTitulo() + '\'' +
                ", codigo=" + getCodigo() +
                ", autor='" + autor + '\'' +
                '}');
    }
}

