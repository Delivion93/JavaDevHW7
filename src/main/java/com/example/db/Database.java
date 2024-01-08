package com.example.db;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private static final String DB_URL = "jdbc:h2:~/test";
    private static final String USER_NAME = "sa";
    private static final String PASSWORD = "";
    private static Database instance;
    private static Connection connection;

    private Database(){

    }
    public static Database getInstance(){
        if(instance ==null){
            instance = new Database();
            return instance;
        }
        return instance;
    }

    @SneakyThrows
    public Connection getConnection() {
        if(connection==null){
            connection= DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
            return connection;
        }
        return connection;
    }
}
