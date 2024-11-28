public class Aluno extends Usuario {
    private boolean autorizado;

    public Aluno(String nome, String cpf, boolean autorizado) {
        super(nome, cpf);
        this.autorizado = autorizado;
    }

    @Override
    public void realizarEmprestimo(ItemBiblioteca item) throws ItemNaoDisponivelException, UsuarioNaoAutorizadoException {
        if (!autorizado) {
            throw new UsuarioNaoAutorizadoException("Usuário não autorizado a realizar empréstimos.");
        }
        System.out.println(getNome() + " realizou empréstimo do item: " + item.getTitulo());
    }
}



