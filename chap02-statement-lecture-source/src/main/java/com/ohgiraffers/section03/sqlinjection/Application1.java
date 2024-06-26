package com.ohgiraffers.section03.sqlinjection;

import com.mysql.cj.protocol.WatchableOutputStream;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {

        //employee id와 이름을 입력받고 두개가 일치하는 employee 있는지 확인하는기능

        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("id와 이름 두개가 일치하는 employee가 있는지 확인하는 기능입니다");

        System.out.println("id를 입력하세요 :");
        String empID = sc.nextLine();

        System.out.println("회원이름을 입력하세요 :");
        String empName = sc.nextLine();

        String query = "select * from employee where emp_id ='" + empID + "'and emp_name ='" + empName + "'";
        System.out.println(query);

        //select* from employee where emp_id '200' and emp_name ='선동일'

        try {

            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            if(rset.next()){
                System.out.println(rset.getString("emp_name")+"님 환영합니다");

            }else{
                System.out.println("회원정보가 없습니다.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(stmt);
            close(con);


        }


    }

}
