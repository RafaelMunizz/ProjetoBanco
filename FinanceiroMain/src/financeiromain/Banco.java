package financeiromain;

import java.util.ArrayList;

public class Banco {
    
    ArrayList<Conta> registroContas = new ArrayList<>();
    
    public void inserirCliente(Conta c){
        registroContas.add(c);
    }

    @Override
    public String toString() {
        return "Banco{" + "RegistroContas = " + registroContas + '}';
    }
    
    
}
