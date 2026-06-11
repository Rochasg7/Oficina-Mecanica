package classeordemdeservico;

import java.util.Scanner;
import classemecanico.CadastroMecanico;
import classeveiculo.CadastroVeiculo;
import classepeca.CadastroPeca;
import classepeca.Peca;

public class CadastroOS {

    static Scanner sc = new Scanner(System.in);

    public static ordemdeservico[] ordens = new ordemdeservico[100];
    public static int totalOS = 0;

    public static void abrirOS() {

        if (totalOS >= 100) {
            System.out.println("Limite máximo de OS atingido.");
            return;
        }

        ordemdeservico os = new ordemdeservico();

        System.out.println("\n===== ABERTURA DE ORDEM DE SERVIÇO =====");

        // NÚMERO DA OS
        System.out.print("Número da OS: ");
        os.numeroOS = sc.nextInt();
        sc.nextLine();

        // PLACA
        while (true) {

            System.out.print("\nPlaca do veículo (L - Listar | N - Nova | ou digite a placa): ");
            String entrada = sc.nextLine().toUpperCase();

            if (entrada.equals("L")) {
                CadastroVeiculo.listarVeiculos();
                continue;
            }

            if (entrada.equals("N")) {
                CadastroVeiculo.cadastrarVeiculo();
                continue;
            }

            if (!CadastroVeiculo.placaExiste(entrada)) {
                System.out.println("Erro: placa não cadastrada. Tente novamente.");
                continue;
            }

            os.placa = entrada;
            break;
        }

        // MECÂNICO
        while (true) {

            System.out.print("\nCódigo do mecânico (L - Listar | N - Novo | ou digite o código): ");
            String entrada = sc.nextLine().toUpperCase();

            if (entrada.equals("L")) {
                CadastroMecanico.listarMecanicos();
                continue;
            }

            if (entrada.equals("N")) {
                CadastroMecanico.cadastrarMecanico();
                continue;
            }

            try {
                int codigo = Integer.parseInt(entrada);

                if (!CadastroMecanico.codigoExiste(codigo)) {
                    System.out.println("Erro: mecânico não cadastrado. Tente novamente.");
                    continue;
                }

                os.codigoMecanico = codigo;
                break;

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um código numérico.");
            }
        }

        // MÃO DE OBRA
        System.out.print("\nValor da mão de obra: ");
        os.valorMaoObra = sc.nextDouble();
        sc.nextLine();

        // PEÇAS
        os.idsPecas  = new String[10];
        os.qtdsPecas = new int[10];
        os.totalItens = 0;

        String continuar = "S";

        while (continuar.equalsIgnoreCase("S") && os.totalItens < 10) {

            String idPeca;

            while (true) {

                System.out.print("\nID da peça (L - Listar | N - Nova | ou digite o ID): ");
                idPeca = sc.nextLine().toUpperCase();

                if (idPeca.equals("L")) {
                    CadastroPeca.listarPecas();
                    continue;
                }

                if (idPeca.equals("N")) {
                    CadastroPeca.cadastrarPeca();
                    continue;
                }

                Peca peca = CadastroPeca.buscarPecaPorId(idPeca);

                if (peca == null) {
                    System.out.println("Erro: peça não cadastrada. Tente novamente.");
                    continue;
                }

                break;
            }

            System.out.print("Quantidade: ");
            int qtd = sc.nextInt();
            sc.nextLine();

            boolean ok = CadastroPeca.usarPeca(idPeca, qtd);

            if (!ok) {
                System.out.println("Item não adicionado. Tente outra peça.");
            } else {
                os.idsPecas[os.totalItens]  = idPeca;
                os.qtdsPecas[os.totalItens] = qtd;
                os.totalItens++;
            }

            if (os.totalItens < 10) {
                System.out.print("\nAdicionar outra peça? (S/N): ");
                continuar = sc.nextLine();
            }
        }

        ordens[totalOS] = os;
        totalOS++;

        PersistenciaOS.salvarOSCSV();

        System.out.println("\nOS aberta com sucesso!");
    }

    public static void listarOS() {

        if (totalOS == 0) {
            System.out.println("Nenhuma OS cadastrada.");
            return;
        }

        System.out.println("\n===== LISTA DE ORDENS DE SERVIÇO =====");

        for (int i = 0; i < totalOS; i++) {

            ordemdeservico os = ordens[i];

            System.out.println("----------------------");
            System.out.println("OS Nº: " + os.numeroOS);
            System.out.println("Placa: " + os.placa);
            System.out.println("Mecânico: " + os.codigoMecanico);
            System.out.println("Mão de Obra: R$ " + os.valorMaoObra);
            System.out.println("Peças utilizadas:");

            for (int j = 0; j < os.totalItens; j++) {
                System.out.println("  - " + os.idsPecas[j] + " | Qtd: " + os.qtdsPecas[j]);
            }
        }
    }
}