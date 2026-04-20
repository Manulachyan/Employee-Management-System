package emlpoyeemanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteEmployee extends JFrame {
    private JTextField idField;
    private JButton deleteButton;

    public DeleteEmployee() {
        setTitle("Delete Employee");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JLabel idLabel = new JLabel("Employee ID:");
        idField = new JTextField();
        deleteButton = new JButton("Delete");

        panel.add(idLabel);
        panel.add(idField);
        panel.add(new JLabel());
        panel.add(deleteButton);

        add(panel);

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    deleteEmployee();
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void deleteEmployee() throws SQLException, ClassNotFoundException {
        int employeeId = Integer.parseInt(idField.getText());
        Connection con = DatabaseConnection.getConnection();
        String query = "DELETE FROM employees WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1, employeeId);

        int result = stmt.executeUpdate();
        if (result > 0) {
            JOptionPane.showMessageDialog(this, "Employee deleted successfully!");
            dispose();  // Close the Delete Employee window
        } else {
            JOptionPane.showMessageDialog(this, "Employee not found.");
        }
    }

    public static void main(String[] args) {
        new DeleteEmployee().setVisible(true);
    }
}

