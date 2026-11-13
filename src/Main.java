import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Leitor leitor = new Leitor("Augusto", "12345678912", "85985112256", "Rua A, n87, Esplanada");
        Leitor leitor1 = new Leitor("Pedro Afonso", "89754632112", "98997979797", "Rua teste 187");

        Livro livro = new Livro("Duna - VOL 1", "Frank Herbert", "111", 1965, 5);


        Biblioteca biblioteca = new Biblioteca();


        biblioteca.cadastrarLeitor(leitor);
        biblioteca.cadastrarLeitor(leitor1);

        livro.adicionarExemplares(3);

        biblioteca.cadastrarLivro(livro);

        biblioteca.realizarEmprestimo(leitor, livro);
        biblioteca.realizarEmprestimo(leitor1, livro);

        biblioteca.registrarDevolucao("12345678912", "111");

        biblioteca.realizarEmprestimo(leitor, livro);


        System.out.println(leitor.getNomeLeitor());
        System.out.println(leitor1.getNomeLeitor());
        System.out.println(livro.getQuantidadeDisponivel());


    }

}
