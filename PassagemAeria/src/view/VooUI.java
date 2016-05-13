/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.text.ParseException;
import model.Voo;
import model.Aviao;
import repositorio.RepositorioVoos;
import repositorio.RepositorioAvioes;
import util.Console;
import util.DateUtil;
import view.menu.VoosMenu;

/**
 *
 * @author rrsantos
 */
public class VooUI {
    private RepositorioVoos listaVoos;
    private RepositorioAvioes listaAvioes;

    public VooUI(RepositorioVoos lista, RepositorioAvioes lista2) {
        this.listaVoos = lista;
        this.listaAvioes = lista2;
    }

    public void executar() {
        int opcao = 0;
        do {
            System.out.println(VoosMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case VoosMenu.OP_CADASTRAR:
                    cadastrarVoos();
                    break;
                case VoosMenu.OP_LISTAR:
                    mostrarVoos();
                    break;
                case VoosMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");

            }
        } while (opcao != VoosMenu.OP_VOLTAR);
    }

    private void cadastrarVoos() {
        String origem = Console.scanString("Origem: ");
        String destino = Console.scanString("Destino: ");
        String dataString = Console.scanString("Data DD/MM/AAAA: ");
        String horario = Console.scanString("Horario HH:MM : ");
        new AviaoUI(listaAvioes).mostrarAvioes();
        int codaviao = Console.scanInt("Avião Codigo: ");
        Aviao aviao = listaAvioes.buscarAviao(codaviao);
        
        try {
            if (listaVoos.buscarVooPorParametros(origem, destino, DateUtil.stringToDate(dataString), horario, aviao)!=null) {
                System.out.println("Voo já existente no cadastro");
            } else if ( !listaAvioes.aviaoExiste(codaviao) ) {    
                System.out.println("Aviao não existente no cadastro");
            } else {
                
                try {
                    listaVoos.addVoos(new Voo( origem, destino, DateUtil.stringToDate(dataString), horario, aviao));
                    System.out.println("Voo " + origem + " cadastrado com sucesso!");
                    
                } catch (ParseException ex) {
                    System.out.println("Formato de Data inválido!");
                }
                
            }
        } catch (ParseException ex) { 
            System.out.println("Formato de Data inválido!");
        }
    }

    public void mostrarVoos() {
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-10s", "CÓDIGO") + "\t"
                + String.format("%-20s", "|ORIGEM") + "\t"
                + String.format("%-20s", "|DESTINO") + "\t"
                + String.format("%-20s", "|DATA") + "\t"
                + String.format("%-20s", "|HORARIO") + "\t"
                + String.format("%-20s", "|AVIAO"));
        for (Voo voo : listaVoos.getListaVoos()) {
           System.out.println(String.format("%-10s", voo.getCodigo()) + "\t"
                    + String.format("%-20s", "|" + voo.getOrigem()) + "\t"
                    + String.format("%-20s", "|" + voo.getDestino()) + "\t"
                    + String.format("%-20s", "|" + DateUtil.dateToString(voo.getData()) ) + "\t"
                    + String.format("%-20s", "|" + voo.getHorario()) + "\t"
                    + String.format("%-20s", "|" + voo.getAviao().getNome() ));
        }

    } 
    
}
