/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Voo;
import java.util.Date;
import util.Convercoes;

/**
 *
 * @author rrsantos
 */
public class RepositorioVoos {
    private List<Voo> listaVoos;

    public RepositorioVoos() {
        listaVoos = new ArrayList<Voo>();
    }

    public boolean addVoos(Voo voo) {
        return (listaVoos.add(voo));
    }

    public List<Voo> getListaVoos() {
        return listaVoos;
    }

    public boolean vooExiste(int codigo) {
        for (Voo voo : listaVoos) {
            if (voo.getCodigo()==codigo) {
                return true;
            }
        }
        return false;
    }

    public Voo buscarVoo(int codigo) {
        for (Voo voo : listaVoos) {
            if (voo.getCodigo()==codigo) {
                return voo;
           }
        }
        return null;
    } 
    
    public Voo buscarVooPorParametros(String origem, String destino, Date data, String horario, int codaviao) {
        
        for (Voo voo : listaVoos) {
            if (voo.getOrigem().equals(origem) &&
                voo.getDestino().equals(destino) &&
                voo.getData().equals(data) && 
                voo.getHorario().equals(horario) &&
                Convercoes.convertToString(voo.getAviaoCodigo()).equals(Convercoes.convertToString(codaviao)) ) {
                return voo;
           }
        }
        return null;
    } 
    
 
    
}
