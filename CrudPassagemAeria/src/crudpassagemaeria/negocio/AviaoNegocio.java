package crudpassagemaeria.negocio;

import crudpassagemaeria.dominio.Aviao;
import crudpassagemaeria.dao.impl_BD.AviaoDaoBd;
import java.util.List;
import crudpassagemaeria.dao.AviaoDao;

public class AviaoNegocio {

    private AviaoDao aviaoDao;

    public AviaoNegocio() {
        aviaoDao = new AviaoDaoBd();
    }

    public void salvar(Aviao p) throws NegocioException {
        this.validarCamposObrigatorios(p);
        aviaoDao.salvar(p);
    }

    public List<Aviao> listar() {
        return (aviaoDao.listar());
    }

    public void deletar(Aviao aviao) throws NegocioException {
        if (aviao == null ) {
            throw new NegocioException("Aviao nao existe!");
        }
        aviaoDao.deletar(aviao);
    }

    public void atualizar(Aviao aviao) throws NegocioException {
        if (aviao == null ) {
            throw new NegocioException("Aviao nao existe!");
        }
        this.validarCamposObrigatorios(aviao);
        aviaoDao.atualizar(aviao);
    }

    public Aviao procurarPorId(int id) throws NegocioException {
        if (id == 0) {
            throw new NegocioException("Campo ID nao informado");
        }
        Aviao aviao = aviaoDao.procurarPorId(id);
        if (aviao == null) {
            throw new NegocioException("Aviao nao encontrado");
        }
        return (aviao);
    }
    
    public List<Aviao> procurarPorNome(String nome) throws NegocioException {
        if (nome == null || nome.isEmpty()) {
            throw new NegocioException("Campo nome nao informado");
        }
        return(aviaoDao.procurarPorNome(nome));
    }
    
    
    public boolean aviaoExiste(int id) {
        Aviao aviao = aviaoDao.procurarPorId(id);
        return (aviao != null);
    }

    private void validarCamposObrigatorios(Aviao p) throws NegocioException {
        if (p.getNome() == null || p.getNome().isEmpty()) {
            throw new NegocioException("Campo nome nao informado");
        }
    }

}
