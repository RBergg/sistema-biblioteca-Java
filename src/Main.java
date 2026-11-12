import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Leitor leitor = new Leitor("Augusto", "12345678912", "85985112256", "Rua A, n87, Esplanada");
        Leitor leitor1 = new Leitor("Pedro Afonso", "89754632112", "98997979797", "Rua teste 187");

        Livro livro = new Livro("Duna - VOL 1", "Frank Herbert", "111", 1965, 5);
        Livro livro1 = new Livro("Duna - VOL 2", "Frank Herbert", "222", 1969, 4);
        Livro livro2 = new Livro("Fundação ", "Isaac Asimov", "333", 1951, 6);

        Emprestimo emprestimo = new Emprestimo(leitor, livro);
        Biblioteca biblioteca = new Biblioteca();


        livro.adicionarExemplares(3);

        biblioteca.cadastrarLeitor(leitor);
        biblioteca.cadastrarLeitor(leitor1);

        biblioteca.cadastrarLivro(livro);
        biblioteca.cadastrarLivro(livro1);
        biblioteca.cadastrarLivro(livro2);

        ArrayList<Livro> livrosEncontrados = biblioteca.buscarLivro("duna");
        leitor = biblioteca.buscarLeitor("89754632112");

        System.out.println(leitor.getNomeLeitor());


        for (Livro livroEncontrado : livrosEncontrados) {
            System.out.println(livroEncontrado.getTitulo());
        }

    }

}
