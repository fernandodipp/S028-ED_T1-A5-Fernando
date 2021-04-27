/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CreditCards;

/**
 *
 * @author brandg
 */
public class CreditCardGratuito extends S028_aula01_creditcard_v02 {
    // TODO: // Se quiserem adicionar algum outro atributo, como pontos 
    
    public CreditCardGratuito(String cust, String bk, String acnt, int lim, double initialBal, double taxaJuros) {
        super(cust, bk, acnt, lim, initialBal, taxaJuros);
    }
    
    // Aqui estamos chamando o método super que ira executar o construtor
    // da superclasse S028_aula01_creditcard_v02 (e estar o )
    public CreditCardGratuito(String cust, String bk, String acnt) {
        super(cust, bk, acnt, 500, 0.0, 10.0);               
    }
    
    public String toString() {
        return "Cliente = " + customer + 
               ", Banco = " + bank +
               ", Conta = " + account +
               ", Saldo = " + balance +
               ", Limite = " +  limit + "\n";
    }
    // TODO: se quiserem alterar o comportamento da cobrança, 
    // public boolean charge(double price) {               // make a charge    
        // Repliquem aqui o código do metodo charge da classe S028_aula01_creditcard_v02 
        // e alterem o que for necessário.
    // }
    
}
