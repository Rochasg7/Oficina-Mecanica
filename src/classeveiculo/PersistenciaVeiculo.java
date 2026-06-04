package classeveiculo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PersistenciaVeiculo {

    // SALVAR VEÍCULOS NO CSV
    public static void salvarVeiculosCSV() {

        try {

            FileWriter writer = new FileWriter("banco/veiculos.csv");

            for (int i = 0; i < CadastroVeiculo.totalVeiculos; i++) {

                Veiculo veiculo = CadastroVeiculo.veiculos[i];

                writer.write(
                        veiculo.placa + ";" +
                                veiculo.modelo + ";" +
                                veiculo.ano + ";" +
                                veiculo.proprietario + ";" +
                                veiculo.teveProblema + ";" +
                                veiculo.descricaoProblema);

                writer.write("\n");
            }

            writer.close();

            System.out.println("Veículos salvos com sucesso!");

        } catch (IOException e) {

            System.out.println("Erro ao salvar veículos.");
        }
    }

    // CARREGAR VEÍCULOS DO CSV
    public static void carregarVeiculosCSV() {

        try {

            File arquivo = new File("banco/veiculos.csv");

            Scanner leitor = new Scanner(arquivo);

            while (leitor.hasNextLine()) {

                String linha = leitor.nextLine();

                String[] partes = linha.split(";");

                Veiculo veiculo = new Veiculo();

                veiculo.placa = partes[0];
                veiculo.modelo = partes[1];
                veiculo.ano = Integer.parseInt(partes[2]);
                veiculo.proprietario = partes[3];
                veiculo.teveProblema = partes[4];
                veiculo.descricaoProblema = partes[5];

                CadastroVeiculo.veiculos[CadastroVeiculo.totalVeiculos] = veiculo;

                CadastroVeiculo.totalVeiculos++;
            }

            leitor.close();

            System.out.println("Veículos carregados com sucesso!");

        } catch (IOException e) {

            System.out.println("Arquivo de veículos não encontrado.");
        }
    }
}