package ativ04t1;

// import com.sun.javafx.image.impl.IntArgb;
import net.datastructures.*;
import CreditCards.*;

/**
 *
 * @author brandg
 */
public class Cliente {
    String nome;
    String rg;
    String cpf;
    private DoublyLinkedList<CreditCardGratuito> cartoes;

    // Construtores para inicializar os atributos, seja preenchidos ou vazios
    public Cliente(String str_nome, String doc_rg, String doc_cpf) {
        cartoes = new DoublyLinkedList<CreditCardGratuito>();
        nome = str_nome;
        rg = doc_rg;
        cpf = doc_cpf;
    }
    public Cliente() {
        cartoes = new DoublyLinkedList<CreditCardGratuito>();
    }
    
    // Adicionar o nome, rg e cpf do cliente, sem cartoes
    public void AdicionarCliente(String str_nome, String doc_rg, String doc_cpf) {
        nome = str_nome;
        rg = doc_rg;
        cpf = doc_cpf;
    }

    public void AdicionarCartao(String banco, String conta) {
        cartoes.addFirst(new CreditCardGratuito(nome, banco, conta));
    }
    
    public void RemoverCartao(String banco, String conta) {
        if (!cartoes.isEmpty()) {
            cartoes.removeFirst();
        }
    }
    
    public void MostrarCliente() {
        System.out.println("Nome: " + nome + ", RG: " + rg +", CPF: " + cpf);
        System.out.println("Lista de cartoes:");
        System.out.println(cartoes);
    } 

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: " + nome + ", RG: " + rg +", CPF: " + cpf + "\n");
        sb.append("Lista de cartoes:\n");
        sb.append(cartoes);
        sb.append("\n");
        
        return sb.toString();
    } 
    
}