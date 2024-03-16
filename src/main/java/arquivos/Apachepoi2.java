package arquivos;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Apachepoi2 {
    public static void main(String[] args) throws IOException {
        FileInputStream entrada = new FileInputStream(new File("D:\\Documentos\\projetos\\Apache-POI-e-GSON\\src\\main\\java\\arquivos\\arquivo_excel.xls"));

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);/*Prepara a entrada do arquivo excel pra ler*/
        HSSFSheet planilha = hssfWorkbook.getSheetAt(0);/*Pega a primeira planilha do arquivo excel*/

        Iterator<Row> linhaIterator = planilha.iterator();

        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        while (linhaIterator.hasNext()) {

            Row linha = linhaIterator.next(); /*Dados das pessoas na linha*/

            Iterator<Cell> celulas = linha.iterator();

            Pessoa pessoa = new Pessoa();

            while (celulas.hasNext()) {/*Percorrer as celulas*/
                Cell celula = celulas.next();

                switch (celula.getColumnIndex()) {
                    case 0:
                        pessoa.setNome(celula.getStringCellValue());
                        break;
                    case 1:
                        pessoa.setIdade(Double.valueOf(celula.getNumericCellValue()).intValue());
                        break;
                    case 2:
                        pessoa.setEmail(celula.getStringCellValue());
                        break;
                }/*Fim das celulas da linha*/
            }

            pessoas.add(pessoa);
        }
        entrada.close();/*Terminou de ler o arquivo excel*/

        for (Pessoa pessoa: pessoas){
            System.out.println(pessoa);
        }
    }
}
