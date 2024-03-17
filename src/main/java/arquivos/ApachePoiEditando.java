package arquivos;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.*;
import java.util.Iterator;

public class ApachePoiEditando {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Documentos\\projetos\\Apache-POI-e-GSON\\src\\main\\java\\arquivos\\arquivo_excel.xls");
        FileInputStream entrada = new FileInputStream(file);

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);/*Prepara a entrada do arquivo xls excel*/
        HSSFSheet planilha = hssfWorkbook.getSheetAt(0); /*Pegando a planilha*/

        Iterator<Row> linhaIterator = planilha.iterator();

        while (linhaIterator.hasNext()){
            Row linha = linhaIterator.next();/*dados da pessoa na linha*/

            int numeroCelulas = linha.getPhysicalNumberOfCells();/*quantidade de celula*/

            String valorCelula = linha.getCell(0).getStringCellValue();

            linha.getCell(0).setCellValue(valorCelula + " * novo valor gravado");
        }

        entrada.close();

        FileOutputStream saida = new FileOutputStream(file);
        hssfWorkbook.write(saida);
        saida.flush();
        saida.close();
        System.out.println("saida atualizada");

    }
}
