public class Contas {
    private int id;
    private String documento;
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private double saldo;
    private double valorBoleto;

    public Contas(int id, String documento, String nome, String telefone, String email, String senha, double saldo,
            double valorBoleto) {
        this.id = id;
        this.documento = documento;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.saldo = saldo;
        this.valorBoleto = valorBoleto;
    }

    public int getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getValorBoleto() {
        return valorBoleto;
    }

    public void setValorBoleto(double valorBoleto) {
        this.valorBoleto = valorBoleto;
    }
}