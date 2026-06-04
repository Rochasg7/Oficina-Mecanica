package classemecanico;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PersistenciaMecanico {

        public static void salvarmecanicoCSV() {

                try {

                        FileWriter writer = new FileWriter("banco/mecanicos.csv");

                        for (int i = 0; i < CadastroMecanico.totalMecanicos; i++) {

                                Mecanico mecanico = CadastroMecanico.Mecanicos[i];

                                writer.write(
                                                mecanico.codigo + ";" +
                                                                mecanico.nome + ";" +
                                                                mecanico.especialidade);

                                writer.write("\n");
                        }

                        writer.close();

                        System.out.println("Mecânicos salvos com sucesso!");

                } catch (IOException e) {

                        System.out.println("Erro ao salvar mecânicos.");
                }
        }

        public static void carregarmecanicoCSV() {

                try {

                        File arquivo = new File("banco/mecanicos.csv");

                        Scanner leitor = new Scanner(arquivo);

                        while (leitor.hasNextLine()) {

                                String linha = leitor.nextLine();

                                String[] partes = linha.split(";");

                                Mecanico mecanico = new Mecanico();

                                mecanico.codigo = Integer.parseInt(partes[0]);

                                mecanico.nome = partes[1];

                                mecanico.especialidade = partes[2];

                                CadastroMecanico.Mecanicos[CadastroMecanico.totalMecanicos] = mecanico;

                                CadastroMecanico.totalMecanicos++;
                        }

                        leitor.close();

                        System.out.println("Mecânicos carregados com sucesso!");

                } catch (IOException e) {

                        System.out.println("Arquivo de mecânicos não encontrado.");
                }
        }
}