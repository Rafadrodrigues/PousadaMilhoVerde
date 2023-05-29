package javaapplication1;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Classe Funcionário é uma subclasse da Classe Cliente. Ela é responsável por 
 * representar o funcionário da Pousada Milho Verde com suas funcionalidades e características
 * @author rafar
 */
public class Funcionario extends Cliente {
    
    //Atributos da classe Funcionario
    private String usuario;
    private String senha;
    private String cargo;
    private float salario;
    
    //Construtor da classe Funcionario
    public Funcionario(){
        super();
    }
    public Funcionario(String usuario, String senha, String cargo, 
        String nome, String cpf, String endereco, String telefone,String email) {
        super(nome, cpf, endereco, telefone,email);
        this.usuario = usuario;
        this.senha = senha;
        this.cargo = cargo;
    }
    //Getters e setters correspondente aos atributos criados nessa classe.
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public float getSalario() {
        return salario;
    }
//Vetor estatico compilado e guardado antes e dinamico ele e alocado dinamicamente.
    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public static Funcionario criarFuncionario(){
        Scanner cin = new Scanner(System.in);
        Funcionario funcionario = new Funcionario();
                System.out.println("Nome");
                funcionario.setNome(cin.nextLine());
                System.out.println("CPF");
                funcionario.setCpf(cin.nextLine());
                System.out.println("endereco");
                funcionario.setEndereco(cin.nextLine());
                System.out.println("Telefone");
                funcionario.setTelefone(cin.nextLine());
                System.out.println("E-mail");
                funcionario.setEmail(cin.nextLine());
                System.out.println("Usuario");
                funcionario.setUsuario(cin.nextLine());
                System.out.println("Senha");
                funcionario.setSenha(cin.nextLine());
                System.out.println("Cargo");
                funcionario.setCargo(cin.nextLine());
        return funcionario;
    }
    @Override
    public String toString() {
        return super.toString() + "Funcionario{" + "usuario=" + usuario + ", senha=" + senha + ", cargo=" + cargo + ", salario=" + salario + '}';
    }
    
    //Métodos correspondente a classe
    /*public void realizarReserva(LocalDate data){
        //Precisa verificar disponibilidade da agenda
        Sistema sistema = new Sistema();
        
        sistema.verificarVaga(data);
        
        //Essa chamada vai vir após uma condificonal
        //Realizando o agendamento da vaga
        sistema.realizarReserva(data,super.getCartaoCredito());

    }*/
    //Métodos que constituem um funcionário da pousada e serão incremetandos na segunda parte do TP
    public void solicitarCancelamento(LocalDate data, String idQuarto){
    }
    public void realizarReserva(LocalDate data, String idQuarto){
    }
    public void lancarDiaria(){
    }
    public void crudCliente(){
    }
    


}
