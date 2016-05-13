/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;

/**
 *
 * @author rrsantos
 */
public class RepositorioClientes {

    private List<Cliente> listaClientes;
    
    public RepositorioClientes() {
        listaClientes = new ArrayList<Cliente>();
    }

    public boolean addClientes(Cliente cliente) {
        return (listaClientes.add(cliente));
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public boolean clienteExiste(String rg) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getRg().equals(rg)) {
                return true;
            }
        }
        return false;
    }

    public Cliente buscarCliente(String rg) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getRg().equals(rg)) {
                return cliente;
           }
        }
        return null;
    }
} 
