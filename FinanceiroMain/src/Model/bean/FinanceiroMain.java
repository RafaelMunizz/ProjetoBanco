package Model.bean;

import Model.Dao.ContaDAO;
import Model.Dao.PessoaDAO;

public class FinanceiroMain {

    public static void main(String[] args) {
        
        Pessoa p1 = new Pessoa("Antonio Fulano", "4.477.843", "1990-5-12");
        Pessoa p2 = new Pessoa("Raissa Lara", "3.274.912", "1974-8-23");
        Pessoa p3 = new Pessoa("Arthur Ciclano", "4.556.231", "1989-1-6");
        PessoaDAO daoPessoa = new PessoaDAO();
        ContaDAO daoConta = new ContaDAO();

        
        //dao.delete(p1);
        //dao.readPessoa();
        
        //dao.create(p3);

        
        
        Banco registros = new Banco();
        
        Conta c2 = new Conta(p2, "CC");
        
       

        
        daoConta.insertConta(c2);
        
        
        
        
        /*
        Conta c2 = new Conta(p2);
        Conta c3 = new Conta(p3);

        registros.inserirCliente(c1);
        registros.inserirCliente(c2);
        registros.inserirCliente(c3);
        */
        

    }
}
