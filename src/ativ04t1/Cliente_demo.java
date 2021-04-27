package ativ04t1;

// import com.sun.javafx.image.impl.IntArgb;
import net.datastructures.*;
import CreditCards.*;

/**
 *
 * @author brandg
 */
public class Cliente_demo {
    private String nome;
    private String rg;
    private String cpf;
    private DoublyLinkedList<CreditCardGratuito> cartoes;

    // Construtores para inicializar os atributos, seja preenchidos ou vazios
    public Cliente_demo(String str_nome, String doc_rg, String doc_cpf) {
        //TODO: inicializar todos os atributos
        nome = str_nome;
        rg = doc_rg;
        cpf = doc_cpf;
        cartoes = new DoublyLinkedList<CreditCardGratuito>();
    }
    public Cliente_demo() {
        //TODO: inicializar somente a lista e o resto fica vazio
        cartoes = new DoublyLinkedList<CreditCardGratuito>();
    }
    
    // Adicionar o nome, rg e cpf do cliente, sem cartoes
    public void AdicionarCliente(String str_nome, String doc_rg, String doc_cpf) {
        //TODO: atribuir valores aos atributos de nome, rg e cpf caso estejam vazios
        nome = str_nome;
        rg = doc_rg;
        cpf = doc_cpf;
    }

    public void AdicionarCartao(String banco, String conta) {
        //TODO: adicionar um cartao a lista de cartoes
        cartoes.addFirst(new CreditCardGratuito(nome, banco, conta));
    }
    public void AdicionarCartao(String nome, String banco, String conta) {
        //TODO: adicionar um cartao a lista de cartoes
        cartoes.addFirst(new CreditCardGratuito(nome, banco, conta));
    }
    
    public void RemoverCartao() {
        //TODO: remover o primeiro ou ultimo cartao da lista de cartoes (a escola)
        cartoes.removeFirst();
        
        // CreditCardGratuito c;
        // c = cartoes.removeFirst();
        // return c;
    }
    
    public void MostrarCliente() {
        //TODO: imprimir as informações do cliente
        System.out.println("Nome: " + nome + ", RG: " + rg +", CPF: " + cpf + "\n");
        System.out.println("Lista de cartoes:\n");
        System.out.println(cartoes);
    } 

    // Metodo toString esta pronto, retorna as informacoes do clinte em uma string.
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: " + nome + ", RG: " + rg +", CPF: " + cpf + "\n");
        sb.append("Lista de cartoes:\n");
        sb.append(cartoes);
        sb.append("\n");
        
        return sb.toString();
    } 
    
}