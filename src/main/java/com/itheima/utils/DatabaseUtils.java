package com.itheima.utils;

import java.sql.*;

public class DatabaseUtils {



    /**
     * 连接oracle
     */
    public static Connection dbConn(String name, String pass) {
        Connection c = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String url = "jdbc:oracle:thin:@192.168.26.128:1521:ORCL";
            c = DriverManager.getConnection(url, name, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = dbConn("scott", "tiger");
        String sql = "select * from  emp";
        String sql1 = "select e1.empno,e1.ename,e1.sal ,e3.avgsal\n" +
                        "from emp e1,(select deptno,avg(sal) avgsal from emp group by deptno) e3\n" +
                         "where e1.deptno=e3.deptno and e1.sal>e3.avgsal";
        PreparedStatement preparedStatement = connection.prepareStatement(sql1);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1));
        }

    }
}
