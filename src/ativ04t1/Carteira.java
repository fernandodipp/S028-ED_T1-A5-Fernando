package ativ04t1;

// import com.sun.javafx.image.impl.IntArgb;
import net.datastructures.*;
import CreditCards.*;

/**
 *
 * @author brandg
 */
public class Carteira {
    private DoublyLinkedList<Cliente> contas;
    
    public Carteira() {
        contas = new DoublyLinkedList<Cliente>();
    }
    
    public void AdicionarConta(String nome, String cpf, String rg) {
        contas.addFirst(new Cliente(nome, cpf, rg));
    }
    
    public void RemoverConta() {
        Cliente c = contas.removeFirst();
        // return c;
    }
    
    public Cliente ObterConta() {
        if (!contas.isEmpty()) {
            return contas.first();
        } 
        return null;
    }
    
    public void MostrarCarteira() {
        System.out.println("\nSituação da carteira no momento:\n");
        if (contas.isEmpty()) {
            System.out.println("Carteira está vazia");
            return;
        }

        System.out.println(contas);
    }
    
    public static void main(String[] args) {

        Cliente c;
        Carteira contas = new Carteira();

        contas.AdicionarConta("Joao", "111111111", "111.111.111-11");
        c = contas.ObterConta();
        c.AdicionarCartao("Itau", "34346756756");
        c.AdicionarCartao("BB", "13241234123424");
        c.AdicionarCartao("Nubank", "79789785674");

        contas.AdicionarConta("Maria", "2222222222", "222.222.222-22");
        c = contas.ObterConta();
        c.AdicionarCartao("Itau", "5686785678578");
        c.AdicionarCartao("BB", "12342345456547");
        c.AdicionarCartao("Nubank", "346568789890");

        contas.AdicionarConta("Gilberto", "33333333", "333.333.333-33");
        c = contas.ObterConta();
        c.AdicionarCartao("Itau", "1231234234645");
        c.AdicionarCartao("BB", "23434645765");
        c.AdicionarCartao("Nubank", "132234435756");

        contas.MostrarCarteira();
    }
}
