package crudpassagemaeria.dominio;

/**
 * @author rrsantos
 */
public class Cliente {
    private int id;
    private String rg, nome, fone;

 

    public Cliente(String rg, String nome, String fone ) {
        this.rg = rg;
        this.nome = nome;
        this.fone = fone;
    }

    public Cliente(int id, String rg, String nome, String fone ) {
        this.id = id;
        this.rg = rg;
        this.nome = nome;
        this.fone = fone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRg() {
        return rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }
    
}
