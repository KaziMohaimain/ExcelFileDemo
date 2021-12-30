package utilities;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class XMLReader
{
    public static Iterator<Row> getRows(String filePath)
    {
        Iterator<Row> itr = null;
        File file = new File(filePath);
        try {
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            itr = sheet.iterator();
            itr.next();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return itr;
    }

    public static Row getRow(String filePath, int rowIndex)
    {
        Row row = null;
        File file = new File(filePath);
        try {
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            row = sheet.getRow(rowIndex);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
        return row;
    }
}
