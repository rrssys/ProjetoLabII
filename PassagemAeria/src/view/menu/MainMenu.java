package view.menu;

public class MainMenu {

    public static final int OP_CLIENTES = 1;
    public static final int OP_AVIOES = 2;
    public static final int OP_VOOS = 3;
    public static final int OP_VENDA = 4;
    public static final int OP_RELATORIOS = 5;
    public static final int OP_SAIR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1- Menu Clientes\n"
                + "2- Menu Aviões\n"
                + "3- Menu Vôos\n"
                + "4- Menu Venda de Passagem\n"
                + "5- Menu Relatorio\n"
                + "0- Sair da Aplicação"
                + "\n--------------------------------------");
    }
}
