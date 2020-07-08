package com.my01;

import java.sql.*;

/**
 * @Auther wu
 * @Date 2019/7/22  21:11
 */
public class Code_01_Kylin {
    private static String driver = "org.apache.kylin.jdbc.Driver";
    private static String url = "jdbc:kylin://hadoop102:7070/FirstProject";
    private static String uname = "ADMIN";
    private static String pwd = "KYLIN";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName(driver);
        Connection ct = DriverManager.getConnection(url, uname, pwd);
        PreparedStatement ps = ct.prepareStatement
                ("SELECT sum(sal) AS SUM_SAL FROM emp group by deptno");
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("SUM_SAL"));
        }
    }
}
