package javaapplication1;
/**
 * Classe login é uma classe responsável por logar o usuário ao sistema.
 * @author rafar
 */
public class Login {
    
    //Atributos da classe Login
    private String usuario;
    private String senha;

    //Construtor da classe
    public Login(String user,String pin) {
            this.usuario = user;
            this.senha = pin;
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

    @Override
    public String toString() {
        return "Login{" + "usuario=" + usuario + ", senha=" + senha + '}';
    }
    //Método responsável por fazer a verificação do login
    public boolean verificarLogin(String user,String pin){
        //Precisa ir no BD para conferir se os dados conferem.
        if(usuario.equals(user) && senha.equals(pin)){
            return true;
        }else{
            return false;
     }
  }
    //Método acionado para o usuário desconectar do sistema
    public boolean logout(){
        return false;
    }
    
}

