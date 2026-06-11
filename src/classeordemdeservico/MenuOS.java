package classeordemdeservico;

import java.util.Scanner;

public class MenuOS {

    static Scanner sc = new Scanner(System.in);

    public static void abrirMenuOS() {

        int opcao;

        do {

            System.out.println("\n===== MENU ORDEM DE SERVIÇO =====");

            System.out.println("1 - Abrir OS");
            System.out.println("2 - Listar OS");
            System.out.println("0 - Voltar");

            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    CadastroOS.abrirOS();
                    break;

                case 2:

                    CadastroOS.listarOS();
                    break;

                case 0:

                    System.out.println("Voltando...");
                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}