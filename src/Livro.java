import java.time.LocalDate;

public class Livro {

    private String titulo;
    private String autor;
    private String isbn;
    private int anoPublicacao;
    private int quantidadeTotal;
    private int quantidadeDisponivel;

    public void adicionarExemplares(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade invalida.");


        }
        quantidadeTotal += quantidade;
        quantidadeDisponivel += quantidade;
    }

    public Livro(String titulo, String autor, String isbn, int anoPublicacao, int quantidadeTotal) {

        setTitulo(titulo);
        setAutor(autor);
        setIsbn(isbn);
        setAnoPublicacao(anoPublicacao);
        setQuantidadeTotal(quantidadeTotal);

        this.quantidadeDisponivel = this.quantidadeTotal;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("O título não pode ser vazio.");
        }
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.isBlank()) {
            throw new IllegalArgumentException("Autor não pode ser vazio.");
        }
        this.autor = autor;
    }

    private void setIsbn(String isbn) {
        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("isbn não pode ser vazio.");
        }
        this.isbn = isbn;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        if (anoPublicacao <= 0 || anoPublicacao > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Ano de publicação inválido.");
        }
        this.anoPublicacao = anoPublicacao;
    }

    private void setQuantidadeTotal(int quantidadeTotal) {
        if (quantidadeTotal <= 0) {
            throw new IllegalArgumentException("Quantidade inválida.");
        }
        this.quantidadeTotal = quantidadeTotal;
    }

}


