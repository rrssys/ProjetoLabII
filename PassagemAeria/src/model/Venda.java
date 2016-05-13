package model;

import java.util.Date;

/**
 *
 * @author rrsantos
 */
public class Venda {
    private static int CODIGO_GERADO=1;
    private int codigo;
    private Cliente cliente;
    private Voo voo;
    private Date data;
    private String horario;
    private int qtdpassagem; 


    public Venda(Cliente cliente, Voo voo , Date data, String horario, int qtdpassagem ) {
        this.codigo = generateCodigo();
        this.cliente = cliente;
        this.voo = voo;
        this.data = data;
        this.horario = horario;
        this.qtdpassagem = qtdpassagem;
    }
        
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }
            
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
    
    
    public int getQtdpassagem() {
        return qtdpassagem;
    }

    public void setQtdpassagem(int qtdpassagem) {
        this.qtdpassagem = qtdpassagem;
    }
        
    private int generateCodigo(){
        return(CODIGO_GERADO++);
    }    

}
