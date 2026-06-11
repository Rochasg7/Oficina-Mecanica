package classeordemdeservico;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PersistenciaOS {

    public static void salvarOSCSV() {

        try {

            FileWriter writer = new FileWriter("banco/ordens.csv");

            for (int i = 0; i < CadastroOS.totalOS; i++) {

                ordemdeservico os = CadastroOS.ordens[i];

                // Monta a linha base
                writer.write(
                        os.numeroOS + ";" +
                        os.placa + ";" +
                        os.codigoMecanico + ";" +
                        os.valorMaoObra + ";" +
                        os.totalItens);

                // Adiciona cada peça na mesma linha
                for (int j = 0; j < os.totalItens; j++) {
                    writer.write(";" + os.idsPecas[j] + ";" + os.qtdsPecas[j]);
                }

                writer.write("\n");
            }

            writer.close();

            System.out.println("Ordens salvas com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar ordens.");
        }
    }

    public static void carregarOSCSV() {

        try {

            File arquivo = new File("banco/ordens.csv");
            Scanner leitor = new Scanner(arquivo);

            while (leitor.hasNextLine()) {

                String linha = leitor.nextLine();
                String[] p = linha.split(";");

                if (p.length < 5) continue;

                ordemdeservico os = new ordemdeservico();

                os.numeroOS       = Integer.parseInt(p[0]);
                os.placa          = p[1];
                os.codigoMecanico = Integer.parseInt(p[2]);
                os.valorMaoObra   = Double.parseDouble(p[3]);
                os.totalItens     = Integer.parseInt(p[4]);

                os.idsPecas  = new String[10];
                os.qtdsPecas = new int[10];

                for (int j = 0; j < os.totalItens; j++) {
                    os.idsPecas[j]  = p[5 + (j * 2)];
                    os.qtdsPecas[j] = Integer.parseInt(p[6 + (j * 2)]);
                }

                CadastroOS.ordens[CadastroOS.totalOS] = os;
                CadastroOS.totalOS++;
            }

            leitor.close();

            System.out.println("Ordens carregadas com sucesso!");

        } catch (IOException e) {
            System.out.println("Arquivo de ordens não encontrado.");
        }
    }
}