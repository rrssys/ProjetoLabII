package crudpassagemaeria.view.menu;

public class ClienteMenu {
    public static final int OP_CADASTRAR = 1;
    public static final int OP_DELETAR = 2;
    public static final int OP_ATUALIZAR = 3;
    public static final int OP_LISTAR = 4;
    public static final int OP_CONSULTAR = 5;
    public static final int OP_SAIR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1- Cadastrar Cliente\n"
                + "2- Deletar Cliente\n"
                + "3- Atualizar dados do Cliente\n"
                + "4- Listar Cliente\n"
                + "5- Consultar Clientes por Nome\n"
                + "0- Sair"
                + "\n--------------------------------------");
    }    
}
