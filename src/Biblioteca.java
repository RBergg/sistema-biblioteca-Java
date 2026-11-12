import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Leitor> leitores = new ArrayList<>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();


    public void cadastrarLivro(Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("Livro inválido");
        }
        ArrayList<Livro> livrosEncontrados = buscarLivro(livro.getIsbn());

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

