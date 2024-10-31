package Task_1;
import javax.swing.*;

public class LoginFrame extends JFrame implements LoginView {
    private JTextField usernameField = new JTextField(20);
    private JPasswordField passwordField = new JPasswordField(20);
    private JButton loginButton = new JButton("Login");

    private LoginPresenter presenter;

    public LoginFrame() {
        presenter = new LoginPresenter(this);

        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);

        loginButton.addActionListener(e -> presenter.onLoginButtonClicked());

        add(panel);
    }

    @Override
    public void showLoginSuccess() {
        JOptionPane.showMessageDialog(this, "Login successful");
    }

    @Override
    public void showLoginError(String message) {
        JOptionPane.showMessageDialog(this, message, "Login Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public String getUsername() {
        return usernameField.getText();
    }

    @Override
    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);
        });
    }
}
