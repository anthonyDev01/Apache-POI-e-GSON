package arquivos;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApachePoi {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Documentos\\projetos\\Apache-POI-e-GSON\\src\\main\\java\\arquivos\\arquivo_excel.xls");

        if (!file.exists()){
            file.createNewFile();
        }

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

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();/*Vai ser usado pra escrever a planilha*/
        HSSFSheet linhasPessoa = hssfWorkbook.createSheet("Planilha de pessoas");/* Vai criar a planilha*/

        int numeroLinha = 0;
        for (Pessoa p: pessoas){
            Row linha = linhasPessoa.createRow(numeroLinha++); /*Criando a linha na planilha*/

            int celula = 0;

            Cell celNome = linha.createCell(celula++);
            celNome.setCellValue(p.getNome());

            Cell celIdade = linha.createCell(celula++);
            celIdade.setCellValue(p.getIdade());

            Cell celEmail = linha.createCell(celula++);
            celEmail.setCellValue(p.getEmail());
        }/*Termino de mostrar a planilha*/

        FileOutputStream saida = new FileOutputStream(file);
        hssfWorkbook.write(saida);/*Escreve a planilha em arquivo*/

        saida.flush();
        saida.close();

        System.out.println("Planilha foi Criada");

    }
}


