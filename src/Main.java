import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Launch the quiz application using SwingUtilities to ensure
        // GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new QuizUI();
        });
    }
} 