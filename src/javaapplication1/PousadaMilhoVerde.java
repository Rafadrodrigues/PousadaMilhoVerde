
package javaapplication1;

public class PousadaMilhoVerde {

    public static void main(String[] args) {
        
        System.out.println("Eu editei!");
        BancoDeDados bd = new BancoDeDados();
        
        bd.inserirCliente("Rafael", "00000", 21, "Diamantina", 39319023, "0113");
        
    }
}
