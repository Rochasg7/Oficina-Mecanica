import java.util.Scanner;

import classrelatorios.MenuRelatorios;

import classemecanico.MenuMecanico;
import classemecanico.PersistenciaMecanico;

import classeveiculo.MenuVeiculo;
import classeveiculo.PersistenciaVeiculo;

import classepeca.MenuPeca;
import classepeca.PersistenciaPeca;

import classeordemdeservico.MenuOS;
import classeordemdeservico.PersistenciaOS;

public class SistemaPrincipal {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        PersistenciaMecanico.carregarmecanicoCSV();
        PersistenciaVeiculo.carregarVeiculosCSV();
        PersistenciaPeca.carregarPecasCSV();
        PersistenciaOS.carregarOSCSV();

        int opcao;

        do {

            System.out.println("\n===== SISTEMA OFICINA MECÂNICA =====");

            System.out.println("1 - Mecânicos");
            System.out.println("2 - Veículos");
            System.out.println("3 - Peças");
            System.out.println("4 - Ordem de Serviço");
            System.out.println("5 - Relatórios");
            System.out.println("0 - Sair");

            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    MenuMecanico.abrirMenuMecanico();
                    break;

                case 2:
                    MenuVeiculo.abrirMenuVeiculo();
                    break;

                case 3:
                    MenuPeca.abrirMenuPeca();
                    break;

                case 4:
                    MenuOS.abrirMenuOS();
                    break;

                case 5:
                    MenuRelatorios.abrirMenuRelatorios();
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