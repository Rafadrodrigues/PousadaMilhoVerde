
package javaapplication1;
/**
 * Classe Administrador é uma subclasse da classe Funcionário. Representa um 
 * Funcionário de alto cargo dentro da Pousada. Até o momento não foi utilizado 
 * dentro do código
 * @author Rafael e Getúlio
 */
public class Administrador extends Funcionario{

    /**
     * Construtor complementar que informação do funcionario 
     * @param usuario - User do usuario
     * @param senha - Senha do usuario
     * @param nome - Nome do usuario
     * @param cpf - Cpf do usuario
     * @param endereco - endereco do usuario
     * @param telefone - Telefone do usuario
     * @param email - email do usuario
     * @param salario  - salario do usuario
     */
    public Administrador(String usuario, String senha, String nome, String cpf, String endereco, String telefone, String email, float salario) {
        
        super(usuario, senha, nome, cpf, endereco, telefone, email,salario);
        this.setCargo(Cargo.ADMINISTRADOR.getValor());
    }
    /**
     * Método que realizar crud do funcionário
     */
    public void crudFuncionário(){
    }
    /**
     * Método que realizar crud do adm
     */
    public void crudAdm(){
        
    }
    /**
     * Método solicita a receita mensal da pousada
     */
    public void balancoMensal(){
        
    }
  
}
