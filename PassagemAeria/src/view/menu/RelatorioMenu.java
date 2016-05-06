package view.menu;

public class RelatorioMenu {
    public static final int OP_LISTARCLIENTE = 1;
    public static final int OP_LISTARPASSAGEIRO = 2;
    public static final int OP_LISTARORIGEM = 3;
    public static final int OP_LISTARDESTINO = 4;
    public static final int OP_LISTARPERIODOVOO = 5;
    public static final int OP_VOLTAR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1- Visualizar Relatório Cliente\n"
                + "2- Visualizar Relatório Passageiro\n"
                + "3- Visualizar Relatório Origem\n"
                + "4- Visualizar Relatório Destino\n"
                + "5- Visualizar Relatório por Periodo de Vôo\n"
                + "0- Voltar"
                + "\n--------------------------------------");
    }      
    
}
