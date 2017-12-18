package mx.com.example.test.utilidades;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelManager {

    public static List read(File xlsxFile) throws IOException {
        List contenido = new ArrayList();

        FileInputStream fis = new FileInputStream(xlsxFile);

        // Finds the workbook instance for XLSX file
        XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);

        // Return first sheet from the XLSX workbook
        XSSFSheet mySheet = myWorkBook.getSheetAt(0);

        // Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = mySheet.iterator();

        // Traversing over each row of XLSX file
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();

                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        contenido.add(cell.getStringCellValue());
                        //System.out.print("s:" + cell.getStringCellValue() + "\t");
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        contenido.add(cell.getNumericCellValue());
                        //System.out.print("n:" + cell.getNumericCellValue() + "\t");
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        contenido.add(cell.getBooleanCellValue());
                        //System.out.print("b:" + cell.getBooleanCellValue() + "\t");
                        break;
                    default :

                }
            }
        }

        return contenido;
    }

    public static void write(File xlsxFile, List<List> registros) throws IOException {
        String nombreHoja1 = "Hoja1";//nombre de la hoja1
        XSSFWorkbook libroTrabajo = new XSSFWorkbook();
        XSSFSheet hoja1 = libroTrabajo.createSheet(nombreHoja1) ;


        //iterando numero de filas (r)
        List filas =
        for (int r=0;r < 5; r++ ) {
            XSSFRow row = hoja1.createRow(r);

            //iterando numero de columnas (c)
            for (int c=0;c < 5; c++ ){
                XSSFCell cell = row.createCell(c);
                cell.setCellValue("Cell "+r+" "+c);
            }
        }

        FileOutputStream fileOut = new FileOutputStream(xlsxFile);

        //escribir este libro en un OutputStream.
        libroTrabajo.write(fileOut);
        fileOut.flush();
        fileOut.close();
    }

    public static void main(String[] args) {
        try {
            File file = new File("/home/cardinal/Descargas/WSPromotoresReferenciados.xlsx");
            //List contenido = ExcelManager.read(file);
            ExcelManager.write(file);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
