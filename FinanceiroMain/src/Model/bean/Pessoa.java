package Model.bean;

public class Pessoa {
    
    protected String nome;
    protected String RG;
    protected String dataNascimento;

    public Pessoa() {}
    
    public Pessoa(String nome, String RG, String dataNascimento) {
        this.nome = nome;
        this.RG = RG;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getdataNascimento() {
        return dataNascimento;
    }

    public void setdataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
}
