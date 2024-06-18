package com.ohgiraffers.section02.preparedstatement;

import com.ohgiraffers.model.dto.DepartmentDTO;
import com.ohgiraffers.model.dto.EmployDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application4 {
    public static void main(String[] args) {

        /*department 테이블의 부서코드(아이디)를 입력받아서
        * 부서코드(아이디), 부서명, 지역코드를 출력하시오*/

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("입력하세요");
        String dept_id = sc.nextLine();


        //쿼리문
        String query = "select dept_id,dept_title,location_id from department where dept_id =? ";
        DepartmentDTO selectedEmp = null;

        try {
            pstmt = con.prepareStatement(query);  //상위 쿼리문
            pstmt.setString(1, dept_id);  // ?에 들어갈거


            rset = pstmt.executeQuery();

            if(rset.next()){

                selectedEmp = new DepartmentDTO();

                selectedEmp.setDept_id(rset.getString("DEPT_ID"));
                selectedEmp.setDept_title(rset.getString("DEPT_TITLE"));
                selectedEmp.setLocation_id(rset.getString("LOCATION_ID"));


            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(pstmt);
            close(con);

        }


    }

}
