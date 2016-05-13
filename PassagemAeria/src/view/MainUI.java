package view;

import repositorio.RepositorioAvioes;
import repositorio.RepositorioClientes;
import repositorio.RepositorioVoos;
import repositorio.RepositorioVendas;
import util.Console;
import view.menu.MainMenu;
import model.Cliente;
import model.Aviao;

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
        
        //Clientes
        listaClientes.addClientes(new Cliente("Rodrigo", "1064800173", "54545454"));
        listaClientes.addClientes(new Cliente("Janaina", "1234560000", "54565656"));
        listaClientes.addClientes(new Cliente("Esteban", "9998885555", "55566666"));
        listaClientes.addClientes(new Cliente("Caroline", "7899566455", "54545454"));
       
        //Avioes
        listaAvioes.addAvioes(new Aviao( 1, "TAM",     100  ));
        listaAvioes.addAvioes(new Aviao( 2, "GOL",     150  ));
        listaAvioes.addAvioes(new Aviao( 3, "AVIANCA", 125  ));
        
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
                    new VendaUI(listaVendas, listaVoos, listaAvioes, listaClientes).executar();
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
