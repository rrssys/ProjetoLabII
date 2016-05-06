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

    private List<Cliente> clientes;
    
    public RepositorioClientes() {
        clientes = new ArrayList<Cliente>();
    }

    public boolean addClientes(Cliente paciente) {
        return (clientes.add(paciente));
    }

    public List<Cliente> getListaClientes() {
        return clientes;
    }

    public boolean clienteExiste(String rg) {
        for (Cliente paciente : clientes) {
            if (paciente.getRg().equals(rg)) {
                return true;
            }
        }
        return false;
    }

    public Cliente buscarCliente(String rg) {
        for (Cliente cliente : clientes) {
            if (cliente.getRg().equals(rg)) {
                return cliente;
           }
        }
        return null;
    }
} 
