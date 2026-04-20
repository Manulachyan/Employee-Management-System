package emlpoyeemanagement;

import javax.swing.*;
import java.awt.event.*;

public class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("Employee Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        JButton addButton = new JButton("Add Employee");
        JButton deleteButton = new JButton("Delete Employee");
        JButton editButton = new JButton("Edit Employee");
        JButton viewButton = new JButton("View Employees");

        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(editButton);
        panel.add(viewButton);
        
        add(panel);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddEmployee().setVisible(true);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DeleteEmployee().setVisible(true);
            }
        });

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new EditEmployee().setVisible(true);
            }
        });

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ViewEmployees().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new MainMenu().setVisible(true);
    }
}


