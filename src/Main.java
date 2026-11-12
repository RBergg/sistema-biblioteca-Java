public class Main {
    public static void main(String[] args) {
        Livro livro = new Livro("Duna - VOL 1", "Frank Herbert", "9788525406958", 2017, 5);

        livro.adicionarExemplares(3);

        System.out.println("Titulo: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutor());
        System.out.println("ISBN: " + livro.getIsbn());
        System.out.println("Ano de publicação: " + livro.getAnoPublicacao());
        System.out.println("Quantidade total: " + livro.getQuantidadeTotal());
        System.out.println("Disponível em estoque: " + livro.getQuantidadeDisponivel());
    }

}
