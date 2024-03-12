package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {
    public static void main(String[] args) throws IOException {

        Pessoa pessoa1 = new Pessoa();
        Pessoa pessoa2 = new Pessoa();
        Pessoa pessoa3 = new Pessoa();

        pessoa1.setNome("Anthony");
        pessoa1.setIdade(19);
        pessoa1.setEmail("anthony@outlook.com");

        pessoa2.setNome("Roberto");
        pessoa2.setIdade(20);
        pessoa2.setEmail("roberto@outlook.com");

        pessoa3.setNome("Carlos");
        pessoa3.setIdade(18);
        pessoa3.setEmail("carlos@outlook.com");

        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);

        File arquivo = new File("D:\\Documentos\\projetos\\Apache-POI-e-GSON\\src\\main\\java\\arquivos\\arquivo.csv");

        if(!arquivo.exists()){
            arquivo.createNewFile();
        }

        FileWriter escrever_no_arquivo = new FileWriter(arquivo);

        for(Pessoa p: pessoas){
            escrever_no_arquivo.write(p.getNome() + ";" + p.getIdade() + ";" + p.getEmail() + "\n");
        }

        escrever_no_arquivo.flush();
        escrever_no_arquivo.close();

    }
}
