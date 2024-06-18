package com.ohgiraffers.section02.update;

import com.ohgiraffers.model.employeeDTO;

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

        Scanner sc = new Scanner(System.in);
        System.out.println("변경할 직원을 입력하세요 :");
        String NAME  = sc.nextLine();

        System.out.println("새로운 이름을 입력하세요 :");
        String EMP_NAME  = sc.nextLine();

        employeeDTO changedemp = new employeeDTO();
        changedemp.setEMP_NAME(EMP_NAME);

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/employee-query.xml"));

            String query = prop.getProperty("updateEmployee");

            pstmt = con.prepareStatement(query);
            pstmt.setString(1,changedemp.getEMP_NAME()); //새로운 이름을 첫번째 파라미터로 설정
            pstmt.setString(2,NAME);  //기존 이름을 두번째 파라미터로 설정

            result = pstmt.executeUpdate(); //쿼리실행

        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
            close(con);
        }
        if(result > 0){
            System.out.println("변경성공");
        }else {
            System.out.println("변경실패");
        }
    }

}
