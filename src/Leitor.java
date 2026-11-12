public class Leitor {

    private String nomeLeitor;
    private String cpfLeitor;
    private String telefoneLeitor;
    private String enderecoLeitor;

    // Inicializa leitor com os seus dados cadastrais.
    public Leitor(String nomeLeitor, String cpfLeitor, String telefoneLeitor, String enderecoLeitor) {
        setNomeLeitor(nomeLeitor);
        setCpfLeitor(cpfLeitor);
        setTelefoneLeitor(telefoneLeitor);
        setEnderecoLeitor(enderecoLeitor);
    }

    public String getNomeLeitor() {
        return nomeLeitor;
    }

    public String getCpfLeitor() {
        return cpfLeitor;
    }

    public String getTelefoneLeitor() {
        return telefoneLeitor;
    }

    public String getEnderecoLeitor() {
        return enderecoLeitor;
    }

    public void setNomeLeitor(String nomeLeitor) {
        if (nomeLeitor == null || nomeLeitor.isBlank()) {
            throw new IllegalArgumentException("Nome do leitor vazio.");
        }
        this.nomeLeitor = nomeLeitor;
    }

    private void setCpfLeitor(String cpfLeitor) {
        if (cpfLeitor == null || cpfLeitor.isBlank()) {
            throw new IllegalArgumentException("CPF vazio");
        }
        this.cpfLeitor = cpfLeitor;
    }

    public void setTelefoneLeitor(String telefoneLeitor) {
        if (telefoneLeitor == null || telefoneLeitor.isBlank()) {
            throw new IllegalArgumentException("Telefone vazio");
        }
        this.telefoneLeitor = telefoneLeitor;
    }

    public void setEnderecoLeitor(String enderecoLeitor) {
        if (enderecoLeitor == null || enderecoLeitor.isBlank()) {
            throw new IllegalArgumentException("Endereço vazio");
        }
        this.enderecoLeitor = enderecoLeitor;
    }
}
