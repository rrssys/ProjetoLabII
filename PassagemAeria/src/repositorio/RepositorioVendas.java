/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Venda;
import java.util.Date;
import util.Convercoes;

/**
 *
 * @author rrsantos
 */
public class RepositorioVendas {
    private List<Venda> listaVendas;

    public RepositorioVendas() {
        listaVendas = new ArrayList<Venda>();
    }

    public boolean addVendas(Venda venda) {
        return (listaVendas.add(venda));
    }

    public List<Venda> getListaVendas() {
        return listaVendas;
    }

    public boolean vendaExiste(int codigo) {
        for (Venda venda : listaVendas) {
            if (venda.getCodigo()==codigo) {
                return true;
            }
        }
        return false;
    }

    public Venda buscarVenda(int codigo) {
        for (Venda venda : listaVendas) {
            if (venda.getCodigo()==codigo) {
                return venda;
           }
        }
        return null;
    } 
    
    public Venda buscarVendaPorParametros(String origem, String destino, Date data, String horario, int codaviao) {
        
        for (Venda venda : listaVendas) {
            if (venda.getOrigem().equals(origem) &&
                venda.getDestino().equals(destino) &&
                venda.getData().equals(data) && 
                venda.getHorario().equals(horario) &&
                Convercoes.convertToString(venda.getAviaoCodigo()).equals(Convercoes.convertToString(codaviao)) ) {
                return venda;
           }
        }
        return null;
    } 
    
 
    
}
