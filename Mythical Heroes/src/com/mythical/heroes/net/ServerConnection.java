package com.mythical.heroes.net;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Andrei on 3/30/2016.
 */
public class ServerConnection {

    public static void main(String args[]) throws Exception {

        Connection connection;
        Statement statement;
        ResultSet resultSet;
        connection = DriverManager.getConnection("jdbc:mysql://192.168.0.104:3306/mythical_heroes", "newuser", "databasepassword74");
        statement = connection.createStatement();
        resultSet = statement.executeQuery("select * from tbl_account");
        while (resultSet.next())
            System.out.println(resultSet.getString("username"));
    }
}
