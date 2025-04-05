package ExcelReadWrite;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;

public class ExcelRead {

    public static void readExcel(){

        try{
            String filePath = "src/test/ExcelFiles/EmloyeeList.xlsx";
            FileInputStream fileInputStream = new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheet("Employee");

            int rowLength = sheet.getLastRowNum();
            int colLength = sheet.getRow(1).getLastCellNum();


        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
