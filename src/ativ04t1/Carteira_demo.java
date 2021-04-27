package ativ04t1;

// import com.sun.javafx.image.impl.IntArgb;
import net.datastructures.*;
import CreditCards.*;

/**
 *
 * @author brandg
 */
public class Carteira_demo {
    private DoublyLinkedList<Cliente_demo> contas;
    
    public Carteira_demo() {
        //TODO: inicializar a lista contas
        contas = new DoublyLinkedList<Cliente_demo>();
    }
    
    public void AdicionarConta(String nome, String cpf, String rg) {
        //TODO: adicionar um novo Cliente_demo na lista contas. 
        //      veja a assinatura dos métodos construtores da classe Cliente_demo
        contas.addFirst(new Cliente_demo(nome, cpf, rg));

        // contas.addLast(new Cliente_demo());
        // Cliente_demo c = contas.last();
        // c.AdicionarCliente_demo(nome, cpf, rg);
    }
    
    public Cliente_demo RemoverConta() {
        //TODO: remover o primeiro ou ultimo Cliente_demo da lista de contas
        Cliente_demo c;
        c = contas.removeFirst();
        return c;
        
        // return contas.removeFirst();
    }
    
    public Cliente_demo ObterConta() {
        //TODO: obter a primeira ou ultima posicao da lista contas (tipo Cliente_demo)
        return contas.first();
    }
    
    public void MostrarCarteira() {
        //TODO: imprimir toda a Carteira, incluindo as informações de cada Cliente_demo e suas contas.
        System.out.println("Carteira de Cliente_demos: \n");
        System.out.println(contas);
    }

    // Exemplo de uso da classe Carteira    
    public static void main(String[] args) {

        Cliente_demo c;
        Carteira_demo contas = new Carteira_demo();

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

        contas.RemoverConta();
        contas.MostrarCarteira();
    }
}
