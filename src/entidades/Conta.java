/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.ArrayList;

/**
 *
 * @author clebe
 */
/*
  Esta é a classe Conta. Ela está associada a uma única agência
  e a um único cliente. Lembre-se: um banco pode ter várias agências
  e uma agência pode ter várias contas, assim como um cliente pode ter
  várias contas.
  Uma conta pode ter várias transações, ou seja, um ArrayList de objetos da
  classe Transacao
 */
public class Conta {

    private Agencia agencia; // agência associada a esta conta
    private Pessoa cliente; // pessoa associada a esta conta
    private ArrayList<Transacao> transações = new ArrayList<>(); // transações associadas a esta conta
    private int id; // identifica esta conta
    private String numero; //número e dígito da conta
    private double saldo;
    private double limite;
    public static int contadorContas = 0; //auto incremento para o identificador de cada conta 

    //construtor vazio
    public Conta() {
    }

    //construtor personalizado
    public Conta(Agencia agencia, Pessoa pessoa, int id, String numero, double saldo, double limite) {
        this.agencia = agencia;
        this.cliente = pessoa;
        this.id = id;
        this.numero = numero;
        this.saldo = saldo;
        this.limite = limite;
    }
//metodos geters e seters

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Transacao> getTransações() {
        return transações;
    }

    public void setTransações(ArrayList<Transacao> transações) {
        this.transações = transações;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    
    
}
