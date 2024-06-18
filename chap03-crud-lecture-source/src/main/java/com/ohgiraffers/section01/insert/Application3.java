package com.ohgiraffers.section01.insert;

import com.ohgiraffers.model.MenuDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application3 {

    public static void main(String[] args){

        Connection con = getConnection();
        PreparedStatement pstmt =  null;

        /*
        * insert,update,delete는 성공한행의 갯수를 반환해준다 > 정수형태
        * 0은 아무런 변화가 없을때
        *
        * */
        int result =0;

        //쿼리문이 저장된 xml파일을 읽어올 properties객체
        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-query.xml"));

            String query = prop.getProperty("insertMenu");

            pstmt = con.prepareStatement(query);

            Scanner sc = new Scanner(System.in);
            System.out.println("메뉴의 이름을 입력하세요");
            String menuName = sc.nextLine();

            System.out.println("가격을 입력하세요");
            int menuPrice = sc.nextInt();

            System.out.println("카테고리코드를 입력하세요");
            int categoryCode = sc.nextInt();

            System.out.println("판매여부를 입력하세요");
            sc.nextLine();
            String orderableStatus = sc.nextLine().toUpperCase();

            MenuDTO newMenu = new MenuDTO();
            newMenu.setMenuName(menuName);
            newMenu.setMenuPrice(menuPrice);
            newMenu.setCategoryCode(categoryCode);
            newMenu.setOrderablestatus(orderableStatus);

            pstmt.setString(1,newMenu.getMenuName());
            pstmt.setInt(2,newMenu.getMenuPrice());
            pstmt.setInt(3,newMenu.getCategoryCode());
            pstmt.setString(4,newMenu.getOrderablestatus());

            result = pstmt.executeUpdate();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
            close(con);
        }
       if(result >0){
           System.out.println("메뉴 저장 성공");
       }else {
           System.out.println("메뉴 저장 실패");
       }

    }
}
