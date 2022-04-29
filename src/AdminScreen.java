import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AdminScreen extends JFrame implements ActionListener {
    static String value;
    ArrayList<String> teacherList = new ArrayList<>();
    ArrayList<String> studentList = new ArrayList<>();

    public static void main(String[] args) {
        AdminScreen frame = new AdminScreen();
        frame.setTitle("AdminScreen");
        frame.setVisible(true);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    Container container = getContentPane();
    JLabel label = new JLabel("ADMIN PANEL");
    JButton logoutButton = new JButton("LOGOUT");
    JButton studentBtn = new JButton("Get Students List");
    JButton teacherBtn = new JButton("Get Teachers List");
    JTable jt = new JTable();


    AdminScreen() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {

        label.setBounds(200, 50, 200, 50);
        label.setFont(new Font("Serif", Font.BOLD, 20));
        studentBtn.setBounds(150, 100, 150, 30);
        teacherBtn.setBounds(300, 100, 150, 30);
        logoutButton.setBounds(500, 0, 100, 25);

        jt.setBounds(100, 150, 400, 200);


    }

    public void addComponentsToContainer() {
        container.add(label);
        container.add(studentBtn);
        container.add(teacherBtn);
        logoutButton.setBackground(Color.RED);
        logoutButton.setForeground(Color.WHITE);
        container.add(logoutButton);
        container.add(jt);

    }

    public void addActionEvent() {
        studentBtn.addActionListener(this);
        teacherBtn.addActionListener(this);
        logoutButton.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == studentBtn) {
            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:LangWay.db");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE userType like '%Student%'");
                while (rs.next()) {
                    //int id = rs.getInt("id");
                    String name = rs.getString("userName");
                    String time = rs.getString("date_added");
                    studentList.add(name + "," + time);

                }
                rs.close();
                stmt.close();
                c.close();
            } catch (Exception ex) {
                System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
                System.exit(0);
            }

            String data[][] = new String[studentList.size()][2];

            for (int i = 0; i < studentList.size(); i++) {
                for (int j = 0; j < 2; j++) {
                    String[] strings = studentList.get(i).split(",");
                    data[i][j] = strings[j];
                    //  System.out.println(data[i][j]);
                }
            }

            String column[] = {"Name", "Account Created"};
            DefaultTableModel defaultTableModel = new DefaultTableModel(data, column);
            jt = new JTable(defaultTableModel);

            System.out.println(data.length + "");

            // set a Background color to the Jtable
            jt.setBackground(Color.decode("#058dc7"));

            // set Font To table
            jt.setFont(new Font("", 1, 12));

            // set height to the table rows
            jt.setRowHeight(30);

            // set color to the JTable Font
            jt.setForeground(Color.white);

            jt.setBounds(100, 150, 400, 200);

            container.add(jt);
            container.revalidate();

        }

        if (e.getSource() == teacherBtn) {
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
                    //int id = rs.getInt("id");
                    String name = rs.getString("userName");
                    String time = rs.getString("date_added");
                    teacherList.add(name + "," + time);

                }
                rs.close();
                stmt.close();
                c.close();
            } catch (Exception ex) {
                System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
                System.exit(0);
            }

            String data[][] = new String[teacherList.size()][2];

            for (int i = 0; i < teacherList.size(); i++) {
                for (int j = 0; j < 2; j++) {
                    String[] strings = teacherList.get(i).split(",");
                    data[i][j] = strings[j];
                }
            }

            String[] column = {"Name", "Account Created"};
            DefaultTableModel defaultTableModel = new DefaultTableModel(data, column);
            jt = new JTable(data, column);
            System.out.println(data.length + "");

            // set a Background color to the Jtable
            jt.setBackground(Color.decode("#058dc7"));

            // set Font To table
            jt.setFont(new Font("", 1, 12));

            // set height to the table rows
            jt.setRowHeight(30);

            // set color to the JTable Font
            jt.setForeground(Color.white);

            jt.setBounds(100, 150, 400, 200);
            container.add(jt);
            container.revalidate();
        }

        if (e.getSource() == logoutButton) {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            //String time = sdf.toString().split("\\s")[1].split("\\.")[0];
            //JOptionPane.showMessageDialog(this, "LoginTime: " + loginTimeLabel2.getText() + "\nLogout Time: " + sdf.format(date));
            this.setVisible(false);
            LoginFrame frame = new LoginFrame();
            frame.setTitle("Login Form");
            frame.setVisible(true);
            frame.setSize(350, 350);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            AdminScreen.this.setVisible(false);
        }
    }
}