package com.ohgiraffers.section01.insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {

    public static void main(String[] args) {

        Connection con = getConnection(); //jdbc에 만들어놓은 클래스(드라이브 불러옴) connection함
        PreparedStatement pstmt =null;  //preparedstatement 변수선언해서 자리만들어줌
        ResultSet rset = null;      //resultset변수 선언해서 자리 만들어줌
        Properties prop = new Properties();   //properties클래스 인스턴스생성

        Scanner sc = new Scanner(System.in);     //스캐너 사용해서 입력값 받고자함
        System.out.println("조회할 직원을 이름을 입력하세요 : ");
        String emp_name = sc.nextLine();

        try {    //xml파일로더
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/employee-query.xml"));
            String query = prop.getProperty("checkEmployee");   //check라는 키에 해당하는 쿼리 문자열을 가져옴
            pstmt = con.prepareStatement(query); //쿼리에 담긴 sql문장이용하여 preparestatment객체 생성함
                                        // 준비된문장은 나중에 파라미터값을 바인딩하여 실행준비함

            rset = pstmt.executeQuery();  //준비된 prepareStatement를 실행하여 결과집합 result를 가져옴


            boolean found = false;  //직원이 발견되었는지 확인함
            while(rset.next()){
                if(rset.getString("emp_name").equals(emp_name)){
                    System.out.println(rset.getInt("emp_id"));
                    System.out.println(rset.getString("emp_name"));
                    System.out.println(rset.getInt("emp_no"));
                    System.out.println(rset.getString("email"));
                    System.out.println(rset.getInt("phone"));
                    System.out.println(rset.getString("dept_code"));
                    System.out.println(rset.getString("job_code"));
                    System.out.println(rset.getString("sal_level"));
                    System.out.println(rset.getDouble("salary"));
                    System.out.println(rset.getDouble("bonus"));
                    System.out.println(rset.getString("manager_id"));
                    System.out.println(rset.getDate("hire_date"));
                    System.out.println(rset.getDate("ent_date"));
                    System.out.println(rset.getString("ent_yn"));
                    found = true;  //검색된 직원과 일치하는 직원이 있으면 true

                }

            }
            if(!found){
                System.out.println("해당 이름의 직원이 없습니다."); //boolean 루프 끝난후 직원 false이면 출력함
            }

        } catch (IOException | SQLException e) {  //예외발생 구문
            throw new RuntimeException(e);     //예외발생시 출력

        }finally {
            close(rset);  //닫아줌 순서대로
            close(pstmt);
            close(con);
        }

    }

}
