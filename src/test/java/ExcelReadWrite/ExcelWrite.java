package ExcelReadWrite;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelWrite {
    public static void excelWrite(String name,String gender,
                                  String age,String phone,
                                  String email,String address,int rowNum)
    {

        try{
            String filePath = "src/test/ExcelFiles/Book1.xlsx";
            FileInputStream fileInputStream = new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheet("Employees");

            Object [][] arrToBeWritten = new Object[1][6];
            arrToBeWritten[0][0]=name;
            arrToBeWritten[0][1]=gender;
            arrToBeWritten[0][2]=age;
            arrToBeWritten[0][3]=phone;
            arrToBeWritten[0][4]=email;
            arrToBeWritten[0][5]=address;

            int rowLength = arrToBeWritten.length+rowNum;
            int colLength = arrToBeWritten[0].length+rowNum;

            for(int r=rowNum;r<rowLength;r++){
                Row rows = sheet.createRow(r);
                for(int c=0;c<colLength-rowNum;c++){
                    Cell cell = rows.createCell(c);
                    Object value = arrToBeWritten[r-rowNum][c];
                    if(value instanceof String)
                        cell.setCellValue((String)value);
                    if(value instanceof Number)
                        cell.setCellValue((long)value);
                    if(value instanceof Boolean)
                        cell.setCellValue((Boolean)value);
                }
            }
            FileOutputStream outputStream = new FileOutputStream(filePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();



        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
       excelWrite("Armachen Anbessa","Male","50",
               "123456","arma@gmail.com",
               "456 Addis",0);

    }

}
