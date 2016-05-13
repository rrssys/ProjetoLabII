/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.text.ParseException;
import model.Voo;
import model.Aviao;
import model.Venda;
import model.Cliente;
import repositorio.RepositorioVoos;
import repositorio.RepositorioAvioes;
import repositorio.RepositorioVendas;
import repositorio.RepositorioClientes;
import util.Console;
import util.DateUtil;
import view.menu.VendasMenu;

/**
 *
 * @author rrsantos
 */
public class VendaUI {
    private RepositorioVendas listaVendas;
    private RepositorioVoos listaVoos;
    private RepositorioAvioes listaAvioes;
    private RepositorioClientes listaClientes;

    public VendaUI(RepositorioVendas lista1, RepositorioVoos lista2, RepositorioAvioes lista3, RepositorioClientes lista4 ) {
        this.listaVendas = lista1;
        this.listaVoos = lista2;
        this.listaAvioes = lista3;
        this.listaClientes = lista4;
        
    }

    public void executar() {
        int opcao = 0;
        do {
            System.out.println(VendasMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case VendasMenu.OP_CADASTRAR:
                    cadastrarVendas();
                    break;
                case VendasMenu.OP_LISTAR:
                    mostrarVendas();
                    break;
                case VendasMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");

            }
        } while (opcao != VendasMenu.OP_VOLTAR);
    }

    private void cadastrarVendas() {
        /*
        - Venda de passagens: registra uma venda, 
                              relacionando o cliente, 
                              vôo e horário da compra, 
                              realizando o controle da quantidade de assentos.
        */

        new ClienteUI(listaClientes).mostrarClientes();
        String rg = Console.scanString("RG Cliente: ");
        Cliente cliente = listaClientes.buscarCliente(rg);
        
        new VooUI(listaVoos, listaAvioes ).mostrarVoos();
        int nvoo = Console.scanInt("Codigo Voo: ");
        Voo voo = listaVoos.buscarVoo(nvoo);
        
        String dataString = Console.scanString("Data DD/MM/AAAA: ");
        String horario = Console.scanString("Horario HH:MM : ");
        
        int qtdpassagem = Console.scanInt("Qtd.Passagem: ");
        try {
            if (listaVendas.buscarVendaPorParametros(cliente, voo, DateUtil.stringToDate(dataString), horario )!=null) {
                System.out.println("Venda já existente no cadastro");
            
            } else {
                
                try {
                    listaVendas.addVendas(new Venda( cliente, voo, DateUtil.stringToDate(dataString), horario, qtdpassagem ));
                    listaAvioes.LancaVendaPassagem(voo.getAviao().getCodigo(), qtdpassagem);
                    System.out.println("Venda do Cliente: " + cliente.getNome() + " cadastrado com sucesso!");
                    
                } catch (ParseException ex) {
                    System.out.println("Formato de Data inválido!");
                }
                
            }
        } catch (ParseException ex) { 
            System.out.println("Formato de Data inválido!");
        }
    }

    public void mostrarVendas() {
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-10s", "CÓDIGO") + "\t"
                + String.format("%-20s", "|CLIENTE") + "\t"
                + String.format("%-40s", "|VOO") + "\t"
                + String.format("%-20s", "|DATA") + "\t"
                + String.format("%-20s", "|HORARIO") + "\t"
                + String.format("%-20s", "|QTD.ASSENTOS"));
        for (Venda venda : listaVendas.getListaVendas()) {
           System.out.println(String.format("%-10s", venda.getCodigo()) + "\t"
                    + String.format("%-20s", "|" + venda.getCliente().getNome()) + "\t"
                    + String.format("%-40s", "|" + venda.getVoo().getOrigem() +"/"+ venda.getVoo().getDestino()  ) + "\t"
                    + String.format("%-20s", "|" + DateUtil.dateToString(venda.getData()) ) + "\t"
                    + String.format("%-20s", "|" + venda.getHorario()) + "\t"
                    + String.format("%-20s", "|" + venda.getQtdpassagem() ));
        }

    } 
    
    public void mostrarAvioes() {
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-10s", "CÓDIGO") + "\t"
                + String.format("%-20s", "|NOME") + "\t"
                + String.format("%-20s", "|QTD.ASSENTOS"));
        for (Aviao aviao : listaAvioes.getListaAvioes()) {
            System.out.println(String.format("%-10s", aviao.getCodigo()) + "\t"
                    + String.format("%-20s", "|" + aviao.getNome()) + "\t"
                    + String.format("%-20s", "|" + aviao.getAssentos()));
        }

    }    
    
    
}
