package Model.bean;

public class FinanceiroMain {

    public static void main(String[] args) {
        
        Pessoa p1 = new Pessoa("Antonio Fulano", "4.477.843", "1990-5-12");
        Pessoa p2 = new Pessoa("Raissa Lara", "3.274.912", "1974-8-23");
        Pessoa p3 = new Pessoa("Arthur Ciclano", "4.556.231", "1989-1-6");

        Banco registros = new Banco();
        
        Conta c1 = new Conta(p1);
        Conta c2 = new Conta(p2);
        Conta c3 = new Conta(p3);
        
        c1.adicionarSaldo(200);
        c2.adicionarSaldo(500);
        c2.adicionarSaldo(700);

        registros.inserirCliente(c1);
        registros.inserirCliente(c2);
        registros.inserirCliente(c3);

        System.out.println(registros.toString());
        
        c2.removerSaldo(1000);
        
        System.out.println(registros.toString());

    }
}
