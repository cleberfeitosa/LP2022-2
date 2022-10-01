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
    Esta é a clase Banco. A classe Sistema possui uma ArrayList<Banco> de bancos e cada banco possui uma ArrayList de agências
*/
public class Banco {

    public static int getContadorBancos() {
        return contadorBancos;
    }

    public static void setContadorBancos(int aContadorBancos) {
        contadorBancos = aContadorBancos;
    }
    private ArrayList<Agencia> agencias = new ArrayList<>();// Lista de agências
    private int id; // idenficação do banco no Sistema. Não pode repetir
    private String nome; // nome do banco
    private String numero; // número do banco
    private static int contadorBancos= 0; // autoincremento para o identificador de cada banco 
    
    
    // construr vazio

    public Banco() {
    }
    
    //construtor personalizado

    public Banco(int id, String nome, String numero) {
        this.id = id;
        this.nome = nome;
        this.numero = numero;
    }
    
    //permite obter a lista de agências

    public ArrayList<Agencia> getAgencias() {
        return agencias;
    }

    public void setAgencias(ArrayList<Agencia> agencias) {
        this.agencias = agencias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
}
