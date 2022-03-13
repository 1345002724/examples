package com.jsg.examples.utils.JDBC;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DBhelper {

        public static void conn() {
            String URL = "jdbc:mysql://localhost:3306/examples?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
            String USER = "root";
            String PASSWORD = "1";
            List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
            // 1.加载驱动程序
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                // 2.获得数据库链接
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                // 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
                String name = "张三";
                //预编译
                String sql = "select * from gyb_user";
                PreparedStatement statement = conn.prepareStatement(sql);
             //   statement.setString(1, name);
                ResultSet rs = statement.executeQuery();
                // 4.处理数据库的返回结果(使用ResultSet类)
                ResultSetMetaData md = rs.getMetaData(); //获得结果集结构信息,元数据
                int columnCount = md.getColumnCount();   //获得列数
                while (rs.next()) {
                    Map<String,Object> rowData = new HashMap<String,Object>();

                    for(int i = 1;i<=columnCount;i++){
                        rowData.put(md.getColumnName(i), rs.getObject(i));
                    }
                    list.add(rowData);
                    System.out.println(list.toString());
                }

                // 关闭资源【多谢指正】
                rs.close();
                statement.close();
                conn.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    public static void main(String[] args) {
        conn();
    }
    }



