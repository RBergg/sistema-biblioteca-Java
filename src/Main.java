public class Main {
    public static void main(String[] args) {
        Livro livro = new Livro("Duna - VOL 1", "Frank Herbert", "9788525406958", 2017, 5);

        livro.adicionarExemplares(3);

        System.out.println(livro.getTitulo());
        System.out.println(livro.getAutor());
        System.out.println(livro.getIsbn());
        System.out.println(livro.getAnoPublicacao());
        System.out.println(livro.getQuantidadeTotal());
        System.out.println(livro.getQuantidadeDisponivel());
    }

}
