/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Aviao;

/**
 *
 * @author rrsantos
 */
public class RepositorioAvioes {
    private List<Aviao> listaAvioes;

    public RepositorioAvioes() {
        listaAvioes = new ArrayList<Aviao>();
    }

    public boolean addAvioes(Aviao aviao) {
        return (listaAvioes.add(aviao));
    }

    public List<Aviao> getListaAvioes() {
        return listaAvioes;
    }

    public boolean aviaoExiste(int codigo) {
        for (Aviao aviao : listaAvioes) {
            if (aviao.getCodigo()==codigo) {
                return true;
            }
        }
        return false;
    }

    public Aviao buscarAviao(int codigo) {
        for (Aviao aviao : listaAvioes) {
            if (aviao.getCodigo()==codigo) {
                return aviao;
           }
        }
        return null;
    }    
    public Aviao buscarAviaoPorNome(String nome) {
        for (Aviao aviao : listaAvioes) {
            if (aviao.getNome().equals(nome)) {
                return aviao;
           }
        }
        return null;
    }    
}
