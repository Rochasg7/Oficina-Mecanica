package classepeca;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PersistenciaPeca {

    // SALVAR
    public static void salvarPecasCSV() {

        try {

            FileWriter writer = new FileWriter("banco/pecas.csv");

            for (int i = 0; i < CadastroPeca.totalPecas; i++) {

                Peca p = CadastroPeca.pecas[i];

                writer.write(
                        p.id + ";" +
                                p.nome + ";" +
                                p.tipo + ";" +
                                p.valor + ";" +
                                p.quantidade + ";" 
                                );

                writer.write("\n");
            }

            writer.close();

            System.out.println("Peças salvas com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar peças.");
        }
    }

    // CARREGAR
    public static void carregarPecasCSV() {

        try {

            File arquivo = new File("banco/pecas.csv");
            Scanner leitor = new Scanner(arquivo);

            while (leitor.hasNextLine()) {

                String linha = leitor.nextLine();
                String[] p = linha.split(";");

                if (p.length < 6)
                    continue;

                Peca peca = new Peca();

                peca.id = p[0];
                peca.nome = p[1];
                peca.tipo = p[2];
                peca.valor = Double.parseDouble(p[3]);
                peca.quantidade = Integer.parseInt(p[4]);
                ;

                CadastroPeca.pecas[CadastroPeca.totalPecas] = peca;
                CadastroPeca.totalPecas++;
            }

            leitor.close();

            System.out.println("Peças carregadas com sucesso!");

        } catch (IOException e) {
            System.out.println("Arquivo de peças não encontrado.");
        }
    }
}