package com.jsg.examples.utils.存储过程;

import java.sql.*;

public class DBUtil {
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String URL = "jdbc:oracle:thin:@localhost:1521/orcl";
    public static final String USERNAME = "HIS";
    public static final String PASSWORD = "1";

    /**
     * 通过静态代码块 注册数据库驱动
     */
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得Connection
     *
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 获得Statement
     *
     * @return
     */
    public static Statement getStatement() {
        Statement st = null;
        try {
            st = getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }

    /**
     * 关闭ResultSet
     *
     * @param rs
     */
    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭Statement
     *
     * @param st
     */
    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭Connection
     *
     * @param conn
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭全部
     *
     * @param rs
     * @param sta
     * @param conn
     */
    public static void closeAll(ResultSet rs, Statement sta, Connection conn) {
        closeResultSet(rs);
        closeStatement(sta);
        closeConnection(conn);
    }

}

