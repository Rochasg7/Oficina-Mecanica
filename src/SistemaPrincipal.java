import java.util.Scanner;

import classemecanico.MenuMecanico;
import classemecanico.PersistenciaMecanico;

public class SistemaPrincipal {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Carrega os mecânicos salvos no CSV
        PersistenciaMecanico.carregarmecanicoCSV();

        int opcao;

        do {

            System.out.println("\n===== SISTEMA OFICINA =====");

            System.out.println("1 - Mecânicos");
            System.out.println("0 - Sair");

            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    MenuMecanico.abrirMenuMecanico();
                    break;

                case 0:

                    System.out.println("Sistema encerrado.");
                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}