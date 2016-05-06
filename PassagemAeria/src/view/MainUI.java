package view;

import repositorio.RepositorioAvioes;
import repositorio.RepositorioClientes;
import repositorio.RepositorioVoos;
import repositorio.RepositorioVendas;
import util.Console;
import view.menu.MainMenu;

/**
 *
 * @author rrsantos
 */
public class MainUI {
    private RepositorioClientes listaClientes;
    private RepositorioAvioes listaAvioes;
    private RepositorioVoos listaVoos;
    private RepositorioVendas listaVendas;


    public MainUI() {
        listaClientes = new RepositorioClientes();
        listaAvioes = new RepositorioAvioes();
        listaVoos = new RepositorioVoos();
        listaVendas = new RepositorioVendas();
       
    }

    public void executar() {
        int opcao = 0;
        do {
            System.out.println(MainMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case MainMenu.OP_CLIENTES:
                    new ClienteUI(listaClientes).executar();
                    break;
                case MainMenu.OP_AVIOES:
                    new AviaoUI(listaAvioes).executar();
                    break;
                case MainMenu.OP_VOOS:
                    new VooUI(listaVoos, listaAvioes ).executar();  
                    break;
                case MainMenu.OP_VENDA:
                    new VendaUI(listaVendas, listaVoos, listaAvioes).executar();
                    break;
                case MainMenu.OP_RELATORIOS:
                    new RelatorioUI(listaVendas).executar();
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
