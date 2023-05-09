package javaapplication1;

public class QuartoLuxo extends Quarto {
    
    //Atributos da classe QuartoLuxo
    //Não se é preciso colocar quantidade de quarto, apenas deixar um valor estabelecido
    private int quantidade_quarto = 5;
    
    //Alguns atributos foram herdados da classe Quarto
    public QuartoLuxo(int id, int preco, boolean ocupation) {
        super(id, preco, ocupation);
    }

    public int getQuantidade_quarto() {
        return quantidade_quarto;
    }

    public void setQuantidade_quarto(int quantidade_quarto) {
        this.quantidade_quarto = quantidade_quarto;
    }

    @Override
    public String toString() {
        return super.toString() + "QuartoLuxo{" + "quantidade_quarto=" + quantidade_quarto + '}';
    }
    
    
}
