import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SignUp extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JLabel userTypeLabel = new JLabel("USER TYPE");
    JRadioButton student = new JRadioButton("Student");
    JRadioButton teacher = new JRadioButton("Teacher");
    ButtonGroup buttonGroup = new ButtonGroup();
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton signUp = new JButton("SIGN UP");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");
    JLabel login = new JLabel("Login");

    SignUp() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(50, 50, 100, 30);
        passwordLabel.setBounds(50, 100, 100, 30);
        userTextField.setBounds(150, 50, 150, 30);
        passwordField.setBounds(150, 100, 150, 30);
        userTypeLabel.setBounds(50, 160, 100, 30);
        student.setBounds(150, 160, 80, 30);
        teacher.setBounds(230, 160, 80, 30);
        showPassword.setBounds(150, 130, 150, 30);
        signUp.setBounds(50, 230, 100, 30);
        resetButton.setBounds(200, 230, 100, 30);

        login.setBounds(150, 250, 80, 80);

        student.setActionCommand("Student");
        teacher.setActionCommand("Teacher");
    }

    public void addComponentsToContainer() {
        buttonGroup.add(student);
        buttonGroup.add(teacher);

        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(signUp);
        container.add(resetButton);
        container.add(userTypeLabel);
        container.add(student);
        container.add(teacher);

        container.add(login);
        login.setForeground(Color.BLUE);
    }

    public void addActionEvent() {
        signUp.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        login.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LoginFrame frame = new LoginFrame();
                frame.setTitle("Login Form");
                frame.setVisible(true);
                frame.setSize(350, 350);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                SignUp.this.setVisible(false);
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
        if (e.getSource() == signUp) {
            //SQLiteJDBC.insertDB();

            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            String type = buttonGroup.getSelection().getActionCommand();

            if (SQLiteJDBC.insertDB(userText, pwdText, type)) {
                JOptionPane.showMessageDialog(this, "Account registered successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Account registration Failed!");
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