package repository;

import formModels.LoginData;
import org.apache.poi.ss.usermodel.Row;
import utilities.XMLReader;

import java.util.*;

public class LoginRepository {

    static List<LoginData> repositoryList = new ArrayList<>();

    public static void loadData()
    {
        Iterator<Row> rows = XMLReader.loadData("src/test/Data/loginData.xlsx");

        while(rows.hasNext())
        {
            Row row = rows.next();
            String name = row.getCell(0).getStringCellValue();
            String email = row.getCell(1).getStringCellValue();
            String password = row.getCell(2).getStringCellValue();
            String confirmPassword = row.getCell(3).getStringCellValue();

            LoginData l = new LoginData(name,email,password,confirmPassword);
            repositoryList.add(l);
        }
    }
}
