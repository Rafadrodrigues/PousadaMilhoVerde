package javaapplication1;

public class Sistema {
    
    //Método responsável por receber o login do adm e funcionario
    public void logar(){
        
        Funcionario func = new Funcionario("@rafa919", "123023", "Atendente", 
        "Rafael", "9830123", "Diamantina", "339989021","rafar@");
        
        //Precisa fazer o mesmo para a classe adm que vai ser criada
        Administrador adm = new Administrador("@getulio123", "312083", "Adm", 
        "Getulio", "2113123", "Diamantina", "8021983","getjose@");
        //Funcionario insere eu login e senha 
        
        Login login = new Login("@rafa919","123023");
        //User e senha do funcionario e adm vai ser verificado e validado
        
        if (login.verificarLogin(func.getUsuario(),func.getSenha())){
            System.out.print("Sistema Liberado");
        }else{
            System.out.print("Acesso negado");
        }
        
    }
    //Método responsável por incluir Cliente,Funcionario ou Administrado na BD
    public void incluir(){
        
    }
    //Método responsável por editar Cliente,Funcionario ou Administrado na BD
    public void editar(){
        
    }
    //Método responsável por editar Cliente,Funcionario ou Administrado na BD
    public void remover(){
        
    }
    //Método responsável por ler Cliente,Funcionario ou Administrado na BD
    public void ler(){
        
    }
}
