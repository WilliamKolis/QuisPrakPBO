/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author William
 */
public class LoginScreen extends JFrame{
    JFrame login;
    JLabel labelnama, labelemail,labelpassword,labeljudul;
    JTextField fieldnama, fieldemail;
    JPasswordField fieldpassword;
    JButton confirmbutton,resetbutton;
    
    public LoginScreen(){
        login = new JFrame("Login");
        login.setSize(400, 300);
        login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        login.setLocationRelativeTo(null);
    }
}