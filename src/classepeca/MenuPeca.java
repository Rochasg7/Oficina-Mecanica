package classepeca;

import java.util.Scanner;

public class MenuPeca {

    static Scanner sc = new Scanner(System.in);

    public static void abrirMenuPeca() {

        int opcao;

        do {

            System.out.println("\n===== MENU PEÇAS =====");

            System.out.println("1 - Cadastrar Peça");
            System.out.println("2 - Listar Peças");
            System.out.println("3 - Buscar Peça");
            System.out.println("0 - Voltar");

            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    CadastroPeca.cadastrarPeca();
                    break;

                case 2:

                    CadastroPeca.listarPecas();
                    break;

                case 3:

                    CadastroPeca.buscarPeca();
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