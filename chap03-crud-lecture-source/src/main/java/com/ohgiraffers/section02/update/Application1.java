package com.ohgiraffers.section02.update;
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

public class Application1 {
    public static void main(String[] args) {

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        int result =0;
        Properties prop = new Properties();
        Scanner sc = new Scanner(System.in);
        System.out.println("변경할 메뉴번호를 입력하세요 :");
        int menuCode = sc.nextInt();

        System.out.println("변경할 메뉴이름를 입력하세요 :");
        String menuName = sc.nextLine();
        sc.nextLine();

        System.out.println("변경할 메뉴가격를 입력하세요 :");
        int menuPrice = sc.nextInt();

        MenuDTO changedMenu = new MenuDTO();
        changedMenu.setMenuCode(menuCode);
        changedMenu.setMenuName(menuName);
        changedMenu.setMenuPrice(menuPrice);

//        ------------------------------------------

        //쿼리가져오기

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-query.xml"));

          String query = prop.getProperty("updateMenu");
          pstmt = con.prepareStatement(query);
          pstmt.setInt(1,changedMenu.getMenuCode());
          pstmt.setString(2,changedMenu.getMenuName());
          pstmt.setInt(3,changedMenu.getMenuPrice());

          result = pstmt.executeUpdate();

        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
            close(con);
        }

        if(result > 0){
            System.out.println("메뉴변경성공");
        }else {
            System.out.println("메뉴변경실패");
        }

    }

}
