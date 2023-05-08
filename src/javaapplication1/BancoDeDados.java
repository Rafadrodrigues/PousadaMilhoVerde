package javaapplication1;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

public class BancoDeDados {

    public void inserirCliente(String name, String cpf,int idade,
        String endereco,int telefone,String conta){
        
        JSONObject cliente = new JSONObject();
        cliente.put("Nome ", name);
        cliente.put("CPF ", cpf);
        cliente.put("Idade ", idade);
        cliente.put("Endereço " ,endereco);
        cliente.put("Telefone " , telefone);
        cliente.put("Conta " , conta);
        
        try(FileWriter arquivoJson = new FileWriter("Clientes.json")){
            arquivoJson.write(cliente.toJSONString());
            arquivoJson.flush();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(BancoDeDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
//    public boolean procurarCliente(){
//
//    }
    
}
