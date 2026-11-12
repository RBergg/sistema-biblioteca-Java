import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Leitor> leitores = new ArrayList<>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();


    public void cadastrarLivro(Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("Livro inválido");
        }
        livros.add(livro);
    }

    public ArrayList<Livro> buscarLivro(String termo) {

        //Armazena os livros encontrados.
        ArrayList<Livro> resultados = new ArrayList<>();
        if (termo == null || termo.isBlank()) {
            throw new IllegalArgumentException("Busca inválida.");
        }
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(termo) || livro.getTitulo().toLowerCase().contains(termo.toLowerCase())) {
                resultados.add(livro);
            }
        }
        return resultados;
    }


}

