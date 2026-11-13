import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Leitor> leitores = new ArrayList<>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();


    public void cadastrarLivro(Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("Livro inválido");
        }

        Livro livroEncontrado = buscarLivroPorIsbn(livro.getIsbn());

        if (livroEncontrado != null) {
            livroEncontrado.adicionarExemplares(livro.getQuantidadeTotal());
        }
        //Cadastra um novo livro caso ele ainda não exista no sistema.
        else {
            livros.add(livro);
        }
    }

    public ArrayList<Livro> buscarLivroPorTitulo(String titulo) {
        //Armazena os livros encontrados.
        ArrayList<Livro> resultados = new ArrayList<>();
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Busca inválida.");
        }
        for (Livro livro : livros) {
            if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultados.add(livro);
            }
        }
        return resultados;
    }

    public Livro buscarLivroPorIsbn(String isbn) {
        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("Busca inválida");
        }

        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                return livro;
            }
        }
        return null;
    }

    public Leitor buscarLeitor(String cpf) {
        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("Busca inválida.");
        }

        for (Leitor leitor : leitores) {
            if (leitor.getCpfLeitor().equals(cpf)) {
                return leitor;
            }
        }
        return null;
    }

    public void cadastrarLeitor(Leitor leitor) {
        if (leitor == null) {
            throw new IllegalArgumentException("Cadastro inválido.");
        }
        if (buscarLeitor(leitor.getCpfLeitor()) != null) {
            throw new IllegalArgumentException("Leitor já cadastrado.");
        }
        leitores.add(leitor);
    }


}

