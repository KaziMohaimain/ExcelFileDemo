package repository;

import org.apache.poi.ss.usermodel.Row;
import utilities.XMLReader;

import java.util.*;

public class LoginRepository {
/*
    public static List<LoginData> getAll()
    {
        List<LoginData> list = new ArrayList<>();
        Iterator<Row> rows = XMLReader.getRows("src/test/Data/loginData.xlsx");

        while(rows.hasNext())
        {
            Row row = rows.next();
            LoginData l = mapRow(row);
            list.add(l);
        }
        return list;
    }

    public static LoginData get(int index)
    {
        Row row = XMLReader.getRow("src/test/Data/loginData.xlsx", index);
        return mapRow(row);
    }

    private static LoginData mapRow(Row row)
    {
        String name = row.getCell(0).getStringCellValue();
        String email = row.getCell(1).getStringCellValue();
        String password = row.getCell(2).getStringCellValue();
        String confirmPassword = row.getCell(3).getStringCellValue();

        return new LoginData(name,email,password,confirmPassword);
    }
*/
}
