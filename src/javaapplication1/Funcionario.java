package javaapplication1;
import java.time.LocalDate;

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
    /**
     * Construtor padrão para caso seja necessário utilizar
     */
    public Funcionario(){
        super();
    }
    
    /**
     * Construtor complementar da classe que preenhcer outras novas informações
     * @param usuario - Nome do usuário
     * @param senha - Senha do usuário
     * @param nome - Nome do usuário
     * @param cpf - Cpf do usuário
     * @param endereco - Endereco do usuário
     * @param telefone - Telefone do usuário
     * @param email - Email do usuário
     * @param salario - Salario do usuário
     */
    public Funcionario(String usuario, String senha, 
        String nome, String cpf, String endereco, String telefone,String email, float salario) {
        this( usuario,  senha, nome,  cpf,  endereco,  telefone, email);
        this.salario=salario;
    }
    
    /**
     * Construtor complementar para ser caso seja utilizado de alguma outra forma dentro do código
     * @param usuario - Nome do usuário
     * @param senha - Senha do usuário
     * @param nome - Nome do usuário
     * @param cpf  - Cpf do usuário
     * @param endereco - Endereco do usuário
     * @param telefone - Telefone do usuário
     * @param email - Salario do usuário
     */
    public Funcionario(String usuario, String senha, 
        String nome, String cpf, String endereco, String telefone,String email) {
        //QUESTÃO 2 - 4
        super(nome, cpf, endereco, telefone,email);
        this.usuario = usuario;
        this.senha = senha;
        this.cargo = Cargo.FUNCIONARIO.getValor();
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
    //QUESTÃO 2-3
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
    /**
     * Método que solicita o cancelamento da reserva
     * @param data - Data da reserva
     * @param idQuarto - Id do quarto
     */
    public void solicitarCancelamento(String data, String idQuarto){
    }
    /**
     * Método que realiza a reserva
     * @param data - Data da reserva
     * @param idQuarto  - Id do quarto
     */
    public void realizarReserva(LocalDate data, String idQuarto){
    }
    /**
     * Método que lança a diária
     */
    public void lancarDiaria(){
    }
    /**
     * Método CRUD Cliente
     */
    public void crudCliente(){
    }
    /**
     * Método que atribui o cargo ao funcionário, depende do entendimento
     */
    public enum Cargo {
        FUNCIONARIO("FUNCIONARIO"),
        ADMINISTRADOR("ADMINISTRADOR");

        private final String valor;

        Cargo(String valor) {
            this.valor = valor;
        }

        public String getValor() {
            return valor;
        }
    }
    


}
