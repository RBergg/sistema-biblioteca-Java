import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Leitor leitor = new Leitor("Augusto", "12345678912", "85985112256", "Rua A, n87, Esplanada");
        Leitor leitor1 = new Leitor("Pedro Afonso", "89754632112", "98997979797", "Rua teste 187");

        Livro livro = new Livro("Duna - VOL 1", "Frank Herbert", "111", 1965, 5);


        Biblioteca biblioteca = new Biblioteca();


        biblioteca.cadastrarLeitor(leitor);

        livro.adicionarExemplares(3);

        biblioteca.cadastrarLivro(livro);

        biblioteca.realizarEmprestimo(leitor, livro);
        biblioteca.realizarEmprestimo(leitor, livro);


        System.out.println(leitor.getNomeLeitor());

        /*ArrayList<Livro> livrosEncontrados = biblioteca.buscarLivroPorTitulo("duna");

        for (Livro livroEncontrado : livrosEncontrados) {
            System.out.println(livroEncontrado.getTitulo());
        }
        System.out.println("Foram encontrados: " + livrosEncontrados.size() + " Livros");


        Livro livroEncontrado = biblioteca.buscarLivroPorIsbn("444");

        System.out.println(livroEncontrado.getTitulo());

        leitor = biblioteca.buscarLeitor("89754632112");


        System.out.println(livro3.getQuantidadeTotal());
          */

    }

}
