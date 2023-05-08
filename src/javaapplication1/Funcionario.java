package javaapplication1;

public class Funcionario extends Cliente {
    
    //Atributos da classe Funcionario
    private String usuario;
    private String senha;
    private float salario;
    private float horasTrabalhadas;
    private String cargo;
    
    //Construtor da classe Funcionario
    public Funcionario(String usuario, String senha, float horasTrabalhadas, String cargo, String nome, String cpf, String endereco, int telefone) {
        super(nome, cpf, endereco, telefone);
        this.usuario = usuario;
        this.senha = senha;
        this.horasTrabalhadas = horasTrabalhadas;
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

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getHorarioDeTrabalho() {
        return horasTrabalhadas;
    }

    public void setHorarioDeTrabalho(float horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    //Métodos correspondente a classe
    public void realizarLogin(String usuario, String senha){
        Login login = new Login(usuario,senha);

        if(login.verificarLogin(usuario,senha) == true){
            System.out.print("Acesso liberado.");
        }else{
            System.out.print("Acesso negado.");
        }
        
    }
    public void realizarLogout(){
        //Precisa da funcao do sistema que oferece a opcao logout
    }
    public void situacaoCliente(){
        //Precisa acessar o banco de dados para que isso seja possivel
    }
    public void cancelarReserva(){
        //Acessar método disponível no sistema
    }
    public void lancarDiaria(){
        
    }
  
}
