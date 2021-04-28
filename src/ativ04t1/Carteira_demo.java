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
        
        DoublyLinkedList<CreditCardGratuito> testCards;
        testCards = new DoublyLinkedList<CreditCardGratuito>();
        testCards.addLast(new CreditCardGratuito("Joao", "Itau", "34346756756"));
        testCards.addLast(new CreditCardGratuito("Maria", "BB", "435767789768"));
        testCards.addLast(new CreditCardGratuito("Giberto", "CEF", "12335769"));
        
        System.out.println("Test do get");
        System.out.println(testCards.get(0));
        System.out.println(testCards.get(1));
        System.out.println(testCards.get(2));
        
        System.out.println("\n\nTest do indexOf");
        System.out.println(testCards.indexOf(testCards.get(0)));
        System.out.println(testCards.indexOf(testCards.get(1)));
        System.out.println(testCards.indexOf(testCards.get(2)));

        System.out.println("\n\nTest do add -- foi adicionado mais um item ao comeco da lista");
        testCards.add(2, testCards.get(0));
        System.out.println(testCards);
        
		
		  System.out.
		  println("\n\nTest do remove(index) -- foi removido o item de indice 1");
		  testCards.remove(1); System.out.println(testCards);
		 
        
        System.out.println("\n\nTest do remove(objeto) -- foi removido o item de indice 2, 3o elemento da lista");
        testCards.remove(testCards.get(2));
        System.out.println(testCards);
        
    }
}
