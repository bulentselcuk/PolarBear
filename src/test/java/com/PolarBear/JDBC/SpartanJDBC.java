package com.PolarBear.JDBC;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class SpartanJDBC {
    final String DB_URL="jdbc:oracle:thin:@54.174.216.245:1521:xe";
    final String DB_USER="SP";
    final String DB_PASSWORD="SP";

    @Test
    public void getEmployeesData() throws SQLException {
        Connection connection=DriverManager.getConnection ( DB_URL, DB_USER, DB_PASSWORD );
        Statement statement=connection.createStatement ( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
        ResultSet resultSet=statement.executeQuery ( "select * from spartans" );

        while (resultSet.next ()) {
            System.out.println ( resultSet.getString ( 2 ) );
        }

        resultSet.close ();
        statement.close ();
        connection.close ();

    }

    @Test
    public void writeToExcel() throws SQLException, IOException {
        Connection connection=DriverManager.getConnection ( DB_URL, DB_USER, DB_PASSWORD );
        Statement statement=connection.createStatement ( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
        ResultSet resultSet=statement.executeQuery ( "select * from spartans" );

        List<String> info = new ArrayList<> ();
        while(resultSet.next()){
            String name = resultSet.getString ( "name" );
            String gender = resultSet.getString ( "gender" );
            String phone = resultSet.getString ( 4 );
            String fullInfo = name + "|" +gender+ "|" +phone;
            info.add(fullInfo);
        }

        // Excel

        HSSFWorkbook workbook = new HSSFWorkbook (); // Create blank workbook

        HSSFSheet sheet = workbook.createSheet ("Spartans Name"); // Create blank Sheet

        HSSFRow row; // Create Row object

        Map< String, Object[] > dataInfo = new TreeMap< String, Object[] > ();
        while(resultSet.next()) {
            String name = resultSet.getString ( "name" );
        }
        Set<String>record = dataInfo.keySet ();

        int rowRecord = 0;

        for(String x : record){
            row = sheet.createRow ( rowRecord++ );
            Object[] y = dataInfo.get ( x );
            int cellRecord=0;

            for(Object obj : y){
                Cell cell = row.createCell ( cellRecord++ );
                cell.setCellValue ( (String)obj );
            }
        }
        // Write the workbook in file system
        FileOutputStream out = new FileOutputStream (new File ("Family Data.xls")  );

        workbook.write (out);
        out.close ();
        System.out.println ("Family Data writen successfully");



    }


}
