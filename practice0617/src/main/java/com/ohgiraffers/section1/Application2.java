package com.ohgiraffers.section1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application2 {

    public static void main(String[] args) {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/employee_db";
        String user = "ohgiraffers";
        String password = "ohgiraffers";

        Connection con = null;

        try {
            Class.forName(driver);
            Class.forName("com.mysql.cj.jdbc.Driver");

            try {
                con = DriverManager.getConnection(url, user, password);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println(con);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
}
