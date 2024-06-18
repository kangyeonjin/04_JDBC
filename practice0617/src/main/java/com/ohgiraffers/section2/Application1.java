package com.ohgiraffers.section2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class Application1 {
    public static void main(String[] args) {

        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        stmt = con.createStatement();
        rset = stmt.executeQuery("select emp_id, emp_name from employee"");

         while(rset.next()){
            System.out.println(rset.getString("EMP_ID")+","+rset.getString("EMP_NAME"));
        }



    }
}
