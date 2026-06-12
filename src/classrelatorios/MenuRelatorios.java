package classrelatorios;

import java.util.Scanner;

public class MenuRelatorios {

    static Scanner sc = new Scanner(System.in);

    public static void abrirMenuRelatorios() {

        int opcao;

        do {

            System.out.println("\n===== RELATÓRIOS =====");
            System.out.println("1 - Comissão da Equipe");
            System.out.println("2 - Inventário Crítico");
            System.out.println("3 - Faturamento de Peças");
            System.out.println("0 - Voltar");

            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    Relatorios.relatorioComissaoEquipe();
                    break;

                case 2:
                    Relatorios.relatorioInventarioCritico();
                    break;

                case 3:
                    Relatorios.relatorioFaturamentoPecas();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}