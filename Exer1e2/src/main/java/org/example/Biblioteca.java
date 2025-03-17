import java.util.*;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Membro> membros = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void adicionarLivro(Livro livro) { livros.add(livro); }
    public void removerLivro(Livro livro) { livros.remove(livro); }
    public void registrarMembro(Membro membro) { membros.add(membro); }
    public void registrarEmprestimo(Livro livro, Membro membro) {
        if (!livro.isEmprestado()) {
            emprestimos.add(new Emprestimo(livro, membro, new Date()));
            System.out.println("Empréstimo realizado com sucesso!");
        } else {
            System.out.println("Livro já emprestado!");
        }
    }
    public void devolverLivro(Livro livro) {
        emprestimos.removeIf(e -> e.getLivro().equals(livro));
        livro.setEmprestado(false);
        System.out.println("Livro devolvido com sucesso!");
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro1 = new Livro("Dom Casmurro", "Machado de Assis", "1111");
        Membro membro1 = new Membro("João", 1, "joao@email.com");

        biblioteca.adicionarLivro(livro1);
        biblioteca.registrarMembro(membro1);
        biblioteca.registrarEmprestimo(livro1, membro1);
        biblioteca.devolverLivro(livro1);
    }
}