package emlpoyeemanagement;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class LoginPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    public LoginPage() {
        setTitle("Login Page");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        JLabel usernameLabel = new JLabel("Username: ");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password: ");
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);
        add(panel);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (authenticate(usernameField.getText(), new String(passwordField.getPassword()))) {
                        JOptionPane.showMessageDialog(null, "Login Successful!");
                        dispose();
                        new MainMenu().setVisible(true);  // Open Main Menu
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    private boolean authenticate(String username, String password) throws SQLException, ClassNotFoundException {
        Connection con = DatabaseConnection.getConnection();
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        return rs.next();
    } 
    public static void main(String[] args) {
        new LoginPage().setVisible(true);
    }
}
