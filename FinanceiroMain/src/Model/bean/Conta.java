package Model.bean;

public class Conta {
    
    protected int ID_Conta;
    protected double saldo;
    protected String tipoConta;
    protected int ID_Pessoa;    
    
    //Necessário para insersão no ContaDAO
    private String RG;

    public Conta(Pessoa p, String tipoConta) {
        this.tipoConta = tipoConta;
        this.saldo = 0;
        this.RG = p.getRG();
    }

    public String getTipoConta() {
        return tipoConta;
    }

    private void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    
    public String getRG() {
        return RG;
    }
   
        
    public void adicionarSaldo(double valor) {
        
        if (valor < 0) {
            System.out.println("ERRO: Valor negativo não permitido como saldo adicional!");
            
        } else {
            this.setSaldo(this.getSaldo() + valor);
        }
    }
    
    public void removerSaldo(double valor) {
        
        if (valor < 0){

            System.out.println("ERRO: Valor negativo não permitido como saldo a ser removido!");
            
        } else {
                    
            if((this.getSaldo() - valor) < 0) {
                this.setSaldo(0);
            
            } else {
                this.setSaldo(this.getSaldo() - valor);
            }
            
        }
    }

    @Override
    public String toString() {
        return "Conta{" + "| Saldo = " + saldo + '}';
    }
    
}
