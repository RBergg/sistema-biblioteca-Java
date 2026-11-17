import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Leitor leitor = new Leitor("Augusto", "12345678912", "85985112256", "Rua A, n87, Esplanada");
        Leitor leitor1 = new Leitor("Pedro Afonso", "89754632112", "98997979797", "Rua teste 187");

        Livro livro = new Livro("LivroTeste - 1", "Autor Teste", "111", 1965, 5);
        Livro livro1 = new Livro("LivroTeste - 1", "Autor Teste", "222", 2001, 3);


        Biblioteca biblioteca = new Biblioteca();

        biblioteca.cadastrarLivro(livro);
        biblioteca.cadastrarLivro(livro1);

        biblioteca.cadastrarLeitor(leitor);
        biblioteca.cadastrarLeitor(leitor1);

        ArrayList<Livro> livrosEncontrados = biblioteca.buscarLivroPorTitulo("teste");


        for (Livro livroEncontrado : livrosEncontrados) {
            System.out.println("TITULO: " + livroEncontrado.getTitulo());
            System.out.println("ISBN: " + livroEncontrado.getIsbn());
            System.out.println("Autor: " + livroEncontrado.getAutor());
            System.out.println("Ano De Publicação: " + livroEncontrado.getAnoPublicacao());
            System.out.println("Quantidade total: " + livroEncontrado.getQuantidadeTotal());
            System.out.println("Disponível em estoque: " + livroEncontrado.getQuantidadeDisponivel());
            System.out.println(" ");
        }


    }

}
