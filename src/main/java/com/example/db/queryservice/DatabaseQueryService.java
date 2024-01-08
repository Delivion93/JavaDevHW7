package com.example.db.queryservice;

import com.example.db.Database;
import com.example.dto.*;
import com.example.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public static final String LONGEST_PROJECT_PATH = "sql/find_longest_project.sql";
    public static final String MAX_PROJECT_CLIENTS_PATH = "sql/find_max_projects_client.sql";
    public static final String MAX_SALARY_WORKER_PATH = "sql/find_max_salary_worker.sql";
    public static final String YOUNGEST_ELDEST_PATH = "sql/find_youngest_eldest_workers.sql";
    public static final String PROJECT_PRICES_PATH = "sql/print_project_prices.sql";

    public static List<MaxProjectsClients> findMaxProjectClients(){
        List<MaxProjectsClients> list= new ArrayList<>();
        try (Statement statement = Database.getInstance().getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery(Util.fileToSQLQuery(MAX_PROJECT_CLIENTS_PATH));
            while (resultSet.next()){
                MaxProjectsClients maxProjectCountClient = new MaxProjectsClients();
                maxProjectCountClient.setName(resultSet.getString("NAME"));
                maxProjectCountClient.setProjectCount(resultSet.getInt("PROJECT_COUNT"));
                list.add(maxProjectCountClient);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public static List<LongestProject> findMLongestProject(){
        List<LongestProject> list= new ArrayList<>();
        try (Statement statement = Database.getInstance().getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery(Util.fileToSQLQuery(LONGEST_PROJECT_PATH));
            while (resultSet.next()){
                LongestProject longestProject = new LongestProject();
                longestProject.setName(resultSet.getString("NAME"));
                longestProject.setDurationInMonth(resultSet.getInt("DURATION_IN_MONTHS"));
                list.add(longestProject);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public static List<MaxSalaryWorker> findMaxSalaryWorker(){
        List<MaxSalaryWorker> list= new ArrayList<>();
        try (Statement statement = Database.getInstance().getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery(Util.fileToSQLQuery(MAX_SALARY_WORKER_PATH));
            while (resultSet.next()){
                MaxSalaryWorker maxSalaryWorker = new MaxSalaryWorker();
                maxSalaryWorker.setName(resultSet.getString("NAME"));
                maxSalaryWorker.setSalary(resultSet.getInt("SALARY"));
                list.add(maxSalaryWorker);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public static List<ProjectsPrices> findProjectsPrices(){
        List<ProjectsPrices> list= new ArrayList<>();
        try (Statement statement = Database.getInstance().getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery(Util.fileToSQLQuery(PROJECT_PRICES_PATH));
            while (resultSet.next()){
                ProjectsPrices projectsPrices = new ProjectsPrices();
                projectsPrices.setName(resultSet.getString("NAME"));
                projectsPrices.setPrice(resultSet.getInt("PRICE"));
                list.add(projectsPrices);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public static List<YoungestEldestWorker> findYoungestEldestWorker(){
        List<YoungestEldestWorker> list= new ArrayList<>();
        try (Statement statement = Database.getInstance().getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery(Util.fileToSQLQuery(YOUNGEST_ELDEST_PATH));
            while (resultSet.next()){
                YoungestEldestWorker youngestEldestWorker = new YoungestEldestWorker();
                youngestEldestWorker.setType(resultSet.getString("TYPE"));
                youngestEldestWorker.setName(resultSet.getString("NAME"));
                youngestEldestWorker.setBirthday(resultSet.getTimestamp("BIRTHDAY").toLocalDateTime().toLocalDate());
                list.add(youngestEldestWorker);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        findYoungestEldestWorker().forEach(System.out::println);
        findProjectsPrices().forEach(System.out::println);
        findMaxSalaryWorker().forEach(System.out::println);
        findMaxProjectClients().forEach(System.out::println);
        findMLongestProject().forEach(System.out::println);
    }
}
