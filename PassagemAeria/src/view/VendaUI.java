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
import repositorio.RepositorioVoos;
import repositorio.RepositorioAvioes;
import repositorio.RepositorioVendas;
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

    public VendaUI(RepositorioVendas lista0, RepositorioVoos lista, RepositorioAvioes lista2) {
        this.listaVendas = lista0;
        this.listaVoos = lista;
        this.listaAvioes = lista2;
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
        String origem = Console.scanString("Origem: ");
        String destino = Console.scanString("Destino: ");
        String dataString = Console.scanString("Data DD/MM/AAAA: ");
        String horario = Console.scanString("Horario HH:MM : ");
        mostrarAvioes();
        int codaviao = Console.scanInt("Avião Codigo: ");
        try {
            if (listaVendas.buscarVendaPorParametros(origem, destino, DateUtil.stringToDate(dataString), horario, codaviao)!=null) {
                System.out.println("Venda já existente no cadastro");
            } else if ( !listaAvioes.aviaoExiste(codaviao) ) {    
                System.out.println("Aviao não existente no cadastro");
            } else {
                
                try {
                    listaVendas.addVendas(new Venda( origem, destino, DateUtil.stringToDate(dataString), horario, codaviao));
                    System.out.println("Venda " + origem + " cadastrado com sucesso!");
                    
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
                + String.format("%-20s", "|ORIGEM") + "\t"
                + String.format("%-20s", "|DESTINO") + "\t"
                + String.format("%-20s", "|DATA") + "\t"
                + String.format("%-20s", "|HORARIO") + "\t"
                + String.format("%-20s", "|AVIAO"));
        for (Venda venda : listaVendas.getListaVendas()) {
           System.out.println(String.format("%-10s", venda.getCodigo()) + "\t"
                    + String.format("%-20s", "|" + venda.getOrigem()) + "\t"
                    + String.format("%-20s", "|" + venda.getDestino()) + "\t"
                    + String.format("%-20s", "|" + DateUtil.dateToString(venda.getData()) ) + "\t"
                    + String.format("%-20s", "|" + venda.getHorario()) + "\t"
                    + String.format("%-20s", "|" + listaAvioes.buscarAviao( venda.getAviaoCodigo() ).getNome() ));
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
