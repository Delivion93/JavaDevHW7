package com.example.db.populate;

import com.example.db.Database;
import com.example.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {

    public static final String POPULATE_FILE_PATH="sql/populate_db.sql";


    public static void main(String[] args) {
        try (Connection connection = Database.getInstance().getConnection();
             Statement statement = connection.createStatement()
        ){
            statement.executeUpdate(Util.fileToSQLQuery(POPULATE_FILE_PATH));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
