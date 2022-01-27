package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XMLReader
{
    public static String basePath = "src/test/Data/";

    public static List<List<String>> getRows(String filePath)
    {
        List<List<String>> datas = new ArrayList<>();
        File file = new File(basePath + filePath);
        try {
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);

            Iterator<Row> itr = sheet.iterator();

            //Skip the first row (Header):
            itr.next();

            while(itr.hasNext())
            {
                List<String> rowData = new ArrayList<>();

                Row row = itr.next();
                Iterator<Cell> rowItr = row.iterator();

                while(rowItr.hasNext())
                {
                    Cell cell = rowItr.next();
                    DataFormatter formatter = new DataFormatter();
                    String val = formatter.formatCellValue(cell);
                    rowData.add(val);
                }
                datas.add(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return datas;
    }

    public static List<String> getRow(String filePath, int rowIndex)
    {
        List<String> datas = new ArrayList<>();

        File file = new File(basePath + filePath);
        try {
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            Row row = sheet.getRow(rowIndex);

            Iterator<Cell> itr = row.iterator();

            while(itr.hasNext())
            {
                Cell cell = itr.next();
                DataFormatter formatter = new DataFormatter();
                String val = formatter.formatCellValue(cell);

                datas.add(val);
            }

            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
        return datas;
    }

    public static int getRowCount(String filePath)
    {
        int row = 0;
        File file = new File(basePath + filePath);
        try {
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            row = sheet.getLastRowNum();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
        return row;
    }
}
