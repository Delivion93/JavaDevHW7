INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES
  ('John Doe', '1990-01-15', 'Trainee', 800),
  ('Jane Smith', '1985-05-20', 'Junior', 1200),
  ('Bob Johnson', '1982-11-08', 'Middle', 2500),
  ('Alice Brown', '1995-03-02', 'Senior', 7000),
  ('Charlie White', '1988-07-10', 'Trainee', 700),
  ('Eva Green', '1992-09-18', 'Junior', 1500),
  ('David Lee', '1980-12-25', 'Middle', 3000),
  ('Sophia Chen', '1998-04-30', 'Senior', 7000),
  ('Mike Wang', '1993-06-12', 'Trainee', 900),
  ('Olivia Kim', '1987-08-05', 'Junior', 1800);

INSERT INTO client (NAME)
VALUES
  ('John Smith'),
  ('Alice Johnson'),
  ('Bob Davis'),
  ('Emily Brown'),
  ('Daniel Wilson');

INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE)
VALUES
  (1, '2022-01-01', '2023-02-28'),
  (1, '2022-03-15', '2022-12-31'),
  (2, '2022-06-01', '2022-07-15'),
  (1, '2022-08-20', '2023-08-20'),
  (2, '2023-01-10', '2023-02-28'),
  (3, '2023-03-01', '2023-06-30'),
  (4, '2023-05-15', '2024-05-15'),
  (2, '2024-01-01', '2024-04-30'),
  (5, '2022-01-01', '2023-02-28'),
  (5, '2024-09-01', '2025-01-31');

  INSERT INTO project_worker (PROJECT_ID, WORKER_ID)
VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (2, 3),
    (2, 4),
    (2, 5),
    (3, 5),
    (3, 6),
    (4, 6),
    (4, 7),
    (4, 8),
    (5, 8),
    (5, 9),
    (6, 9),
    (6, 10),
    (7, 1),
    (7, 2),
    (8, 2),
    (8, 3),
    (8, 4),
    (9, 4),
    (9, 5),
    (10, 5),
    (10, 6);
