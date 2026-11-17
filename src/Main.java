import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();


        Leitor leitor = new Leitor("Augusto", "12345678912", "85985112256", "Rua A, n87, Esplanada");

        Livro livro = new Livro("Livro Teste", "Autor Teste", "1212", 2015, 2);
        ;

        biblioteca.cadastrarLeitor(leitor);

        biblioteca.cadastrarLivro(livro);

        biblioteca.realizarEmprestimo(leitor, livro);
        try {
            biblioteca.removerLivro("1212");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        biblioteca.registrarDevolucao("12345678912", "1212");

        biblioteca.removerLivro("1212");

        System.out.print("Empréstimos de " + leitor.getNomeLeitor());
        System.out.println(" " + biblioteca.contarEmprestimosAtivos(leitor.getCpfLeitor()));

        System.out.println(biblioteca.buscarLivroPorIsbn("1212"));


    }

}
