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

    public Emprestimo realizarEmprestimo(Leitor leitor, Livro livro) {
        if (leitor == null || livro == null) {
            throw new IllegalArgumentException("Não é possível realizar o empréstimo.");
        }

        Leitor leitorEncontrado = buscarLeitor(leitor.getCpfLeitor());
        Livro livroEncontrado = buscarLivroPorIsbn(livro.getIsbn());

        if (leitorEncontrado == null || livroEncontrado == null) {
            throw new IllegalArgumentException("Informações não encontradas");
        }
        if (livroEncontrado.getQuantidadeDisponivel() < 1) {
            throw new IllegalArgumentException("O livro não tem saldo em estoque");
        }

        int contadorEmprestimo = 0;

        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getLeitor().getCpfLeitor().equals(leitorEncontrado.getCpfLeitor())
                    && emprestimo.estaAtivo()) {
                contadorEmprestimo++;
            }
        }
        // Impede que um leitor tenha mais que 2 emprestimos ativos.
        if (contadorEmprestimo >= 2) {
            throw new IllegalArgumentException("Limite de empréstimos atingido - " + contadorEmprestimo + " -");
        }
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getLeitor().getCpfLeitor().equals(leitorEncontrado.getCpfLeitor())
                    && emprestimo.estaAtivo() && emprestimo.estaAtrasado()) {
                throw new IllegalArgumentException("Existe um ou mais empréstimos atrasados para este CPF");
            }
            if (emprestimo.getLivro().getIsbn().equals(livroEncontrado.getIsbn()) && emprestimo.estaAtivo()
                    && emprestimo.getLeitor().getCpfLeitor().equals(leitorEncontrado.getCpfLeitor())) {
                throw new IllegalArgumentException("O leitor já tem um empréstimo deste exemplar. " + livroEncontrado.getTitulo());
            }
        }

        Emprestimo emprestimoAtivo = new Emprestimo(leitorEncontrado, livroEncontrado);

        livroEncontrado.emprestarExemplar();

        emprestimos.add(emprestimoAtivo);

        return emprestimoAtivo;

    }

    public void registrarDevolucao(String cpf, String isbn) {
        if (cpf == null || cpf.isBlank() || isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("Dados inválidos.");
        }
        Livro livroEncontrado = buscarLivroPorIsbn(isbn);
        Leitor leitorEncontrado = buscarLeitor(cpf);

        // Valida e efetua a devolução do exemplar emprestado.
        if (leitorEncontrado == null) {
            throw new IllegalArgumentException("Leitor não cadastrado");
        } else if (livroEncontrado == null) {
            throw new IllegalArgumentException("Livro não cadastrado.");
        }

        boolean emprestimoEncontrado = false;

        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getLeitor().getCpfLeitor().equals(leitorEncontrado.getCpfLeitor())
                    && emprestimo.getLivro().getIsbn().equals(livroEncontrado.getIsbn())
                    && emprestimo.estaAtivo()) {
                emprestimo.registrarDevolucao();
                livroEncontrado.devolverExemplar();
                emprestimoEncontrado = true;
            }
        }

        if (!emprestimoEncontrado) {
            throw new IllegalArgumentException("Não existe empréstimo ativo deste livro para este leitor.");
        }
    }


}

