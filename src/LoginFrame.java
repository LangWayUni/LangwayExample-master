import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginFrame extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");
    JLabel signUp = new JLabel("Sign Up");
    static String userText;
    static String pwdText;


    LoginFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

        SQLiteJDBC.createDB();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(50, 100, 100, 30);
        passwordLabel.setBounds(50, 150, 100, 30);
        userTextField.setBounds(150, 100, 150, 30);
        passwordField.setBounds(150, 150, 150, 30);
        showPassword.setBounds(150, 180, 150, 30);
        loginButton.setBounds(50, 230, 100, 30);
        resetButton.setBounds(200, 230, 100, 30);

        signUp.setBounds(150, 250, 80, 80);


    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(signUp);
        signUp.setForeground(Color.BLUE);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        signUp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SignUp frame = new SignUp();
                frame.setTitle("SignUp Form");
                frame.setVisible(true);
                frame.setSize(350, 350);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                LoginFrame.this.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            userText = userTextField.getText();
            pwdText = passwordField.getText();

            if (userText.equalsIgnoreCase("admin") && pwdText.equalsIgnoreCase("admin")) {
                AdminScreen frame = new AdminScreen();
                frame.setTitle("AdminScreen");
                frame.setVisible(true);
                frame.setSize(600, 400);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                this.setVisible(false);
                this.dispose();

                return;
            }

            if (userText.length() == 0 || pwdText.length() == 0)
                return;


            if (SQLiteJDBC.selectDB(userText, pwdText)) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                StudentScreen frame = new StudentScreen();
                frame.setTitle("MainScreen");
                frame.setVisible(true);
                frame.setSize(600, 400);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                this.setVisible(false);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        }

        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }
    }
}    