package com.deliverygogo.JDBC1.dao;

import com.deliverygogo.JDBC1.Exception.*;
import com.deliverygogo.JDBC1.common.Common;
import com.deliverygogo.JDBC1.vo.CustomerVO;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CustomerDAO {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pStmt = null;
    ResultSet rs = null;

    //이용자 로그인
    public boolean isC(String USER_ID, String USER_PW) {
        boolean isCustomer = false;
        try {
            conn = Common.getConnection();
            String sql = "SELECT COUNT(*) FROM CUSTOMER_INFO WHERE USER_ID = ? AND USER_PW = ?";
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, USER_ID);
            pStmt.setString(2, USER_PW);
            rs = pStmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    isCustomer = true;
                }
            }
            Common.close(rs);
            Common.close(pStmt);
            Common.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isCustomer;
    }


    public void cuslogin(CustomerVO customerVO) {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        String sql = "INSERT INTO CUSTOMER_INFO(USER_ID,USER_PW) VALUES(?,?)";

        try {
            conn = Common.getConnection();
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, customerVO.getUSER_ID());
            pStmt.setString(2, customerVO.getUSER_PW());
            int ret = pStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(stmt);
        Common.close(conn);
        System.out.println("\u001B[92m" + "회원가입이 성공적으로 완료되었습니다!" + "\u001B[0m");
    }


    public static void customerInsert(CustomerVO customerVO) throws Exception {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
            String sql = "INSERT INTO CUSTOMER_INFO(USER_ID,USER_PW,USER_NAME,GENDER,PHONE,ADDR,BIRTH,EMAIL,MONTHFEE) VALUES(?,?,?,?,?,?,?,?,?)";

            try {
                conn = Common.getConnection();
                pStmt = conn.prepareStatement(sql);
                pStmt.setString(1, customerVO.getUSER_ID());
                pStmt.setString(2, customerVO.getUSER_PW());
                pStmt.setString(3, customerVO.getUSER_NAME());
                pStmt.setString(4, customerVO.getGENDER());
                pStmt.setString(5, customerVO.getPHONE());
                pStmt.setString(6, customerVO.getADDR());
                pStmt.setString(7, customerVO.getBIRTH());
                pStmt.setString(8, customerVO.getEMAIL());
                pStmt.setString(9, customerVO.getMONTHFEE());
                int ret = pStmt.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Common.close(stmt);
            Common.close(conn);
            System.out.println("\u001B[92m" + "회원가입이 성공적으로 완료되었습니다!" + "\u001B[0m");

    }

    // 회원정보 수정
    public static void customerUpdate() {
        Connection conn = null;
        PreparedStatement pStmt = null;
        Scanner sc = new Scanner(System.in);

        System.out.print("비밀번호를 변경할 회원의 아이디를 입력하세요 : ");
        String USER_ID = sc.next();
        System.out.print("변경할 회원의 비밀번호를 입력하세요 : ");
        String USER_PW = sc.next();

        String sql = "UPDATE CUSTOMER_INFO SET USER_PW = ? WHERE USER_ID = ?";

        try {
            conn = Common.getConnection();
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, USER_PW);
            pStmt.setString(2, USER_ID);
            pStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(pStmt);
        Common.close(conn);
    }




    // 회원 탈퇴
    public static void customerDelete() {
        Connection conn = null;
        PreparedStatement pStmt = null;
        Scanner sc = new Scanner(System.in);

        System.out.print("삭제할 회원의 아이디를 입력 하세요 : ");
        String USER_ID = sc.next();
        String sql = "DELETE FROM CUSTOMER_INFO WHERE USER_ID = ?";
        try {
            conn = Common.getConnection();
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, USER_ID);
            pStmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(pStmt);
        Common.close(conn);
    }

    private static boolean validateEmail(String email) {
        return email.contains("@");
    }

    private static boolean validateAddr(String addr) {
        String[] parts = addr.split(" ");
        int idx = 0;
        for (String part : parts) {
            idx++;
            if (idx == 1) {
                if (part.charAt(part.length() - 1) != '시') {
                    System.out.println("시 가 없습니다");
                    return false;
                }
            } else if (idx == 2) {
                if (part.charAt(part.length() - 1) != '구') {
                    System.out.println("구 가 없습니다");
                    return false;
                }
            } else if (idx == 3) {
                if (part.charAt(part.length() - 1) != '동') {
                    System.out.println("동 이 없습니다");
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean validateDate(java.util.Date date) {
        java.util.Date currentDate= new Date();
        if (date.compareTo(currentDate) > 0) {
            return false;
        }
        return true;
    }

    private static String insertPhoneNumberhyphen(String PHONE) {
        return PHONE.substring(0, 3) + "-" + PHONE.substring(3, 7) + "-" + PHONE.substring(7);
    }
    private static boolean validateOptionNumber(String GENDER) {
        return Objects.equals(GENDER, "1") || Objects.equals(GENDER, "2");
    }

    private static void validatePwString(String c_pw, int x) {
        if (c_pw.length() >= x) {
            throw new IllegalPasswordException("비밀번호가 너무 깁니다.");
        }
        if (!isContainNumber(c_pw)) {
            throw new IllegalPasswordException("숫자가 포함되지 않았습니다.");
        }
        if (!isContainAlpha(c_pw)) {
            throw new IllegalPasswordException("영어가 포함되지 않았습니다.");
        }
        if (!isContainSpecialChar(c_pw)) {
            throw new IllegalPasswordException("특수문자가 포함되지 않았습니다.");
        }
    }

    private static boolean isContainAlpha(String c_pw) {
        for (char c : c_pw.toCharArray()) {
            if ('A' <= c && c <= 'Z' || 'a' <= c && c <= 'z'){
                return true;
            }
        }
        return false;
    }

    private static boolean isContainNumber(String c_pw) {
        String numbers = "0123456789";

        for (char c : c_pw.toCharArray()) {
            if (numbers.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }
    private static boolean isContainSpecialChar(String c_pw) {
        String specialChars = "@#$%^&+=!";

        for (char c : c_pw.toCharArray()) {
            if (specialChars.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }

    private static boolean validateLength(String input, int length) {
        if (input.length() > length) {
            return false;
        }
        return true;
    }

    private static boolean isCustomer(String username) {
        List<String> userList = new ArrayList<>();
        userList.add("");
        userList.add("");
        userList.add("");
        return userList.contains(username);
    }




}
