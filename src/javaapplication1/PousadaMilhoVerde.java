/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package javaapplication1;

/**
 *
 * @author rafar
 */
public class PousadaMilhoVerde {

    public static void main(String[] args) {
        BancoDeDados BD = new BancoDeDados();
        BD.inserirCliente("Getulio", "123456789", "21", "Diamantina", "38998", "202020");
        BD.lerArquivo();
    }
}
