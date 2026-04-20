package emlpoyeemanagement;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.*;

public class ViewEmployees extends JFrame {
    
    public ViewEmployees() {
        setTitle("View Employees");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel(new String[] {"ID", "Name", "Age", "Position"}, 0);
        table.setModel(model);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        try {
            Connection con = DatabaseConnection.getConnection();
            String query = "SELECT * FROM employees";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                model.addRow(new Object[] {
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("position")
                });
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ViewEmployees().setVisible(true);
    }
}

