package model;

/**
 *
 * @author rrsantos
 * 
 */
public class Aviao {
    private int codigo;
    private String nome;
    private String qtdassentos;

    public Aviao(int codigo, String nome, String qtdassentos) {
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

    public String getAssentos() {
        return qtdassentos;
    }

    public void setAssentos(String assentos) {
        this.qtdassentos = assentos;
    }
    

    
    
    
    
}
