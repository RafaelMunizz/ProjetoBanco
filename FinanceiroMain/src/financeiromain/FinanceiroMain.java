package financeiromain;

public class FinanceiroMain {

    public static void main(String[] args) {
        
        Banco registros = new Banco();
        
        Conta c1 = new Conta("Fulano");
        Conta c2 = new Conta("Ciclano");
        Conta c3 = new Conta("Hyey");
        
        c1.adicionarSaldo(200);
        c2.adicionarSaldo(500);
        c2.adicionarSaldo(-900);

        registros.inserirCliente(c1);
        registros.inserirCliente(c2);
        registros.inserirCliente(c3);

        System.out.println(registros.toString());
        
    }
}
