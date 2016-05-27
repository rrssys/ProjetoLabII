/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudpassagemaeria.dominio;

/**
 *
 * @author rrsantos
 */
public class Aviao {
    private int id;
    private String nome;
    private int qtdassentos;

    public Aviao( String nome, int qtdassentos ) {
        this.nome = nome;
        this.qtdassentos = qtdassentos;
    }

    public Aviao(int id, String nome, int qtdassentos ) {
        this.id = id;
        this.nome = nome;
        this.qtdassentos = qtdassentos;
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

    public int getQtdassentos() {
        return qtdassentos;
    }

    public void setQtdassentos(int qtdassentos) {
        this.qtdassentos = qtdassentos;
    }
   
}
