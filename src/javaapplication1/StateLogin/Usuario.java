/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1.StateLogin;

/**
 *
 * @author Getúlio
 */
public class Usuario {
    private EstadoUsuario estado;
    
    public Usuario(){
        estado= new EstadoDeslogado();
    }
    public void setEstado(EstadoUsuario estado){
        this.estado=estado;
    }
    public void login(){
        estado.Login();
    }
    public void logout(){
        estado.Logout();
    }
}
