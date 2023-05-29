
package javaapplication1;

/**
 * Classe conta, é uma classe que corresponde as conta bancária do cliente, ela 
 * tem o papel de preencher informações bancárias do Cliente.
 * @author rafar
 */
public class Conta {

    private int agencia;
    private int numeroConta;
    private String senha;
    private float saldo;
    private String idCliente;

    public Conta(int agencia, int numeroConta, String senha, float saldo, String idCliente) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.senha = senha;
        this.saldo = saldo;
        this.idCliente = idCliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    

}


