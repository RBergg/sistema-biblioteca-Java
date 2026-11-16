import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Leitor leitor = new Leitor("Augusto", "12345678912", "85985112256", "Rua A, n87, Esplanada");
        Leitor leitor1 = new Leitor("Pedro Afonso", "89754632112", "98997979797", "Rua teste 187");

        Livro livro = new Livro("Duna - VOL 1", "Frank Herbert", "111", 1965, 5);


        Biblioteca biblioteca = new Biblioteca();


        biblioteca.cadastrarLivro(livro);

        biblioteca.cadastrarLeitor(leitor);
        biblioteca.cadastrarLeitor(leitor1);

        biblioteca.realizarEmprestimo(leitor, livro);

        biblioteca.registrarDevolucao("12345678912", "111");

        System.out.print("Empréstimos: ");
        System.out.println(biblioteca.contarEmprestimosAtivos("12345678912"));

        try {
            biblioteca.removerLeitor("12345678912");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.print("Leitor: ");
        System.out.println(biblioteca.buscarLeitor("12345678912"));


    }

}
