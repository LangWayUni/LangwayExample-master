/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import java.awt.Button;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.AWTEvent;
import javax.swing.ImageIcon;




public class Register extends javax.swing.JFrame {

    
    public Register() {
        

        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupRadioButton = new javax.swing.ButtonGroup();
        panel_register = new javax.swing.JPanel();
        label_Create_info = new java.awt.Label();
        Btn_register = new java.awt.Button();
        try {
            Label_Logo =(javax.swing.JLabel)java.beans.Beans.instantiate(getClass().getClassLoader(), "Register_Label_Logo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        btn_Student = new javax.swing.JRadioButton();
        btn_Teacher = new javax.swing.JRadioButton();
        txt_UIsername = new javax.swing.JTextField();
        Password_Username = new javax.swing.JPasswordField();
        Btn_register1 = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusTraversalPolicyProvider(true);
        setForeground(new java.awt.Color(255, 255, 255));
        setName("DisplayJframe"); // NOI18N
        setUndecorated(true);
        setSize(new java.awt.Dimension(320, 527));

        panel_register.setBackground(new java.awt.Color(255, 255, 255));
        panel_register.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel_register.setMaximumSize(new java.awt.Dimension(320, 527));
        panel_register.setPreferredSize(new java.awt.Dimension(320, 527));

        label_Create_info.setBackground(new java.awt.Color(255, 255, 255));
        label_Create_info.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        label_Create_info.setText("Create a New Account");

        Btn_register.setBackground(new java.awt.Color(30, 152, 215));
        Btn_register.setForeground(new java.awt.Color(242, 242, 242));
        Btn_register.setLabel("Register");
        Btn_register.setName("Register_btn"); // NOI18N
        Btn_register.setPreferredSize(new java.awt.Dimension(60, 25));
        Btn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_registerActionPerformed(evt);
            }
        });

        buttonGroupRadioButton.add(btn_Student);
        btn_Student.setText("Student");

        buttonGroupRadioButton.add(btn_Teacher);
        btn_Teacher.setText("Teacher");

        txt_UIsername.setText("Username");

        Password_Username.setText("Password");
        Password_Username.setPreferredSize(new java.awt.Dimension(60, 22));

        Btn_register1.setActionCommand("Login page");
        Btn_register1.setBackground(new java.awt.Color(30, 152, 215));
        Btn_register1.setForeground(new java.awt.Color(242, 242, 242));
        Btn_register1.setLabel("Login Page");
        Btn_register1.setName("Login_btn"); // NOI18N
        Btn_register1.setPreferredSize(new java.awt.Dimension(60, 25));
        Btn_register1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_register1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_registerLayout = new javax.swing.GroupLayout(panel_register);
        panel_register.setLayout(panel_registerLayout);
        panel_registerLayout.setHorizontalGroup(
            panel_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_registerLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(Btn_register, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(Btn_register1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
            .addGroup(panel_registerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btn_Teacher, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_Student, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_UIsername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                        .addComponent(Password_Username, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Label_Logo)
                    .addComponent(label_Create_info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_registerLayout.setVerticalGroup(
            panel_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_registerLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(Label_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_Create_info, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(txt_UIsername, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Password_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Student)
                .addGap(18, 18, 18)
                .addComponent(btn_Teacher)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Btn_register1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_register, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(131, 131, 131))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_register, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panel_register, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel_register.getAccessibleContext().setAccessibleParent(panel_register);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_registerActionPerformed

        this.dispose();
        new Register_Accepted().setVisible(true); // Main Form to show after the Login Form..
  

    }//GEN-LAST:event_Btn_registerActionPerformed

    private void Btn_register1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_register1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_register1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
            
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Register().setVisible(true);
            
          //  var image = new ImageIcon(Register.class.getResource("C:\\Users\\ou-la\\Pictures\\Logo.png"));
            }
            
                      

        });
    }

    static void DisplayJframe()
    {
      
        
        JFrame jframe = new JFrame("JFrame Background Color");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
           jframe.getContentPane().setBackground(Color.cyan);
    } 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button Btn_register;
    private java.awt.Button Btn_register1;
    private javax.swing.JLabel Label_Logo;
    private javax.swing.JPasswordField Password_Username;
    private javax.swing.JRadioButton btn_Student;
    private javax.swing.JRadioButton btn_Teacher;
    private javax.swing.ButtonGroup buttonGroupRadioButton;
    private java.awt.Label label_Create_info;
    private javax.swing.JPanel panel_register;
    private javax.swing.JTextField txt_UIsername;
    // End of variables declaration//GEN-END:variables
}

