package javaapplication1;

public class Quarto {
    
    //Atributos da classe Login
    private String id;
    private double preco;
    private String categoria;//podendo ser luxo ou comun
    private boolean ocupation;
    //              IMPORTANTE
    // ACHO QUE OCUPAÇÃO NÃO FAZ SENTIDO E MAIS DA AGENDA, private boolean ocupation;//verifica se o quarto esta ocupado ou não
    //precisa implementar a quantidade de quartos
    
    //Construtor da classe
    public Quarto(String id, double preco, String categoria,boolean ocupation) {
        this.id = id;
        this.preco = preco;
        this.categoria = categoria;
        this.ocupation = ocupation;
    }
    //              IMPORTANTE
    //estou pensando que o quato não precisa dos geter e seter, agente não vai mudar ele, quando iniciar vai ser isso e pronto
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
    public boolean isOcupation() {
        return ocupation;
    }
    public void setOcupation(boolean ocupation) {
        this.ocupation = ocupation;
    }

    @Override
    public String toString() {
        return "Quarto{" + "Id=" + id + ", Preco=" + preco+ "}";
    }
}
