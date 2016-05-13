package model;

/**
 *
 * @author rrsantos
 * 
 */
public class Aviao {
    private int codigo;
    private String nome;
    private int qtdassentos;

    public Aviao(int codigo, String nome, int qtdassentos) {
        this.codigo = codigo;
        this.nome = nome;
        this.qtdassentos = qtdassentos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAssentos() {
        return qtdassentos;
    }

    public void setAssentos(int assentos) {
        this.qtdassentos = assentos;
    }
    

    
    
    
    
}
