package javaapplication1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

public class PousadaMilhoVerde {

    public static void main(String[] args) throws IOException, ParseException {
//        Administrador adm = new Administrador("Getulio","123456","gerente","Getulio Santos","123.456.789-57","Diamantina","389985756","getuliosantos@email");
//        
//        List<Administrador> Colaboradores = new ArrayList<>();
//        Colaboradores.add(adm);
//        Sistema.salvarDados(Colaboradores, "Funcionarios.json");
         Scanner cin = new Scanner(System.in);
          System.out.println("Informe o seu usuario e senha");
          String user = cin.next();
          String pin = cin.next();

        Sistema.FazerLogin(user, pin);
    }
}
