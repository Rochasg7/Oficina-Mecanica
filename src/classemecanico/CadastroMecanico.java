package classemecanico;

import java.util.Scanner;

public class CadastroMecanico {

    static Scanner sc = new Scanner(System.in);

    // Vetor de mecânicos
    public static Mecanico[] Mecanicos = new Mecanico[100];

    // Contador
    public static int totalMecanicos = 0;

    // CADASTRAR MECÂNICO
    public static void cadastrarMecanico() {

        if (totalMecanicos >= 100) {

            System.out.println("Limite máximo de mecânicos atingido.");

            return;
        }

        Mecanico mecanico = new Mecanico();

        System.out.println("\n===== CADASTRO DE MECÂNICO =====");

        System.out.print("Código: ");
        mecanico.codigo = sc.nextInt();
        sc.nextLine();

        if (codigoExiste(mecanico.codigo)) {

            System.out.println("Código já cadastrado.");

            return;
        }

        System.out.print("Nome: ");
        mecanico.nome = sc.nextLine();

        System.out.print("Especialidade: ");
        mecanico.especialidade = sc.nextLine();

        Mecanicos[totalMecanicos] = mecanico;

        totalMecanicos++;

        PersistenciaMecanico.salvarmecanicoCSV();

        System.out.println("Mecânico cadastrado com sucesso.");
    }

    // LISTAR MECÂNICOS
    public static void listarMecanicos() {

        if (totalMecanicos == 0) {

            System.out.println("Nenhum mecânico cadastrado.");

            return;
        }

        System.out.println("\n===== LISTA DE MECÂNICOS =====");

        for (int i = 0; i < totalMecanicos; i++) {

            Mecanico mecanico = Mecanicos[i];

            System.out.println("----------------------");

            System.out.println("Código: " + mecanico.codigo);

            System.out.println("Nome: " + mecanico.nome);

            System.out.println("Especialidade: " + mecanico.especialidade);
        }
    }

    // BUSCAR MECÂNICO
    public static void buscarMecanico() {

        if (totalMecanicos == 0) {

            System.out.println("Nenhum mecânico cadastrado.");

            return;
        }

        System.out.println("\n===== MECÂNICOS DISPONÍVEIS =====");

        for (int i = 0; i < totalMecanicos; i++) {

            Mecanico mecanico = Mecanicos[i];

            System.out.println(
                    "Código: " + mecanico.codigo +
                            " | Nome: " + mecanico.nome);
        }

        System.out.print("\nInforme o código: ");

        int codigo = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < totalMecanicos; i++) {

            Mecanico mecanico = Mecanicos[i];

            if (mecanico.codigo == codigo) {

                System.out.println("\n===== MECÂNICO ENCONTRADO =====");

                System.out.println("Código: " + mecanico.codigo);

                System.out.println("Nome: " + mecanico.nome);

                System.out.println("Especialidade: " + mecanico.especialidade);

                return;
            }
        }

        System.out.println("Mecânico não encontrado.");
    }

    // VALIDAR CÓDIGO
    public static boolean codigoExiste(int codigo) {

        for (int i = 0; i < totalMecanicos; i++) {

            if (Mecanicos[i].codigo == codigo) {

                return true;
            }
        }

        return false;
    }
}
