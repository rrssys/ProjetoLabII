package view;

import java.util.List;
import model.Venda;
import repositorio.RepositorioVendas;
import util.Console;
import util.DateUtil;
import view.menu.RelatorioMenu;
import view.menu.ClientesMenu;

public class RelatorioUI {

    private RepositorioVendas listaVendas;

    public RelatorioUI(RepositorioVendas listaVendas) {
        this.listaVendas = listaVendas;
    }

    public void executar() {
        int opcao = 0;
        do {
            System.out.println(RelatorioMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case RelatorioMenu.OP_LISTARCLIENTE:
                    mostrarRelatorioCliente();
                    break;
                case RelatorioMenu.OP_LISTARPASSAGEIRO:
                    mostrarRelatorioPassageiro();
                    break;
                case RelatorioMenu.OP_LISTARORIGEM:
                    mostrarRelatorioOrigem();
                    break;
                case RelatorioMenu.OP_LISTARDESTINO:
                    mostrarRelatorioDestino();
                    break;
                case RelatorioMenu.OP_LISTARPERIODOVOO:
                    mostrarRelatorioPeriodoVoo();
                    break;    
                case RelatorioMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");

            }
        } while (opcao != ClientesMenu.OP_VOLTAR);
    }

    public void mostrarRelatorioCliente() {
        /*
        for (Consulta consulta : listaConsultas.getListaConsultasFinalizadas()) {
            imprimir(consulta);
        }
        */
    }

    private void mostrarRelatorioPassageiro() {
        /*
        String rg = Console.scanString("Digite o RG do Paciente: ");
        for (Consulta consulta : listaConsultas.getListaConsultasPorPaciente(rg)) {
            imprimir(consulta);
        }
        */
    }

    private void mostrarRelatorioOrigem() {
       /* int mes = Console.scanInt("Mes: ");
        int ano = Console.scanInt("Ano: ");
        for (Consulta consulta : listaConsultas.getListaConsultasPorMes(mes, ano)) {
            imprimir(consulta);
        }
        */
    }

    private void mostrarRelatorioDestino() {
       /* int mes = Console.scanInt("Mes: ");
        int ano = Console.scanInt("Ano: ");
        for (Consulta consulta : listaConsultas.getListaConsultasPorMes(mes, ano)) {
            imprimir(consulta);
        }
        */
    }
    
    private void mostrarRelatorioPeriodoVoo() {
       /* int mes = Console.scanInt("Mes: ");
        int ano = Console.scanInt("Ano: ");
        for (Consulta consulta : listaConsultas.getListaConsultasPorMes(mes, ano)) {
            imprimir(consulta);
        }
        */
    }
    
    
    private void imprimir(Venda venda) {
       /* System.out.println("\nCodigo: " + consulta.getCodigo());
        System.out.println("Data/Hora: " + DateUtil.dateHourToString(consulta.getHorario()));
        System.out.println("Paciente: " + consulta.getPaciente().getNome() + "("
                + consulta.getPaciente().getRg() + ")");
        System.out.println("Prontuario: \n" + consulta.getProntuario());
        System.out.println("Receituário: ");
        //new ReceituarioUI(consulta, null).mostrarReceitas();
*/
    }


}
