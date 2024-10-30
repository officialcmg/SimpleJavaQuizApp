import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class QuizUI extends JFrame {
    private QuizDAO quizDAO;

    public QuizUI() {
        quizDAO = new QuizDAO();

        // Setting up the frame
        setTitle("Quiz App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Main Panel with Buttons
        JPanel mainPanel = new JPanel();
        JButton addQuestionButton = new JButton("Add Question");
        JButton startQuizButton = new JButton("Start Quiz");

        mainPanel.add(addQuestionButton);
        mainPanel.add(startQuizButton);
        add(mainPanel, BorderLayout.CENTER);

        // Action Listeners for Buttons
        addQuestionButton.addActionListener((ActionEvent e) -> showAddQuestionDialog());
        startQuizButton.addActionListener((ActionEvent e) -> startQuiz());

        setVisible(true);
    }

    private void showAddQuestionDialog() {
        JTextField questionField = new JTextField(20);
        JTextField option1Field = new JTextField(15);
        JTextField option2Field = new JTextField(15);
        JTextField option3Field = new JTextField(15);
        JTextField option4Field = new JTextField(15);
        JTextField correctOptionField = new JTextField(5);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
        panel.add(new JLabel("Question:"));
        panel.add(questionField);
        panel.add(new JLabel("Option 1:"));
        panel.add(option1Field);
        panel.add(new JLabel("Option 2:"));
        panel.add(option2Field);
        panel.add(new JLabel("Option 3:"));
        panel.add(option3Field);
        panel.add(new JLabel("Option 4:"));
        panel.add(option4Field);
        panel.add(new JLabel("Correct Option (1-4):"));
        panel.add(correctOptionField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Add Question", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String question = questionField.getText();
            String option1 = option1Field.getText();
            String option2 = option2Field.getText();
            String option3 = option3Field.getText();
            String option4 = option4Field.getText();
            int correctOption = Integer.parseInt(correctOptionField.getText());

            quizDAO.addQuestion(question, option1, option2, option3, option4, correctOption);
            JOptionPane.showMessageDialog(this, "Question added!");
        }
    }

    private void startQuiz() {
        List<Question> questions = quizDAO.getQuestions();
        int score = 0;

        for (Question question : questions) {
            String[] options = {question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4()};
            int answer = JOptionPane.showOptionDialog(this, question.getQuestion(), "Quiz",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if (answer + 1 == question.getCorrectOption()) {
                score++;
            }
        }

        JOptionPane.showMessageDialog(this, "Quiz completed! Your score: " + score + "/" + questions.size());
    }
} 