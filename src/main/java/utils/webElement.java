package utils;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

public class webElement {

    public static void read_Excel_Data() throws FilloException {
        String excelPath = ".\\Data\\dataArchive.xlsx";
        System.out.println(excelPath);

        Fillo fillo = new Fillo();

        Connection connection = fillo.getConnection(excelPath);

        //Select statement
        String strSelectQuery= "SELECT * FROM Data";
    }
}
