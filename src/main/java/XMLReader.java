import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class XMLReader
{
    public static void loadPatients(String filePath, PatientRepository repository)
    {
        File file = new File(filePath);   //creating a new file instance
        try {
            //obtaining bytes from the file
            FileInputStream fis = new FileInputStream(file);

            //creating Workbook instance that refers to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);

            sheet.getRow(5);
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file
            itr.next();
            while (itr.hasNext()) {
                Row row = itr.next();
                String gender = row.getCell(0).getStringCellValue();
                String age = row.getCell(1).getStringCellValue();
                String incident = row.getCell(2).getStringCellValue();
                String dept = row.getCell(3).getStringCellValue();

                Patient p = new Patient(gender, age, incident, dept);
                repository.addPatient(p);
//                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
//                while (cellIterator.hasNext()) {
//                    Cell cell = cellIterator.next();
//                    switch (cell.getCellType()) {
//                        case STRING:    //field that represents string cell type
//                            System.out.print(cell.getStringCellValue() + "\t\t\t");
//                            break;
//                        case NUMERIC:    //field that represents number cell type
//                            System.out.print(cell.getNumericCellValue() + "\t\t\t");
//                            break;
//                        default:
//                    }
//                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
