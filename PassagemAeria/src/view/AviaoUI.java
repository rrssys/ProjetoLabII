/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.text.ParseException;
import model.Aviao;
import repositorio.RepositorioAvioes;
import util.Console;
import view.menu.AviaoMenu;

/**
 *
 * @author rrsantos
 */
public class AviaoUI {
    private RepositorioAvioes listaAvioes;

    public AviaoUI(RepositorioAvioes lista) {
        this.listaAvioes = lista;
    }

    public void executar() {
        int opcao = 0;
        do {
            System.out.println(AviaoMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case AviaoMenu.OP_CADASTRAR:
                    cadastrarAvioes();
                    break;
                case AviaoMenu.OP_LISTAR:
                    mostrarAvioes();
                    break;
                case AviaoMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");

            }
        } while (opcao != AviaoMenu.OP_VOLTAR);
    }

    private void cadastrarAvioes() {
        int codigo = Console.scanInt("Codigo: ");
        String nome = Console.scanString("Nome: ");
        
        if (listaAvioes.buscarAviaoPorNome(nome)!=null) {
            System.out.println("Avião já existente no cadastro");
        } else {
            
            String qtdassentos = Console.scanString("Qtd.Assentos: ");
            listaAvioes.addAvioes(new Aviao(codigo, nome, qtdassentos));
            System.out.println("Avião " + nome + " cadastrado com sucesso!");
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
