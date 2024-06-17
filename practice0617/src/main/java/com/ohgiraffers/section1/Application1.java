package com.ohgiraffers.section1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application1 {
    public static void main(String[] args) {

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver"); //드라이브연결함

            try {
                con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/employee_db",
                        "orgiraffers","ohgiraffers"
                );

                System.out.println(con);


            } catch (SQLException e) {     //sql입셉션
                throw new RuntimeException(e);
            }

        } catch (ClassNotFoundException e) {  //연결오류

            throw new RuntimeException(e);

        } finally {
            if(con != null){    //데이터베이스 연결은 제한된 자원입니다. 연결을 사용한 후에는 반드시 닫아야 합니다.
                                // 그렇지 않으면 메모리 누수나 커넥션 누수(Connection Leak)가 발생
                    try {
                        con.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }


    }


