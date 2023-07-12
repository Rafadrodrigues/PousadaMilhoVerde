package javaapplication1;

/**
 * Classe Quarto, nessa estão contida algumas características do quarto e suas
 * opções.
 * @author rafar
 */

public class Quarto {
    private String id;
    private double preco;
    private String categoria;//podendo ser luxo ou comun
    
    //Construtor da classe
    public Quarto(String id, double preco, String categoria) {
        this.id = id;
        this.preco = preco;
        this.categoria = categoria;
    }

    public Quarto() {
        
    }
   
    //Getters e setters correspondente aos atributos criados nessa classe.
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
      public double getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Quarto{" + "Id= " + id + ", Preco= " + preco + ", Categoria= " + categoria + "}";
    }
}
