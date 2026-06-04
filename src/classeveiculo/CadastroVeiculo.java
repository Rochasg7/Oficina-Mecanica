package classeveiculo;

import java.util.Scanner;

public class CadastroVeiculo {

    static Scanner sc = new Scanner(System.in);

    public static Veiculo[] veiculos = new Veiculo[100];

    public static int totalVeiculos = 0;

    // CADASTRAR VEÍCULO
    public static void cadastrarVeiculo() {

        if (totalVeiculos >= 100) {

            System.out.println("Limite máximo de veículos atingido.");

            return;
        }

        Veiculo veiculo = new Veiculo();

        System.out.println("\n===== CADASTRO DE VEÍCULO =====");

        String placa;

        while (true) {

            System.out.print("Placa: ");
            placa = sc.nextLine().trim().toUpperCase();

            if (placa.isEmpty()) {
                System.out.println("Placa não pode ser vazia.");
                continue;
            }

            if (placaExiste(placa)) {
                System.out.println("Placa já cadastrada. Digite outra.");
                continue;
            }

            break;
        }

        veiculo.placa = placa;

        System.out.print("Modelo: ");
        veiculo.modelo = sc.nextLine();

        System.out.print("Ano: ");
        veiculo.ano = sc.nextInt();
        sc.nextLine();

        System.out.print("Proprietário: ");
        veiculo.proprietario = sc.nextLine();

        System.out.print("Já teve algum problema? (S/N): ");
        veiculo.teveProblema = sc.nextLine();

        if (veiculo.teveProblema.equalsIgnoreCase("S")) {

            System.out.print("Qual problema apresentou? ");
            veiculo.descricaoProblema = sc.nextLine();

        } else {

            veiculo.descricaoProblema = "Nenhum";
        }

        veiculos[totalVeiculos] = veiculo;

        totalVeiculos++;

        PersistenciaVeiculo.salvarVeiculosCSV();

        System.out.println("Veículo cadastrado com sucesso.");
    }

    // LISTAR VEÍCULOS
    public static void listarVeiculos() {

        if (totalVeiculos == 0) {

            System.out.println("Nenhum veículo cadastrado.");

            return;
        }

        System.out.println("\n===== LISTA DE VEÍCULOS =====");

        for (int i = 0; i < totalVeiculos; i++) {

            Veiculo veiculo = veiculos[i];

            System.out.println("----------------------");

            System.out.println("Placa: " + veiculo.placa);
            System.out.println("Modelo: " + veiculo.modelo);
            System.out.println("Ano: " + veiculo.ano);
            System.out.println("Proprietário: " + veiculo.proprietario);
            System.out.println("Já teve problema: " + veiculo.teveProblema);
            System.out.println("Descrição do problema: " + veiculo.descricaoProblema);
        }
    }

    // BUSCAR VEÍCULO
    public static void buscarVeiculo() {

        if (totalVeiculos == 0) {

            System.out.println("Nenhum veículo cadastrado.");

            return;
        }

        System.out.println("\n===== VEÍCULOS DISPONÍVEIS =====");

        for (int i = 0; i < totalVeiculos; i++) {

            Veiculo veiculo = veiculos[i];

            System.out.println(
                    "Placa: " + veiculo.placa +
                            " | Modelo: " + veiculo.modelo);
        }

        System.out.print("\nInforme a placa: ");

        String placa = sc.nextLine().trim().toUpperCase();

        for (int i = 0; i < totalVeiculos; i++) {

            Veiculo veiculo = veiculos[i];

            if (veiculo.placa.equalsIgnoreCase(placa)) {

                System.out.println("\n===== VEÍCULO ENCONTRADO =====");

                System.out.println("Placa: " + veiculo.placa);
                System.out.println("Modelo: " + veiculo.modelo);
                System.out.println("Ano: " + veiculo.ano);
                System.out.println("Proprietário: " + veiculo.proprietario);
                System.out.println("Já teve problema: " + veiculo.teveProblema);
                System.out.println("Descrição do problema: " + veiculo.descricaoProblema);

                return;
            }
        }

        System.out.println("Veículo não encontrado.");
    }

    // VALIDAR PLACA
    public static boolean placaExiste(String placa) {

        for (int i = 0; i < totalVeiculos; i++) {

            if (veiculos[i].placa.equalsIgnoreCase(placa)) {

                return true;
            }
        }

        return false;
    }
}