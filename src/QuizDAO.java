import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuizDAO {
    public void addQuestion(String question, String option1, String option2, String option3, String option4, int correctOption) {
        String query = "INSERT INTO questions (question, option1, option2, option3, option4, correct_option) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, question);
            stmt.setString(2, option1);
            stmt.setString(3, option2);
            stmt.setString(4, option3);
            stmt.setString(5, option4);
            stmt.setInt(6, correctOption);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        String query = "SELECT * FROM questions";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Question question = new Question(
                        rs.getInt("id"),
                        rs.getString("question"),
                        rs.getString("option1"),
                        rs.getString("option2"),
                        rs.getString("option3"),
                        rs.getString("option4"),
                        rs.getInt("correct_option")
                );
                questions.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }
} 