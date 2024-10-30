```markdown
# Java Quiz Application

A desktop quiz application built with Java Swing and MySQL, allowing users to create and take multiple-choice quizzes.

## Features

- **Question Management:** Add new quiz questions with four answer options and mark the correct one.
- **Interactive Quiz:** Take quizzes and receive scores at the end.
- **Persistent Storage:** All questions are stored in a MySQL database for easy access.
- **User-Friendly GUI:** Simple, intuitive interface built with Java Swing.

## Prerequisites

- **Java JDK**: Version 8 or higher
- **MySQL Server**: Version 8.0 or higher
- **MySQL Connector/J**: Version 8.0.33

## Database Setup

1. **Start the MySQL Server** and log in.
2. **Create the Database and Table** by running:

    ```sql
    CREATE DATABASE QuizDB;
    USE QuizDB;

    CREATE TABLE questions (
        id INT AUTO_INCREMENT PRIMARY KEY,
        question VARCHAR(255) NOT NULL,
        option1 VARCHAR(255) NOT NULL,
        option2 VARCHAR(255) NOT NULL,
        option3 VARCHAR(255) NOT NULL,
        option4 VARCHAR(255) NOT NULL,
        correct_option INT NOT NULL
    );
    ```

## Configuration

Update your MySQL credentials in `src/DBConnection.java`:

```java
// In DBConnection.java
String url = "jdbc:mysql://localhost:3306/QuizDB";
String user = "your_username";
String password = "your_password";
```

## Installation & Running

### Windows

1. **Create the Project Structure:**
    ```bash
    mkdir quiz-app
    cd quiz-app
    mkdir src lib
    ```
2. **Move Source Files:** Place all `.java` files in the `src` directory.
3. **Add MySQL Connector:** Download MySQL Connector/J (`mysql-connector-java-8.0.33.jar`) and put it in the `lib` directory.
4. **Compile:**
    ```bash
    javac -cp ".;lib/mysql-connector-java-8.0.33.jar" src/*.java
    ```
5. **Run:**
    ```bash
    java -cp ".;lib/mysql-connector-java-8.0.33.jar;src" Main
    ```

### Linux/MacOS

1. **Create the Project Structure:**
    ```bash
    mkdir quiz-app
    cd quiz-app
    mkdir src lib
    ```
2. **Move Source Files:** Place all `.java` files in the `src` directory.
3. **Add MySQL Connector:** Download MySQL Connector/J (`mysql-connector-java-8.0.33.jar`) and put it in the `lib` directory.
4. **Compile:**
    ```bash
    javac -cp ".:lib/mysql-connector-java-8.0.33.jar" src/*.java
    ```
5. **Run:**
    ```bash
    java -cp ".:lib/mysql-connector-java-8.0.33.jar:src" Main
    ```

## Usage

### Adding Questions

1. Click **"Add Question"** in the application.
2. Fill in:
   - Question text
   - Four answer options
   - Correct option number (1-4)
3. Click **OK** to save.

### Taking the Quiz

1. Click **"Start Quiz"** in the application.
2. Select an answer for each question.
3. At the end, view your final score.

## Project Structure

- **`Main.java`**: Launches the application and initializes GUI.
- **`QuizUI.java`**: Contains the main GUI for managing and taking quizzes.
- **`QuizDAO.java`**: Manages database operations for adding and retrieving questions.
- **`Question.java`**: Defines the Question model.
- **`DBConnection.java`**: Manages the MySQL connection.

## Troubleshooting

- **Database Connection Issues**: Verify MySQL is running, check credentials, and ensure MySQL Connector is in the `lib` directory.
- **Compilation Errors**: Verify Java installation, file locations, and classpath syntax.
- **Runtime Errors**: Check database permissions and GUI initialization.
```