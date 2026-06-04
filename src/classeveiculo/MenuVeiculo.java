package classeveiculo;

import java.util.Scanner;

public class MenuVeiculo {

    static Scanner sc = new Scanner(System.in);

    public static void abrirMenuVeiculo() {

        int opcao;

        do {

            System.out.println("\n===== MENU VEÍCULOS =====");

            System.out.println("1 - Cadastrar Veículo");
            System.out.println("2 - Listar Veículos");
            System.out.println("3 - Buscar Veículo");
            System.out.println("0 - Voltar");

            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    CadastroVeiculo.cadastrarVeiculo();
                    break;

                case 2:

                    CadastroVeiculo.listarVeiculos();
                    break;

                case 3:

                    CadastroVeiculo.buscarVeiculo();
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