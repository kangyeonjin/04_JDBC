package com.ohgiraffers.section03.delete;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application {

    public static void main(String[] args) {

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        int result =0;
        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/employee-query.xml"));
            String query = prop.getProperty("deleteEmployee");

            Scanner sc = new Scanner(System.in);
            System.out.println("삭제할 직원번호를 입력하세요 :");
            int emp_id = sc.nextInt();

            pstmt = con.prepareStatement(query);

            pstmt.setInt(1,emp_id);

            result = pstmt.executeUpdate();

        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
            close(con);
        }

        if(result >0){
            System.out.println("삭제 성공");
        }else {
            System.out.println("삭제 실패");
        }


    }

}
