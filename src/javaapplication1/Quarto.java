package javaapplication1;

public class Quarto {
    
    //Atributos da classe Login
    private int id;
    private int preco;
    private boolean ocupation;//verifica se o quarto esta ocupado ou não
    
    //Construtor da classe
    public Quarto(int id, int preco, boolean ocupation) {
        this.id = id;
        this.preco = preco;
        this.ocupation = ocupation;
    }
    
    //Getters e setters correspondente aos atributos criados nessa classe.
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
      public int getPreco() {
        return preco;
    }
    public void setPreco(int preco) {
        this.preco = preco;
    }
    public boolean isOcupation() {
        return ocupation;
    }
    public void setOcupation(boolean ocupation) {
        this.ocupation = ocupation;
    }
}
