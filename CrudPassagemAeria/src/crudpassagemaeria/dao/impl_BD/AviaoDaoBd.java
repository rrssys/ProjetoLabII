package crudpassagemaeria.dao.impl_BD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import crudpassagemaeria.dominio.Aviao;
import crudpassagemaeria.dao.AviaoDao;

public class AviaoDaoBd extends DaoBd<Aviao> implements AviaoDao {
  

    //Metodo salvar: trabalhar com data e recebe o id auto-increment 
    //e já relaciona no objeto aviao (recebido por parâmetro)
    //Caso queira retornar, só retornar id.
    @Override
    public void salvar(Aviao aviao) {
        int id = 0;
        try {
            String sql = "INSERT INTO aviao ( nome, qtdassentos ) "
                    + "VALUES (?,?)";

            //Foi criado um novo método conectar para obter o id
            conectarObtendoId(sql);
            comando.setString(1, aviao.getNome());
            comando.setInt(2, aviao.getQtdassentos());
            comando.executeUpdate();
            //Obtém o resultSet para pegar o id
            ResultSet resultado = comando.getGeneratedKeys();
            if (resultado.next()) {
                //seta o id para o objeto
                id = resultado.getInt(1);
                aviao.setId(id);
            }
            else{
                System.err.println("Erro de Sistema - Nao gerou o id conforme esperado!");
                throw new BDException("Nao gerou o id conforme esperado!");
            }

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao salvar aviao no Banco de Dados!");
            throw new RuntimeException(ex);
        } finally {
            fecharConexao();
        }
    }

    @Override
    public void deletar(Aviao aviao) {
        try {
            String sql = "DELETE FROM aviao WHERE id = ?";

            conectar(sql);
            comando.setInt(1, aviao.getId());
            comando.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao deletar aviao no Banco de Dados!");
            throw new RuntimeException(ex);
        } finally {
            fecharConexao();
        }

    }

    @Override
    public void atualizar(Aviao aviao) {
        try {
            String sql = "UPDATE aviao SET nome=?, qtdassentos=? "
                    + "WHERE id=?";

            conectar(sql);
            comando.setString(1, aviao.getNome());
            comando.setInt(2, aviao.getQtdassentos());
            comando.setInt(3, aviao.getId());
            comando.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao atualizar Aviao no Banco de Dados!");
            throw new RuntimeException(ex);
        } finally {
            fecharConexao();
        }

    }

    @Override
    public List<Aviao> listar() {
        List<Aviao> listaAvioes = new ArrayList<>();

        String sql = "SELECT * FROM aviao";

        try {
            conectar(sql);

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                int qtdassentos = resultado.getInt("qtdassentos");

                Aviao avi = new Aviao(id, nome, qtdassentos );

                listaAvioes.add(avi);

            }

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar os aviões do Banco de Dados!");
            throw new RuntimeException(ex);
        } finally {
            fecharConexao();
        }

        return (listaAvioes);
    }

    @Override
    public Aviao procurarPorId(int id) {
        String sql = "SELECT * FROM aviao WHERE id = ?";

        try {
            conectar(sql);
            comando.setInt(1, id);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                String nome = resultado.getString("nome");
                int qtdassentos = resultado.getInt("qtdassentos");                

                Aviao avi = new Aviao(id, nome, qtdassentos );

                return avi;

            }

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar o Aviao pelo id do Banco de Dados!");
            throw new RuntimeException(ex);
        } finally {
            fecharConexao();
        }

        return (null);
    }

    @Override
    public List<Aviao> procurarPorNome(String nome) {
        List<Aviao> listaAvioes = new ArrayList<>();
        String sql = "SELECT * FROM aviao WHERE nome LIKE ?";

        try {
            conectar(sql);
            comando.setString(1, "%" + nome + "%");
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nomeX = resultado.getString("nome");
                int qtdassentos = resultado.getInt("qtdassentos");

                Aviao avi = new Aviao(id, nomeX, qtdassentos );

                listaAvioes.add(avi);

            }

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar os aviões pelo nome do Banco de Dados!");
            throw new RuntimeException(ex);
        } finally {
            fecharConexao();
        }
        return (listaAvioes);
    }
}
