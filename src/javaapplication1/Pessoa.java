package javaapplication1;

//Classe abstrata responsável por pela geração de futuras heranças
public class Pessoa {
    private String nome;
    private String cpf;
    private String endereco;
    private int telefone;

    //Construtor da classe Pessoa
    public Pessoa(String nome, String cpf, String endereco, int telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    //Getters e setters correspondente aos atributos.
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    
}

