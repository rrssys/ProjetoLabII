/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Date;
import java.util.Objects;
import util.DateUtil;

/**
 *
 * @author rrsantos
 */
public class Cliente {
    private String rg, nome, fone;

    public Cliente(String nome, String rg, String fone) {
        this.nome = nome;
        this.rg = rg;
        this.fone = fone;
    }


    public String getNome() {
        return nome;
    }

    public String getRg() {
        return rg;
    }

    public String getFone() {
        return fone;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.rg);
        return hash;
    }

    @Override
    public String toString() {
        return rg+" - "+nome + ", " + fone;
    }
    
    
    
    
    
}
