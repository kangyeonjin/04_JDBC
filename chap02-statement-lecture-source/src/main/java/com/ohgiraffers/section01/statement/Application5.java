package com.ohgiraffers.section01.statement;

import com.ohgiraffers.model.dto.EmployDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application5 {
    public static void main(String[] args) {

        //1. connection 객체생성
        Connection con = getConnection();

        //2. statement 생성
        Statement stmt = null;

        //3. resultset 생성
        ResultSet rset = null ;

        //리스트생성
        List<EmployDTO> empList = null;

        //employeeDTO생성
        EmployDTO row =null;


        try {
            //4.연결객체의 createStatement()를 이용한 Statement 객체 생성
            stmt = con.createStatement();

            //employee테이블 전체조회
            String query = "select * from employee";

            //5.executeQuery()로 쿼리문을 실행하고 결과를 resultset에 반환 받기
           rset =stmt.executeQuery(query);

           empList = new ArrayList<>();


           //6.쿼리문의 결과를 컬럼이름을 이용해서 사용
           while (rset.next()){

               row = new EmployDTO();

               row.setEmpId(rset.getString("EMP_ID"));
               row.setEmpName(rset.getString("EMP_NAME"));
               row.setEmpNo(rset.getString("EMP_NO"));
               row.setEmail(rset.getString("EMAIL"));
               row.setPhone(rset.getString("PHONE"));
               row.setDeptCode(rset.getString("DEPT_CODE"));
               row.setJobCode(rset.getString("JOB_CODE"));
               row.setSalLevel(rset.getString("SAL_LEVEL"));
               row.setSalary(rset.getDouble("SALARY"));
               row.setBonus(rset.getDouble("BONUS"));
               row.setManagerId(rset.getString("MANAGER_ID"));
               row.setHireDate(rset.getDate("HIRE_DATE"));
               row.setEntDate(rset.getDate("ENT_DATE"));
               row.setEntYn(rset.getString("ENT_YN"));

               empList.add(row);

           }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }finally {
    //7. 사용한 자원반납
          close(rset);
          close(stmt);
          close(con);

          for(EmployDTO emp : empList){
              System.out.println(emp);
          }

        }

    }
}
