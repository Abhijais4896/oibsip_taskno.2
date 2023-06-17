import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGuessingGame {
    private JFrame frame;
    private JLabel guessLabel;
    private JTextField guessTextField;
    private JButton submitButton;
    private JLabel resultLabel;
    private int randomNumber;

    public NumberGuessingGame() {
        // Create the main frame
        frame = new JFrame("Number Guessing Game");

        // Generate a random number between 1 and 100
        randomNumber = (int) (Math.random() * 100) + 1;

        // Create the components
        guessLabel = new JLabel("Enter your guess (1-100):");
        guessTextField = new JTextField(10);
        submitButton = new JButton("Submit");
        resultLabel = new JLabel("");

        // Set up the layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(guessLabel);
        panel.add(guessTextField);
        panel.add(submitButton);
        panel.add(resultLabel);

        // Add action listener to the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int guess = Integer.parseInt(guessTextField.getText());

                // Compare the guess with the random number
                if (guess == randomNumber) {
                    resultLabel.setText("Congratulations! You guessed it right!");
                    submitButton.setEnabled(false); // Disable the submit button
                } else if (guess < randomNumber) {
                    resultLabel.setText("Too low! Try again.");
                } else {
                    resultLabel.setText("Too high! Try again.");
                }
            }
        });

        // Set up the main frame
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NumberGuessingGame();
            }
        });
    }
}
