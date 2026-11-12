import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Leitor leitor = new Leitor("Augusto", "12345678912", "85985112256", "Rua A, n87, Esplanada");
        Livro livro = new Livro("Duna - VOL 1", "Frank Herbert", "9788525406958", 2017, 5);
        Emprestimo emprestimo = new Emprestimo(leitor, livro);

        livro.adicionarExemplares(3);


        emprestimo.registrarDevolucao();
        // emprestimo.registrarDevolucao();

        /*
        System.out.println("Titulo: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutor());
        System.out.println("ISBN: " + livro.getIsbn());
        System.out.println("Ano de publicação: " + livro.getAnoPublicacao());
        System.out.println("Quantidade total: " + livro.getQuantidadeTotal());
        System.out.println("Disponível em estoque: " + livro.getQuantidadeDisponivel());


        System.out.println(leitor.getNomeLeitor());
        System.out.println(leitor.getCpfLeitor());
        System.out.println(leitor.getEnderecoLeitor());
        System.out.println(leitor.getTelefoneLeitor());
        */

        System.out.println(emprestimo.estaAtivo());
        System.out.println(emprestimo.estaAtrasado());

    }

}
