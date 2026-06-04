package classepeca;

import java.util.Scanner;

public class CadastroPeca {

    static Scanner sc = new Scanner(System.in);

    public static Peca[] pecas = new Peca[100];
    public static int totalPecas = 0;

    // =========================
    // CADASTRAR PEÇA
    // =========================
    public static void cadastrarPeca() {

        if (totalPecas >= 100) {
            System.out.println("Limite máximo de peças atingido.");
            return;
        }

        Peca peca = new Peca();

        System.out.println("\n===== CADASTRO DE PEÇA =====");

        // ID
        String id;

        while (true) {

            System.out.print("ID da peça: ");
            id = sc.nextLine().trim().toUpperCase();

            if (id.isEmpty()) {
                System.out.println("ID não pode ser vazio.");
                continue;
            }

            Peca existente = buscarPecaPorId(id);

            if (existente != null) {

                System.out.println("\nPeça já cadastrada:");
                System.out.println("Nome: " + existente.nome);
                System.out.println("Estoque atual: " + existente.quantidade);

                System.out.print("Deseja somar ao estoque dessa peça? (S/N): ");
                String resp = sc.nextLine();

                if (resp.equalsIgnoreCase("S")) {

                    System.out.print("Quantidade a adicionar: ");
                    int qtd = sc.nextInt();
                    sc.nextLine();

                    existente.quantidade += qtd;

                    PersistenciaPeca.salvarPecasCSV();

                    System.out.println("Estoque atualizado com sucesso!");
                    System.out.println("Novo estoque: " + existente.quantidade);

                } else {
                    System.out.println("Cadastro cancelado.");
                }

                return;
            }

            break;
        }

        peca.id = id;

        // NOME
        System.out.print("Nome da peça: ");
        peca.nome = sc.nextLine();

        // TIPO
        System.out.print("Tipo (motor, freio, suspensão...): ");
        peca.tipo = sc.nextLine();

        // VALOR
        System.out.print("Valor da peça: ");
        peca.valor = sc.nextDouble();

        // ESTOQUE
        System.out.print("Quantidade em estoque: ");
        peca.quantidade = sc.nextInt();
        sc.nextLine();

        pecas[totalPecas] = peca;
        totalPecas++;

        PersistenciaPeca.salvarPecasCSV();

        System.out.println("Peça cadastrada com sucesso.");
    }

    // =========================
    // LISTAR PEÇAS
    // =========================
    public static void listarPecas() {

        if (totalPecas == 0) {
            System.out.println("Nenhuma peça cadastrada.");
            return;
        }

        System.out.println("\n===== LISTA DE PEÇAS =====");

        for (int i = 0; i < totalPecas; i++) {

            Peca p = pecas[i];

            System.out.println("----------------------");
            System.out.println("ID: " + p.id);
            System.out.println("Nome: " + p.nome);
            System.out.println("Tipo: " + p.tipo);
            System.out.println("Valor: " + p.valor);
            System.out.println("Estoque: " + p.quantidade);
        }
    }

    // =========================
    // BUSCAR PEÇA (PADRÃO VEÍCULO)
    // =========================
    public static void buscarPeca() {

        if (totalPecas == 0) {

            System.out.println("Nenhuma peça cadastrada.");
            return;
        }

        System.out.println("\n===== PEÇAS DISPONÍVEIS =====");

        for (int i = 0; i < totalPecas; i++) {

            Peca peca = pecas[i];

            System.out.println(
                    "ID: " + peca.id +
                            " | Nome: " + peca.nome +
                            " | Estoque: " + peca.quantidade);
        }

        System.out.print("\nInforme o ID da peça: ");
        String id = sc.nextLine().trim().toUpperCase();

        for (int i = 0; i < totalPecas; i++) {

            Peca peca = pecas[i];

            if (peca.id.equalsIgnoreCase(id)) {

                System.out.println("\n===== PEÇA ENCONTRADA =====");

                System.out.println("ID: " + peca.id);
                System.out.println("Nome: " + peca.nome);
                System.out.println("Tipo: " + peca.tipo);
                System.out.println("Valor: " + peca.valor);
                System.out.println("Estoque: " + peca.quantidade);

                return;
            }
        }

        System.out.println("Peça não encontrada.");
    }

    // =========================
    // BUSCAR POR ID
    // =========================
    public static Peca buscarPecaPorId(String id) {

        for (int i = 0; i < totalPecas; i++) {

            if (pecas[i].id.equalsIgnoreCase(id)) {
                return pecas[i];
            }
        }

        return null;
    }

    // =========================
    // VERIFICAR EXISTÊNCIA
    // =========================
    public static boolean pecaExiste(String id) {

        for (int i = 0; i < totalPecas; i++) {

            if (pecas[i].id.equalsIgnoreCase(id)) {
                return true;
            }
        }

        return false;
    }

    // =========================
    // CONSUMIR ESTOQUE (OS)
    // =========================
    public static boolean usarPeca(String id, int qtd) {

        Peca peca = buscarPecaPorId(id);

        if (peca == null) {
            System.out.println("Peça não cadastrada no sistema.");
            return false;
        }

        if (peca.quantidade < qtd) {
            System.out.println("INSUFICIÊNCIA DE ESTOQUE!");
            System.out.println("Estoque atual: " + peca.quantidade);
            return false;
        }

        peca.quantidade -= qtd;

        System.out.println("Peça usada com sucesso!");
        System.out.println("Estoque restante: " + peca.quantidade);

        PersistenciaPeca.salvarPecasCSV();

        return true;
    }
}