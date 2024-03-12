package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivo {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream entradaArquivo = new FileInputStream(new File("D:\\Documentos\\projetos\\Apache-POI-e-GSON\\src\\main\\java\\arquivos\\arquivo.csv"));

        Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");

        List pessoas = new ArrayList<Pessoa>();

        while(lerArquivo.hasNext()){
            String linha = lerArquivo.nextLine();
            if (linha != null && !linha.isEmpty()){
                String[] dados = linha.split("\\;");
                Pessoa pessoa = new Pessoa();

                pessoa.setNome(dados[0]);
                pessoa.setIdade(Integer.parseInt(dados[1]));
                pessoa.setEmail(dados[2]);

                pessoas.add(pessoa);
            }
        }
        System.out.println(pessoas.toString());
    }

}
