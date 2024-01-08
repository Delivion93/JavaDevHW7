package com.example.db.truncate;

import com.example.db.Database;
import com.example.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTruncateService {

    public static final String TRUNCATE_FILE_PATH="sql/truncate.sql";


    public static void main(String[] args) {
        try (Connection connection = Database.getInstance().getConnection();
             Statement statement = connection.createStatement()){
            statement.executeUpdate(Util.fileToSQLQuery(TRUNCATE_FILE_PATH));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
