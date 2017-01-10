package com.jim.demo;

import java.sql.*;

/**
 * Created by qiaosj on 2017/1/10.
 */
public class MyApp {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("hello world");
        String url = "jdbc:sqlite:C:/Users/qiaosj/IdeaProjects/hello-sqlite/db/demo.db";

        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection(url);
        connection.setAutoCommit(true);
        Statement st = connection.createStatement();

        st.execute("create table person (name varchar(100),age int)");

        st.execute("insert into person values('steve',25)");

        ResultSet rs = st.executeQuery("select * from person");
        while (rs.next()) {
            System.out.println("----------");
            System.out.println(rs.getString("name"));
            System.out.println(rs.getInt("age"));
        }

    }
}
