package javaapplication1;

import java.io.IOException;
import java.text.ParseException;

/**
 * Classe Pousada Milho Verde e vai ser responsável por executar nossos
 * arquivos, ela é o arquivo main do nosso programa.
 *
 * @author Rafael Dias Rodrigues
 * @author Getulio José Lima dos Santos
 */
public class PousadaMilhoVerde {

    public static void main(String[] args) throws IOException, ParseException {
        Sistema sistema= new Sistema();
        sistema.criarAdministrador("getulio", "123456", "getulio santos", "14612312399", "diamantina", "389980385", "getulio.santos@email", 5000);
        //QUESTÃO 1
        //IMPLEMENTAMOS TODOS AS CLASSES E METODOS QUE PLANEJAVAMOS
        //REMODELAMOS DE ACORDO COM AS ALTERAÇÕES
        //E CRIAMOS OS NOVOS FLUXOS
        //E ATUALIZAMOS NOSSO DIAGRAMA DE CLASSE, TUDO ESTA PRESENTE NO LATEX
        //QUESTÃO 2
        //1- CRIAMOS NOSSSAS CLASSES DE ACORDO COM O LATEX MAS NOVAS ALTERAÇÕES FORAM NECESSÁRIAS
        //2- POR MEIO DO MÉTODO LOGIN APENAS OS FUNCIONARIOS CADASTRADOS PODEM ACESSAR O SISTEMA
        //QUESTÃO 3
        //
    }
}
