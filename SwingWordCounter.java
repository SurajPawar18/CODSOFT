import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingWordCounter extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JButton countButton;

    public SwingWordCounter() {
        setTitle("Word Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        textArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);
        countButton = new JButton("Count Words");
        countButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(countButton, BorderLayout.SOUTH);

        add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countButton) {
            String inputText = textArea.getText();// isse hme text area ka text milenga
            String[] words = inputText.split("[\\s\\p{Punct}]+"); // isse extra impurity remove kr sakte hai
            int wordCount = words.length;// isse length find out krenge

            JOptionPane.showMessageDialog(this, "Total words: " + wordCount);
        }
    }

    public static void main(String[] args) {
        SwingWordCounter frm = new SwingWordCounter();
        frm.setVisible(true);
    }
}

