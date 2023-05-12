package javaapplication1;

public class Quarto {
    
    //Atributos da classe Login
    private String id;
    private float preco;
    private boolean ocupation;//verifica se o quarto esta ocupado ou não
    //precisa implementar a quantidade de quartos
    
    //Construtor da classe
    public Quarto(String id, float preco, boolean ocupation) {
        this.id = id;
        this.preco = preco;
        this.ocupation = ocupation;
    
    }
    //Getters e setters correspondente aos atributos criados nessa classe.
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
      public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    public boolean isOcupation() {
        return ocupation;
    }
    public void setOcupation(boolean ocupation) {
        this.ocupation = ocupation;
    }

    @Override
    public String toString() {
        return "Quarto{" + "Id=" + id + ", Preco=" + preco + ", Ocupation=" + ocupation + '}';
    }
}
