package model;

import java.util.Date;
/**
 *
 * @author rrsantos
 */
public class Venda {
    private static int CODIGO_GERADO=1;
    private int codigo;
    private String origem;
    private String destino;
    private Date data;
    private String horario;
    private int codaviao; 

    
    public Venda(String origem, String destino, Date data, String horario, int codaviao ) {
        this.codigo = generateCodigo();
        this.origem = origem;
        this.destino = destino;
        this.data = data;
        this.horario = horario;
        this.codaviao = codaviao;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
   
    public void setData(Date data) {
        this.data = data;
    }

    public Date getData() {
        return data;
    }
    
    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getHorario() {
        return horario;
    }
    
    public void setAviaoCodigo(int aviaocodigo) {
        this.codaviao = aviaocodigo;
    }

    public int getAviaoCodigo() {
        return codaviao;
    }
    
    private int generateCodigo(){
        return(CODIGO_GERADO++);
    }    

}
