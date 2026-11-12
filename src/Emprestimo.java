import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {

    private Leitor leitor;
    private Livro livro;

    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao;

    private static final int PRAZO_DIAS = 14;

    // Inicializa o empréstimo.
    public Emprestimo(Leitor leitor, Livro livro) {

        if (leitor == null || livro == null) {
            throw new IllegalArgumentException("O leitor e o livro são obrigatórios para criar um empréstimo.");
        }

        this.dataEmprestimo = LocalDate.now();
        this.dataPrevistaDevolucao = this.dataEmprestimo.plusDays(PRAZO_DIAS);
        this.dataDevolucao = null;

        this.leitor = leitor;
        this.livro = livro;
    }

    public boolean estaAtivo() {
        return dataDevolucao == null;
    }

    public void registrarDevolucao() {
        if (!estaAtivo()) {
            throw new IllegalArgumentException("Este empréstimo já foi encerrado.");
        }
        this.dataDevolucao = LocalDate.now();
    }

    public boolean estaAtrasado() {
        if (estaAtivo()) {
            return LocalDate.now().isAfter(dataPrevistaDevolucao);
        } else {
            return dataDevolucao.isAfter(dataPrevistaDevolucao);

        }
    }

    public int getDiasAtraso() {
        if (!estaAtrasado()) {
            return 0;
        } else if (estaAtivo()) {
            return (int) ChronoUnit.DAYS.between(dataPrevistaDevolucao, LocalDate.now());
        } else {
            return (int) ChronoUnit.DAYS.between(dataPrevistaDevolucao, dataDevolucao);
        }
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
}
