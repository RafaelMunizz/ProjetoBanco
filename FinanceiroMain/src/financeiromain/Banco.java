package financeiromain;

import java.util.ArrayList;

public class Banco {
    
    ArrayList<Pessoa> registroPessoas = new ArrayList<Pessoa>();
    ArrayList<Conta> registroContas = new ArrayList<Conta>();
    
    public void inserirPessoa(Pessoa nome){
        registroPessoas.add(nome);
    }

}
