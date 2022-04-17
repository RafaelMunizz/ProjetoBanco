package Model.bean;

public class Pessoa {
    
    protected int ID_Pessoa;
    protected String nome;
    protected String RG;
    protected String dataNascimento;

    public Pessoa() {
        this.nome = null;
        this.RG = null;
        this.dataNascimento = null;
    }
    
    public Pessoa(String nome, String RG, String dataNascimento) {
        this.nome = nome;
        this.RG = RG;
        this.dataNascimento = dataNascimento;
    }


    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public String getRG() {
        return RG;
    }

    private void setRG(String RG) {
        this.RG = RG;
    }

    public String getdataNascimento() {
        return dataNascimento;
    }

    private void setdataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
}
