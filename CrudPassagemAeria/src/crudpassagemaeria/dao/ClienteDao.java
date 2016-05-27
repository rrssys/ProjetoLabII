
package crudpassagemaeria.dao;

import java.util.List;
import crudpassagemaeria.dominio.Cliente;

/**
 *
 * @author rrsantos
 */
//Além dos métodos do Crud padronizado na interface Dao, dois metodos sao obrigatorios.
public interface ClienteDao extends Dao<Cliente>{
    public Cliente procurarPorRg(String rg);
    public List<Cliente> procurarPorNome(String nome);
    
    
}
