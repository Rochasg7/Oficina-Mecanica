package classrelatorios;

import classemecanico.CadastroMecanico;
import classemecanico.Mecanico;

import classeordemdeservico.CadastroOS;
import classeordemdeservico.ordemdeservico;
import classepeca.CadastroPeca;
import classepeca.Peca;

public class Relatorios {

    public static void relatorioComissaoEquipe() {

    System.out.println("\n===== COMISSÃO DA EQUIPE =====");

    if (CadastroMecanico.totalMecanicos == 0) {
        System.out.println("Nenhum mecânico cadastrado.");
        return;
    }

    for (int i = 0; i < CadastroMecanico.totalMecanicos; i++) {

        Mecanico mecanico = CadastroMecanico.Mecanicos[i];

        double total = 0;

        for (int j = 0; j < CadastroOS.totalOS; j++) {

            ordemdeservico os = CadastroOS.ordens[j];

            if (os.codigoMecanico == mecanico.codigo) {
                total += os.valorMaoObra;
            }
        }

        System.out.println(
                "Código: " + mecanico.codigo +
                " | Nome: " + mecanico.nome +
                " | Comissão: R$ " + total);
        }
    }

    public static void relatorioInventarioCritico() {

    System.out.println("\n===== INVENTÁRIO CRÍTICO =====");

    boolean encontrou = false;

    for (int i = 0; i < CadastroPeca.totalPecas; i++) {

        Peca peca = CadastroPeca.pecas[i];

        if (peca.quantidade == 0) {

            encontrou = true;

            System.out.println("----------------------");
            System.out.println("ID: " + peca.id);
            System.out.println("Nome: " + peca.nome);
            System.out.println("Tipo: " + peca.tipo);
            System.out.println("Estoque: " + peca.quantidade);
        }
    }

    if (!encontrou) {
        System.out.println("Nenhuma peça com estoque zerado.");
        }
    }

    public static void relatorioFaturamentoPecas() {

    }
}