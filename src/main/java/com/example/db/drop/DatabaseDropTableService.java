package com.example.db.drop;

import com.example.db.Database;
import com.example.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseDropTableService {

    public static final String DROP_TABLE_FILE_PATH="sql/drop.sql";


    public static void main(String[] args) {
        try (Connection connection = Database.getInstance().getConnection();
             Statement statement = connection.createStatement()){
            statement.executeUpdate(Util.fileToSQLQuery(DROP_TABLE_FILE_PATH));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
