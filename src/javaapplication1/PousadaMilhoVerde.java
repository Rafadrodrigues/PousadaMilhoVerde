package javaapplication1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import org.json.simple.JSONArray;;
//import org.json.simple.parser.ParseException;;

/**
 * Classe Pousada Milho Verde e vai ser responsável por executar nossos arquivos,
 * ela é o arquivo main do nosso programa.
 * @author rafar
 */
public class PousadaMilhoVerde {

    public static void main(String[] args) throws IOException, ParseException {
//        Administrador adm = new Administrador("Getulio","123456","gerente","Getulio Santos","123.456.789-57","Diamantina","389985756","getuliosantos@email");
//        
//        List<Administrador> Colaboradores = new ArrayList<>();
//        Colaboradores.add(adm);
//        Sistema.salvarDados(Colaboradores, "Funcionarios.json");
        
        Funcionario func = new Funcionario();
        Scanner cin = new Scanner(System.in,"ISO-8859-1");
        System.out.println("Informe o seu usuario e senha");
        System.out.print("Usuario: ");
        String user = cin.next();
        System.out.print("Senha: ");
        String pin = cin.next();

        boolean login = Sistema.FazerLogin(user, pin);
        
        Sistema.executar(func);
        
    }
}
