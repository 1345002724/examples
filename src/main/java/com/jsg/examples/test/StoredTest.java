package com.jsg.examples.test;

import oracle.jdbc.OracleTypes;

import java.sql.*;

/**
 * 测试调用存储过程
 *
 */
public class StoredTest {
    public static void main(String[] args) {
        insert_call();
       // select_call();
    }

    /**
     * 执行存储过程 插入数据
     */
    public static void insert_call() {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pst = null;

        CallableStatement proc = null; // 创建执行存储过程的对象
        try {
            proc = conn.prepareCall("{ call P_gyb_gettest01(?,?) }");

            proc.setString(1, "张三"); // 设置第一个输入参数
            proc.setString(2, "李四"); // 设置第一个输入参数
            proc.execute();// 执行

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭IO流
                proc.close();
                DBUtil.closeAll(null, pst, conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 执行存储过程 查询数据
     */
    public static void select_call() {
        Connection conn = DBUtil.getConnection();

        CallableStatement stmt;
        try {
            stmt = conn.prepareCall("{ call P_gyb_getryxx(?, ?) }"); // 用此调用方法不能实现多行语法
            stmt.setString(1, "00001"); //设置第一个输入参数
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            ResultSet rs = (ResultSet) stmt.getObject(2);
            while (rs.next()) {
                System.out.println(rs.getString("ryxm"));
                System.out.println(rs.getString("rybm"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
    }
}

