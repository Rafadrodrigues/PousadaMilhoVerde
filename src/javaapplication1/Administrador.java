
package javaapplication1;
/**
 * Classe Administrador é uma subclasse da classe Funcionário. Representa um 
 * Funcionário de alto cargo dentro da Pousada. Até o momento não foi utilizado 
 * dentro do código
 * @author rafar
 */
public class Administrador extends Funcionario{

    public Administrador(String usuario, String senha, String nome, String cpf, String endereco, String telefone, String email, float salario) {
        
        super(usuario, senha, nome, cpf, endereco, telefone, email,salario);
        this.setCargo(Cargo.ADMINISTRADOR.getValor());
    }
    public void crudFuncionário(){
        
    }
    public void crudAdm(){
        
    }
    public void balancoMensal(){
        
    }
  
}
