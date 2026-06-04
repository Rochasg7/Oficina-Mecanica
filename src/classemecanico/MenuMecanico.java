package classemecanico;

import java.util.Scanner;

public class MenuMecanico {

    static Scanner sc = new Scanner(System.in);

    // MENU DE MECÂNICOS
    public static void abrirMenuMecanico() {

        int opcao;

        do {

            System.out.println("\n===== MENU MECÂNICOS =====");

            System.out.println("1 - Cadastrar Mecânico");
            System.out.println("2 - Listar Mecânicos");
            System.out.println("3 - Buscar Mecânico");
            System.out.println("0 - Voltar");

            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    CadastroMecanico.cadastrarMecanico();
                    break;

                case 2:

                    CadastroMecanico.listarMecanicos();
                    break;

                case 3:

                    CadastroMecanico.buscarMecanico();
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