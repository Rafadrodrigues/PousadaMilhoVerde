package javaapplication1;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    //Inicializando os 10 quaros da memória

    private static Quarto[] Quartos = new Quarto[]{
            new Quarto("001",50,false),
            new Quarto("002",50,false),
            new Quarto("003",50,false),
            new Quarto("004",50,false),
            new Quarto("005",50,false),
            new Quarto("006",50,false),
            new Quarto("007",50,false),
            new Quarto("008",50,false),
            new Quarto("009",50,false),
            new Quarto("010",50,false),
    };
    //cria lista de funcionarios
    public static List ListaFuncionario(){
                List<Funcionario> Colaboradores = new ArrayList<>();
        Funcionario func = new Funcionario("@rafa919", "123023", "Atendente",
                "Rafael", "9830123", "Diamantina", "339989021", "rafar@");
        //Precisa fazer o mesmo para a classe adm que vai ser criada
        Administrador adm = new Administrador("@getulio123", "312083", "Adm",
                "Getulio", "2113123", "Diamantina", "8021983", "getjose@");

        //salvar os objetos na lista;
        Colaboradores.add(func);
        Colaboradores.add(adm);
        return Colaboradores;
    }
 
    
    public boolean FazerLogin(String user, String pin ) {
        //Lista de funcionarios;
        List<Funcionario> Colaboradores = ListaFuncionario();
        //o for percorre a lista dos funcionarios
        for (int i = 0; i < Colaboradores.size(); i++) {
            if (user.equals(Colaboradores.get(i).getUsuario()) && pin.equals(Colaboradores.get(i).getSenha())) {
                //se a senha e usuario bater com algum o login é feito
                System.out.print("Sistema Liberado\n");
                return true;
            }  
        }
        //se ao percorrer o for e não encontrar quer dizer que algum dos campos esta incorreto
        System.out.print("Acesso negado\n");
        //assim o sistema retorna falso
        return false;
    }

    //Método responsável por incluir Cliente,Funcionario ou Administrado na BD
    public void incluir(){

    } 

    //Método responsável por editar Cliente,Funcionario ou Administrado na BD
    public void editar() {

    }

    //Método responsável por editar Cliente,Funcionario ou Administrado na BD
    public void remover() {

    }

    //Método responsável por ler Cliente,Funcionario ou Administrado na BD
    public void ler() {

    }
}
