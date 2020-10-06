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

public class MySQLBilkav {
    final String DB_URL="jdbc:mysql://localhost/deneme";
    final String DB_USER="root";
    final String DB_PASSWORD="root";

    @Test
    public void getEmployeesData() throws SQLException {
        Connection connection=DriverManager.getConnection ( DB_URL, DB_USER, DB_PASSWORD );
        Statement statement=connection.createStatement ( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
        ResultSet resultSet=statement.executeQuery ( "select * from musteri" );

        while (resultSet.next ()) {
            System.out.println ( resultSet.getString ( 2 ) );
        }

        resultSet.close ();
        statement.close ();
        connection.close ();

    }
}