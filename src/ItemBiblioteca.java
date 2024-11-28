public abstract class ItemBiblioteca {
    private String titulo;
    private int codigo;

    public ItemBiblioteca(String titulo, int codigo) {
        this.titulo = titulo;
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCodigo() {
        return codigo;
    }

    public abstract void exibirDetalhes();

    @Override
    public String toString() {
        return "ItemBiblioteca{" +
                "titulo='" + titulo + '\'' +
                ", codigo=" + codigo +
                '}';
    }
}
