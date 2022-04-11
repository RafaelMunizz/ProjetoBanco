package Model.bean;

public class Pessoa {
    
    protected int ID_Pessoa;
    protected String nome;
    protected String RG;
    protected String dataNascimento;

    public Pessoa() {}
    
    public Pessoa(String nome, String RG, String dataNascimento) {
        this.nome = nome;
        this.RG = RG;
        this.dataNascimento = dataNascimento;
    }

    public int getID_Pessoa() {
        return ID_Pessoa;
    }

    public void setID_Pessoa(int ID_Pessoa) {
        this.ID_Pessoa = ID_Pessoa;
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
