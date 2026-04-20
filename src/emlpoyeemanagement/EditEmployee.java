package emlpoyeemanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EditEmployee extends JFrame {
    private JTextField idField, nameField, ageField, positionField;
    private JButton updateButton;

    public EditEmployee() {
        setTitle("Edit Employee");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel idLabel = new JLabel("Employee ID:");
        idField = new JTextField();
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField();
        JLabel positionLabel = new JLabel("Position:");
        positionField = new JTextField();
        updateButton = new JButton("Update");

        panel.add(idLabel);
        panel.add(idField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(positionLabel);
        panel.add(positionField);
        panel.add(new JLabel());
        panel.add(updateButton);

        add(panel);

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    updateEmployee();
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void updateEmployee() throws SQLException, ClassNotFoundException {
        int employeeId = Integer.parseInt(idField.getText());
        Connection con = DatabaseConnection.getConnection();
        String query = "UPDATE employees SET name = ?, age = ?, position = ? WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, nameField.getText());
        stmt.setInt(2, Integer.parseInt(ageField.getText()));
        stmt.setString(3, positionField.getText());
        stmt.setInt(4, employeeId);

        int result = stmt.executeUpdate();
        if (result > 0) {
            JOptionPane.showMessageDialog(this, "Employee updated successfully!");
            dispose();  // Close the Edit Employee window
        } else {
            JOptionPane.showMessageDialog(this, "Employee not found.");
        }
    }

    public static void main(String[] args) {
        new EditEmployee().setVisible(true);
    }
}

