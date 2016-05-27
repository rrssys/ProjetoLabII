package crudpassagemaeria.dao;

import java.util.List;
import crudpassagemaeria.dominio.Aviao;

/**
 *
 * @author rrsantos
 */
//Além dos métodos do Crud padronizado na interface Dao, dois metodos sao obrigatorios.
public interface AviaoDao extends Dao<Aviao>{
    public Aviao procurarPorId(int id);
    public List<Aviao> procurarPorNome(String nome);
    
}