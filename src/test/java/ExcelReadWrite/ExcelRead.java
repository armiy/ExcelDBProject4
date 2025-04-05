package ExcelReadWrite;

import org.apache.poi.ss.usermodel.*;

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

            for(int r=0;r<rowLength;r++){
                Row rows = sheet.getRow(r);
                for(int c=0;c<colLength;c++){
                    Cell cell = rows.getCell(c);
                    switch (cell.getCellType()){
                        case STRING: System.out.print(cell.getStringCellValue()+" ");break;
                        case NUMERIC:System.out.print(cell.getNumericCellValue()+" ");break;
                        case BOOLEAN:System.out.print(cell.getBooleanCellValue()+" ");break;
                    }

                }
                System.out.println();
            }


        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        readExcel();
    }
}
