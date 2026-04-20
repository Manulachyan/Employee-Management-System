package emlpoyeemanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AddEmployee extends JFrame {
    private JTextField nameField, ageField, positionField;
    private JButton saveButton;

    public AddEmployee() {
        setTitle("Add Employee");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField();
        JLabel positionLabel = new JLabel("Position:");
        positionField = new JTextField();
        saveButton = new JButton("Save");

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(positionLabel);
        panel.add(positionField);
        panel.add(new JLabel());
        panel.add(saveButton);

        add(panel);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    addEmployee();
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void addEmployee() throws SQLException, ClassNotFoundException {
        Connection con = DatabaseConnection.getConnection();
        String query = "INSERT INTO employees (name, age, position) VALUES (?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, nameField.getText());
        stmt.setInt(2, Integer.parseInt(ageField.getText()));
        stmt.setString(3, positionField.getText());

        int result = stmt.executeUpdate();
        if (result > 0) {
            JOptionPane.showMessageDialog(this, "Employee added successfully!");
            dispose();  // Close the Add Employee window
        } else {
            JOptionPane.showMessageDialog(this, "Error adding employee.");
        }
    }

    public static void main(String[] args) {
        new AddEmployee().setVisible(true);
    }
}


