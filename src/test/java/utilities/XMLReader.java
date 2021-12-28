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
    public static Iterator<Row> loadData(String filePath)
    {
        Iterator<Row> itr = null;
        File file = new File(filePath);   //creating a new file instance
        try {
            //obtaining bytes from the file
            FileInputStream fis = new FileInputStream(file);

            //creating Workbook instance that refers to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);

            sheet.getRow(5);
            itr = sheet.iterator();    //iterating over excel file
            itr.next();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return itr;
    }
}
