package com.ohgiraffers.section01.insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {

    public static void main(String[] args) {

//        Connection con = getConnection();
//        PreparedStatement pstmt =null;
//
//        int result =0;
//
//        Properties prop = new Properties();
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("조회할 직원을 이름을 입력하세요 : ");
//        String emp_name = sc.nextLine();
//
//        try {
//            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/employee-query.xml"));
//
//            String query = prop.getProperty("insertEmployee");
//
//            pstmt = con.prepareStatement(query);
//            pstmt.setInt(1, emp_id);
//            pstmt.setString(2, emp_name);
//            pstmt.setInt(3, emp_no);
//            pstmt.setString(4, email);
//            pstmt.setInt(5, phone);
//            pstmt.setString(6, dept_code);
//            pstmt.setString(7, job_code);
//            pstmt.setString(8, sal_level);
//            pstmt.setDouble(9, salary);
//            pstmt.setDouble(10, bonus);
//            pstmt.setInt(11, manager_id);
//            pstmt.setString(12, hire_date);
//            pstmt.setString(13, ent_date);
//            pstmt.setString(14, ent_yn);
//
//            result = pstmt.executeUpdate();
//
//        } catch (IOException | SQLException e) {
//            throw new RuntimeException(e);
//
//        }finally {
//            close(pstmt);
//            close(con);
//        }
//
    }

}
