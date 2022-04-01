package Model.bean;

public class Conta {
    
    protected Pessoa titular;
    protected double saldo;

    public Conta(Pessoa titular) {
        this.titular = titular;
        this.saldo = 0;
    }

    protected Pessoa getTitular() {
        return titular;
    }

    protected void setTitular(Pessoa titular) {
        this.titular = titular;
    }

    protected double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
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
        return "Conta{" + " Titular = " + titular.getNome() + "| Saldo = " + saldo + '}';
    }
    
}
