package QuerriesDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ASelectQuery {
    public static void selectQuery(){

        try{
            final String DB_URL = "jdbc:mysql://localhost:3306/DB_Employees";
            final String USERNAME ="root";
            final String PASSWORD = "1234";

            Connection connection = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            String sql ="Select * From employees23";
            PreparedStatement statement = connection.prepareStatement(sql);


            final var resultsSet = statement.executeQuery();
            final var metaData = resultsSet.getMetaData();

            for(int r= 1;r<metaData.getColumnCount();r++){
                System.out.print(metaData.getColumnName(r)+" ");
            }

            System.out.println();


            while (resultsSet.next()){
                for(int r=1;r<metaData.getColumnCount();r++){
                    System.out.print(resultsSet.getObject(r)+" ");
                }
                System.out.println();
            }
            System.out.println();
            statement.close();
            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        selectQuery();
    }
}
