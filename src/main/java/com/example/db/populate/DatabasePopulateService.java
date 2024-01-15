package com.example.db.populate;

import com.example.db.Database;
import com.example.dto.Client;
import com.example.dto.Project;
import com.example.dto.ProjectWorker;
import com.example.dto.Worker;
import com.example.enums.CareerLevel;
import com.example.util.Util;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabasePopulateService {

    private static final String WORKERS_INSERT_QUERY = "INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES (?, ?, ?, ?)";
    private static final String CLIENT_INSERT_QUERY = "INSERT INTO client (NAME) VALUES (?)";
    private static final String PROJECT_INSERT_QUERY = "INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE) VALUES (?,?,?)";
    private static final String PROJECT_WORKER_INSERT_QUERY = "INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (?,?)";

    private static PreparedStatement preparedStatement;
    public static void insertNewWorker(List<Worker>workers){
        try {
            preparedStatement=Database.getInstance().getConnection().prepareStatement(WORKERS_INSERT_QUERY);
            for (Worker worker : workers) {

                    preparedStatement.setString(1,worker.getName());
                    preparedStatement.setDate(2, Date.valueOf(worker.getDateOfBirth()));
                    preparedStatement.setString(3,worker.getLevel().getDescription());
                    preparedStatement.setInt(4,worker.getSalary());
                    preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
    public static void insertNewClient(List<Client>clients){
        try {
            preparedStatement=Database.getInstance().getConnection().prepareStatement(CLIENT_INSERT_QUERY);
            for (Client client : clients) {

                preparedStatement.setString(1,client.getName());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
    public static void insertNewProject(List<Project>projects) {
        try {
            preparedStatement = Database.getInstance().getConnection().prepareStatement(PROJECT_INSERT_QUERY);
            for (Project project : projects) {

                preparedStatement.setInt(1, project.getClientId());
                preparedStatement.setDate(2, Date.valueOf(project.getStartDate()));
                preparedStatement.setDate(3, Date.valueOf(project.getFinishDate()));
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertNewProjectWorker(List<ProjectWorker>projectsWorkers){
        try {
            preparedStatement=Database.getInstance().getConnection().prepareStatement(PROJECT_WORKER_INSERT_QUERY);
            for (ProjectWorker projectWorker : projectsWorkers) {

                preparedStatement.setInt(1,projectWorker.getProjectId());
                preparedStatement.setInt(2,projectWorker.getWorkerId());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        List<Worker> workers = new ArrayList<>();
        workers.add(new Worker("John Doe", LocalDate.of(1990, 1, 15), CareerLevel.TRAINEE, 800));
        workers.add(new Worker("Jane Smith", LocalDate.of(1985, 5, 20), CareerLevel.JUNIOR, 1200));
        workers.add(new Worker("Bob Johnson", LocalDate.of(1982, 11, 8), CareerLevel.MIDDLE, 2500));
        workers.add(new Worker("Alice Brown", LocalDate.of(1995, 3, 2), CareerLevel.SENIOR, 7000));
        workers.add(new Worker("Charlie White", LocalDate.of(1988, 7, 10), CareerLevel.TRAINEE, 700));
        workers.add(new Worker("Eva Green", LocalDate.of(1992, 9, 18), CareerLevel.JUNIOR, 1500));
        workers.add(new Worker("David Lee", LocalDate.of(1980, 12, 25), CareerLevel.MIDDLE, 3000));
        workers.add(new Worker("Sophia Chen", LocalDate.of(1998, 4, 30), CareerLevel.SENIOR, 7000));
        workers.add(new Worker("Mike Wang", LocalDate.of(1993, 6, 12), CareerLevel.TRAINEE, 900));
        workers.add(new Worker("Olivia Kim", LocalDate.of(1987, 8, 5), CareerLevel.JUNIOR, 1800));

        insertNewWorker(workers);

        List<Client> clients = new ArrayList<>();
        clients.add(new Client("John Smith"));
        clients.add(new Client("Alice Johnson"));
        clients.add(new Client("Bob Davis"));
        clients.add(new Client("Emily Brown"));
        clients.add(new Client("Daniel Wilson"));

        insertNewClient(clients);

        List<Project> projects = new ArrayList<>();
        projects.add(new Project(1, LocalDate.of(2022, 1, 1), LocalDate.of(2023, 2, 28)));
        projects.add(new Project(1, LocalDate.of(2022, 3, 15), LocalDate.of(2022, 12, 31)));
        projects.add(new Project(2, LocalDate.of(2022, 6, 1), LocalDate.of(2022, 7, 15)));
        projects.add(new Project(1, LocalDate.of(2022, 8, 20), LocalDate.of(2023, 8, 20)));
        projects.add(new Project(2, LocalDate.of(2023, 1, 10), LocalDate.of(2023, 2, 28)));
        projects.add(new Project(3, LocalDate.of(2023, 3, 1), LocalDate.of(2023, 6, 30)));
        projects.add(new Project(4, LocalDate.of(2023, 5, 15), LocalDate.of(2024, 5, 15)));
        projects.add(new Project(2, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 4, 30)));
        projects.add(new Project(5, LocalDate.of(2022, 1, 1), LocalDate.of(2023, 2, 28)));
        projects.add(new Project(5, LocalDate.of(2024, 9, 1), LocalDate.of(2025, 1, 31)));

        insertNewProject(projects);

        List<ProjectWorker> projectWorkers = new ArrayList<>();
        projectWorkers.add(new ProjectWorker(1, 1));
        projectWorkers.add(new ProjectWorker(1, 2));
        projectWorkers.add(new ProjectWorker(1, 3));
        projectWorkers.add(new ProjectWorker(2, 3));
        projectWorkers.add(new ProjectWorker(2, 4));
        projectWorkers.add(new ProjectWorker(2, 5));
        projectWorkers.add(new ProjectWorker(3, 5));
        projectWorkers.add(new ProjectWorker(3, 6));
        projectWorkers.add(new ProjectWorker(4, 6));
        projectWorkers.add(new ProjectWorker(4, 7));
        projectWorkers.add(new ProjectWorker(4, 8));
        projectWorkers.add(new ProjectWorker(5, 8));
        projectWorkers.add(new ProjectWorker(5, 9));
        projectWorkers.add(new ProjectWorker(6, 9));
        projectWorkers.add(new ProjectWorker(6, 10));
        projectWorkers.add(new ProjectWorker(7, 1));
        projectWorkers.add(new ProjectWorker(7, 2));
        projectWorkers.add(new ProjectWorker(8, 2));
        projectWorkers.add(new ProjectWorker(8, 3));
        projectWorkers.add(new ProjectWorker(8, 4));
        projectWorkers.add(new ProjectWorker(9, 4));
        projectWorkers.add(new ProjectWorker(9, 5));
        projectWorkers.add(new ProjectWorker(10, 5));
        projectWorkers.add(new ProjectWorker(10, 6));

        insertNewProjectWorker(projectWorkers);

    }
}
