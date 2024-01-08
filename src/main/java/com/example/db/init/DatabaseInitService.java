package com.example.db.init;

import com.example.db.Database;
import com.example.util.Util;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static final String INIT_FILE_PATH="sql/init_db.sql";


    public static void main(String[] args) {
        try (Connection connection = Database.getInstance().getConnection();
             Statement statement = connection.createStatement()
        ){
            statement.executeUpdate(Util.fileToSQLQuery(INIT_FILE_PATH));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
