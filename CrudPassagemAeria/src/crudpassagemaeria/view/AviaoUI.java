package crudpassagemaeria.view;

import java.text.ParseException;
import crudpassagemaeria.dominio.Aviao;
import crudpassagemaeria.negocio.NegocioException;
import crudpassagemaeria.negocio.AviaoNegocio;
import crudpassagemaeria.util.Console;
import crudpassagemaeria.util.DateUtil;
import crudpassagemaeria.view.menu.AviaoMenu;
import java.util.InputMismatchException;
import java.util.List;

/**
 *
 * @author rrsantos
 */
public class AviaoUI {

    private AviaoNegocio aviaoNegocio;

    public AviaoUI() {
        aviaoNegocio = new AviaoNegocio();
    }

    public void menu() {
        int opcao = -1;
        do {
            try {
                System.out.println(AviaoMenu.getOpcoes());
                opcao = Console.scanInt("Digite sua opção:");
                switch (opcao) {
                    case AviaoMenu.OP_CADASTRAR:
                        cadastrarAviao();
                        break;
                    case AviaoMenu.OP_DELETAR:
                        deletarAviao();
                        break;
                    case AviaoMenu.OP_ATUALIZAR:
                        atualizarAviao();
                        break;
                    case AviaoMenu.OP_LISTAR:
                        AviaoUI.this.mostrarAvioes();
                        break;
                    case AviaoMenu.OP_CONSULTAR:
                        consultarAvioesPorNome();
                        break;
                    case AviaoMenu.OP_SAIR:
                        System.out.println("Finalizando a aplicacao..");
                        break;
                    default:
                        System.out.println("Opção inválida..");
                }
            } catch (InputMismatchException ex) {
                UIUtil.mostrarErro("Somente numeros sao permitidos!");
            }

        } while (opcao != AviaoMenu.OP_SAIR);
    }

    private void cadastrarAviao() {
        String nome = Console.scanString("Nome: ");
        int qtdassentos = Console.scanInt("Qtd.Assentos: ");
        try {
            aviaoNegocio.salvar(new Aviao( nome, qtdassentos));
            System.out.println("Aviao " + nome + " cadastrado com sucesso!");
        } catch (NegocioException ex) {
            UIUtil.mostrarErro(ex.getMessage());
        }
    }

    public void mostrarAvioes() {
        List<Aviao> listaAvioes = aviaoNegocio.listar();
        this.mostrarAvioes(listaAvioes);
    }

    private void deletarAviao() {
        int id = Console.scanInt("Id do aviao a ser deletado: ");
        try {
            Aviao avi = aviaoNegocio.procurarPorId(id);
            this.mostrarAviao(avi);
            if (UIUtil.getConfirmacao("Realmente deseja excluir esse aviao?")) {
                aviaoNegocio.deletar(avi);
                System.out.println("Aviao deletado com sucesso!");
            } else {
                System.out.println("Operacao cancelada!");
            }
        } catch (NegocioException ex) {
            UIUtil.mostrarErro(ex.getMessage());
        }
    }

    private void atualizarAviao() {
        int id = Console.scanInt("Id do Aviao a ser alterado: ");
        try {
            Aviao avi = aviaoNegocio.procurarPorId(id);
            this.mostrarAviao(avi);
            System.out.println("Digite os dados do aviao que quer alterar [Vazio caso nao queira]");
            String nome = Console.scanString("Nome: ");
            int qtdassentos = Console.scanInt("Qtd.Assentos: ");
            if (!nome.isEmpty()) {
                avi.setNome(nome);
            }
            if ( qtdassentos > 0 ) {
                avi.setQtdassentos(qtdassentos); 
            }
            aviaoNegocio.atualizar(avi);
            System.out.println("Aviao " + nome + " atualizado com sucesso!");
        } catch (NegocioException ex) {
            UIUtil.mostrarErro(ex.getMessage());
        }
    }

    private void consultarAvioesPorNome() {
        String nome = Console.scanString("Nome: ");
        try {
            List<Aviao> listaPac = aviaoNegocio.procurarPorNome(nome);
            this.mostrarAvioes(listaPac);
        } catch (NegocioException ex) {
            UIUtil.mostrarErro(ex.getMessage());
        }

    }

    private void mostrarAviao(Aviao p) {
        System.out.println("-----------------------------");
        System.out.println("Aviao");
        System.out.println("Nome: " + p.getNome());
        System.out.println("Qtd.Assentos: " + p.getQtdassentos());
        System.out.println("-----------------------------");
    }

    private void mostrarAvioes(List<Aviao> listaAvioes) {
        if (listaAvioes.isEmpty()) {
            System.out.println("Avioes nao encontrados!");
        } else {
            System.out.println("-----------------------------\n");
            System.out.println(String.format("%-10s", "ID") + "\t"
                    + String.format("%-20s", "|NOME") + "\t"
                    + String.format("%-20s", "|QTD.ASSENTOS"));
            for (Aviao aviao : listaAvioes) {
                System.out.println(String.format("%-10s", aviao.getId()) + "\t"
                        + String.format("%-20s", "|" + aviao.getNome()) + "\t"
                        + String.format("%-20s", "|" + aviao.getQtdassentos()));
            }
        }
    }
  
}
