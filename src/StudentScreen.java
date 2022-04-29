import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StudentScreen extends JFrame implements ActionListener {
    static String value;

    public static void main(String[] args) {
        StudentScreen frame = new StudentScreen();
        frame.setTitle("MainScreen");
        frame.setVisible(true);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    Container container = getContentPane();
    JLabel userLabel1 = new JLabel("USERNAME");
    JLabel userLabel2 = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JLabel loginTimeLabel1 = new JLabel("Login Time");
    JLabel loginTimeLabel2 = new JLabel("Login Time");
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JButton logoutButton = new JButton("LOGOUT");
    JCheckBox showPassword = new JCheckBox("Show Password");
    JLabel signUp = new JLabel("Sign Up");
    JTable jt = new JTable();
    JComboBox jComboBox = new JComboBox();


    StudentScreen() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel1.setBounds(20, 20, 100, 30);
        userLabel2.setBounds(120, 20, 100, 30);
        //passwordLabel.setBounds(50, 150, 100, 30);
        loginTimeLabel1.setBounds(350, 20, 100, 30);
        loginTimeLabel2.setBounds(450, 20, 100, 30);
        showPassword.setBounds(150, 180, 150, 30);
        loginButton.setBounds(50, 230, 100, 30);
        resetButton.setBounds(200, 230, 100, 30);

        logoutButton.setBounds(500, 0, 100, 25);

        signUp.setBounds(150, 250, 80, 80);

        String data[][] = {{"Sr. No", "Spanish", "English"}, {"1", "Hola!", "(Hello)"},
                {"2", "¿Como estas?", "(How are you?)"},
                {"3", "¿Como te va?", "(How's it going?)"},
                {"4", "¿Que tal?", "(What's up?)"},
                {"5", "¿Que pasa?", "(What's happening?)"}
        };
        String column[] = {"Sr. No", "Spanish", "English"};
        jt = new JTable(data, column);

        // set a Background color to the Jtable
        jt.setBackground(Color.decode("#058dc7"));

        // set Font To table
        jt.setFont(new Font("", 1, 12));

        // set height to the table rows
        jt.setRowHeight(30);

        // set color to the JTable Font
        jt.setForeground(Color.white);

        jt.setBounds(100, 100, 400, 200);

        jComboBox.setBounds(400, 50, 100, 30);
    }

    public void addComponentsToContainer() {
        container.add(userLabel1);
        container.add(userLabel2);
        container.add(passwordLabel);
        container.add(loginTimeLabel1);
        container.add(loginTimeLabel2);
        //container.add(showPassword);
        //container.add(loginButton);
        //container.add(resetButton);
        //container.add(signUp);
        logoutButton.setBackground(Color.RED);
        logoutButton.setForeground(Color.WHITE);
        container.add(logoutButton);
        container.add(jt);
        container.add(jComboBox);

        ArrayList<String> teacherList = new ArrayList<>();

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:LangWay.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE userType like '%Teacher%'");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("userName");
                teacherList.add(name);

            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        for (String name : teacherList) {
            jComboBox.addItem(name);
        }

        signUp.setForeground(Color.BLUE);
        userLabel2.setForeground(Color.BLUE);
        loginTimeLabel2.setForeground(Color.BLUE);

        userLabel2.setText(LoginFrame.userText);

        c = null;
        stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:LangWay.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE userName like '%" + LoginFrame.userText + "%'");
            while (rs.next()) {
                int id = rs.getInt("id");
                //name = rs.getString("userName");
                //pwd = rs.getString("passWord");
                String type = rs.getString("userType");
                String date_added = rs.getString("date_added");
                String[] strings = date_added.split(" ");
                loginTimeLabel2.setText(strings[1]);
                //System.out.println("ID : " + id);
                //System.out.println("Name : " + name);
                //System.out.println("Message : " + pwd);
                //System.out.println("Date Added : " + date_added);
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        logoutButton.addActionListener(this);
        signUp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SignUp frame = new SignUp();
                frame.setTitle("Login Form");
                frame.setVisible(true);
                frame.setSize(350, 350);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                StudentScreen.this.setVisible(false);
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

        jComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                value = (String) jComboBox.getSelectedItem();
                TeacherScreen frame = new TeacherScreen();
                frame.setTitle("TeacherScreen");
                frame.setVisible(true);
                frame.setSize(600, 400);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                StudentScreen.this.setVisible(false);
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = "";// userTextField.getText();
            pwdText = "";//passwordField.getText();


            if (SQLiteJDBC.selectDB(userText, pwdText)) {
                JOptionPane.showMessageDialog(this, "Login Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        }

        if (e.getSource() == resetButton) {
            //userTextField.setText("");
            //passwordField.setText("");
        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                // passwordField.setEchoChar((char) 0);
            } else {
                // passwordField.setEchoChar('*');
            }
        }

        if (e.getSource() == logoutButton) {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            //String time = sdf.toString().split("\\s")[1].split("\\.")[0];
            JOptionPane.showMessageDialog(this, "LoginTime: " + loginTimeLabel2.getText() + "\nLogout Time: " + sdf.format(date));
            this.setVisible(false);
            LoginFrame frame = new LoginFrame();
            frame.setTitle("Login Form");
            frame.setVisible(true);
            frame.setSize(350, 350);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
        }
    }
}