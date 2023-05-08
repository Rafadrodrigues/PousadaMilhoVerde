package javaapplication1;

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
    
    //Método responsável por fazer a verificação do login
    public boolean verificarLogin(String user,String pin){
        //É preciso criar um método que realiza as verificações no Json
        if(usuario.equals(user) && senha.equals(pin)){
            return true;
        }else{
            return false;
     }
  }
    public boolean logout(){
        return false;
    }
    
}

