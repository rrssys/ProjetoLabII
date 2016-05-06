package view;

import model.Cliente;
import repositorio.RepositorioClientes;
import util.Console;
//import util.DateUtil;
import view.menu.ClientesMenu;

/**
 *
 * @author rrsantos
 */
public class ClienteUI {

    private RepositorioClientes lista;

    public ClienteUI(RepositorioClientes lista) {
        this.lista = lista;
    }

    public void executar() {
        int opcao = 0;
        do {
            System.out.println(ClientesMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case ClientesMenu.OP_CADASTRAR:
                    cadastrarCliente();
                    break;
                case ClientesMenu.OP_LISTAR:
                    mostrarClientes();
                    break;
                case ClientesMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");

            }
        } while (opcao != ClientesMenu.OP_VOLTAR);
    }

    private void cadastrarCliente() {
        String rg = Console.scanString("RG: ");
        if (lista.clienteExiste(rg)) {
            System.out.println("RG já existente no cadastro");
        } else {
            String nome = Console.scanString("Nome: ");
            String fone = Console.scanString("Fone: ");
            lista.addClientes(new Cliente(nome, rg, fone));
            System.out.println("Cliente " + nome + " cadastrado com sucesso!");
           
        }
    }


public void mostrarClientes() {
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-10s", "RG") + "\t"
                + String.format("%-20s", "|NOME") + "\t"
                + String.format("%-20s", "|FONE"));
        for (Cliente cliente : lista.getListaClientes()) {
            System.out.println(String.format("%-10s", cliente.getRg()) + "\t"
                    + String.format("%-20s", "|" + cliente.getNome()) + "\t"
                    + String.format("%-20s", "|" + cliente.getFone() ));
        }

    }
}
