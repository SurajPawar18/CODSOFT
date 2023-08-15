import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentManagement extends JFrame {
    private ArrayList<Student> students;
    private JTextField nameField, rollNumberField, gradeField;
    private JTextArea displayArea;

    public StudentManagement() {
        students = new ArrayList<>();

        setTitle("Student Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel nameLabel = new JLabel("Name:");
        JLabel rollNumberLabel = new JLabel("Roll Number:");
        JLabel gradeLabel = new JLabel("Grade:");

        nameField = new JTextField(20);
        rollNumberField = new JTextField(10);
        gradeField = new JTextField(5);

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(rollNumberLabel);
        inputPanel.add(rollNumberField);
        inputPanel.add(gradeLabel);
        inputPanel.add(gradeField);

        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        JButton editButton = new JButton("Edit Student");
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editStudent();
            }
        });

        JButton searchButton = new JButton("Search Student");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchStudent();
            }
        });

        JButton displayButton = new JButton("Display Students");
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayStudents();
            }
        });

        JButton showAllButton = new JButton("Show All Students");
        showAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAllStudents();
            }
        });

        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(showAllButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void addStudent() {
        String name = nameField.getText();
        int rollNumber = Integer.parseInt(rollNumberField.getText());
        String grade = gradeField.getText();

        Student student = new Student(name, rollNumber, grade);
        students.add(student);

        clearFields();
    }

    private void editStudent() {
        int rollNumber = Integer.parseInt(rollNumberField.getText());
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                student.setName(nameField.getText());
                student.setGrade(gradeField.getText());
                break;
            }
        }

        clearFields();
    }

    private void searchStudent() {
        int rollNumber = Integer.parseInt(rollNumberField.getText());
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                nameField.setText(student.getName());
                gradeField.setText(student.getGrade());
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Student not found.");
    }

    private void displayStudents() {
        displayArea.setText("");
        for (Student student : students) {
            displayArea.append(student + "\n");
        }
    }

    private void showAllStudents() {
        displayArea.setText("");
        for (Student student : students) {
            displayArea.append(student + "\n");
        }
    }

    private void clearFields() {
        nameField.setText("");
        rollNumberField.setText("");
        gradeField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentManagement gui = new StudentManagement();
            gui.setVisible(true);
        });
    }

    private class Student {
        private String name;
        private int rollNumber;
        private String grade;

        public Student(String name, int rollNumber, String grade) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRollNumber() {
            return rollNumber;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
        }
    }
}
