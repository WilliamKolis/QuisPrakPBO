/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import Controller.Controller;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
/**
 *
 * @author William
 */
public class RegisterScreen extends JFrame implements ActionListener{
    JFrame registrasi;
    JLabel labelnama, labelemail,labelpassword,labeljudul;
    JTextField fieldnama, fieldemail;
    JPasswordField fieldpassword;
    JButton confirmbutton,resetbutton;
    
    public RegisterScreen(){
        registrasi = new JFrame("Registrasi");
        registrasi.setSize(400, 300);
        registrasi.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        registrasi.setLocationRelativeTo(null);
        
        labeljudul = new JLabel("Silahkan Insert Data Dibawah ");
        labeljudul.setBounds(100, 10, 200, 30);
                
        labelemail = new JLabel("Email");
        labelemail.setBounds(45, 50, 100, 30);
        
        fieldemail = new JTextField();
        fieldemail.setBounds(150, 50, 200, 30);
        
        labelnama = new JLabel("Nama");
        labelnama.setBounds(45, 100, 100, 30);
        
        fieldnama = new JTextField();
        fieldnama.setBounds(150, 100, 200, 30);
        
        labelpassword = new JLabel("Password");
        labelpassword.setBounds(45, 150, 100, 30);
        
        fieldpassword = new JPasswordField();
        fieldpassword.setBounds(150, 150, 200, 30);        
        
        confirmbutton = new JButton("Confirm");
        confirmbutton.setBounds(45,200,300,30);
        confirmbutton.addActionListener(this);
        
        resetbutton = new JButton("Back");
        resetbutton.setBounds(45,250,300,30);
        resetbutton.addActionListener(this);
        
        registrasi.add(labeljudul);
        registrasi.add(resetbutton);
        registrasi.add(confirmbutton);
        registrasi.add(fieldemail);
        registrasi.add(labelemail);
        registrasi.add(fieldnama);
        registrasi.add(labelnama);
        registrasi.add(labelpassword);
        registrasi.add(fieldpassword);
        registrasi.setLayout(null);
        registrasi.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
         String command = ae.getActionCommand();
        switch(command){
            case"Confirm":
                String email = fieldemail.getText();
                String nama =fieldnama.getText();
                String password = fieldpassword.getText();
                ArrayList<User> listuser = Controller.getAllemail();
                int cekemail = Controller.cekDuplikatKode(email);
                if(email.equals("") && password.equals("")){
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                } else if(cekemail > 0){
                    JOptionPane.showMessageDialog(null, "Kode Sudah Terpakai!!", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                } else {
                    if(Controller.registrasi(nama, email, password)){
                        JOptionPane.showMessageDialog(null, "Insert Berhasil!!");
                        registrasi.setVisible(false);
                        new MainMenu();
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Insert gagal!!");
                        break;
                    }
                }
                case"Back":
                registrasi.setVisible(false);
                new MainMenu();
                break;
            default:
                break;
        }
    }
    
}
