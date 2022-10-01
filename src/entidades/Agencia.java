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
 /* Esta é a agencia. Uma agência pertence a um banco somente, e possui uma ArrayList de 
    objetos da classe Conta. Lembre-se de uma conta pertence a somente uma agência, e uma agência pode ter inúmeras conta.
    */
public class Agencia {
    private ArrayList<Conta> contas = new ArrayList<>();
    private Banco banco; // o banco o qual essa agência pertence
    private int id;  //identificação da agência no Sistema. Não pode repetir
    private String numero; // número da agência, geralmente com dígito
    private String cidade; // cidade da agência. Você pode colocar mais informações aqui
    public static int contadorAgencias = 0; //autoincremento para o identificador de cada agência
    
    //construtor vazio

    public Agencia() {
    }
    //construtor personalizado
    public Agencia(Banco banco, int id, String numero, String cidade) {
        this.banco = banco;
        this.id = id;
        this.numero = numero;
        this.cidade = cidade;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
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

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public static int getContadorAgencias() {
        return contadorAgencias;
    }

    public static void setContadorAgencias(int contadorAgencias) {
        Agencia.contadorAgencias = contadorAgencias;
    }

        
}
