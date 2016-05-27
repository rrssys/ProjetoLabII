package crudpassagemaeria.view;


import crudpassagemaeria.util.Console;
import crudpassagemaeria.view.menu.MainMenu;
import crudpassagemaeria.dominio.Cliente;


/**
 *
 * @author rrsantos
 */
public class MainUI {
 
    public MainUI() {
        
    }

    public void executar() {
        int opcao = 0;  
        do {
            System.out.println(MainMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case MainMenu.OP_CLIENTES:
                    new ClienteUI().menu();
                    break;
                case MainMenu.OP_AVIOES:
                    new AviaoUI().menu();
                    break;
                case MainMenu.OP_VOOS:
                    //new VooUI().menu();  
                    break;
                case MainMenu.OP_VENDA:
                    //new VendaUI().menu();
                    break;
                case MainMenu.OP_RELATORIOS:
                    //new RelatorioUI().menu();
                    break;
                case MainMenu.OP_SAIR:
                    System.out.println("Aplicação finalizada!!!");
                    break;
                default:
                    System.out.println("Opção inválida..");

            }
        } while (opcao != MainMenu.OP_SAIR);
    }

}
