/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author William
 */
public class Controller {
    static DatabaseHandler conn = new DatabaseHandler();
    
    public static ArrayList<User> getAllemail() {
        ArrayList<User> user = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM user ";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                User usr = new User();
                usr.setEmail(rs.getString("Email"));
                usr.setPassword(rs.getString("Password"));
                user.add(usr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (user);           
    }
    public static boolean registrasi(String nama, String email, String password){
        conn.connect();
        String query = "INSERT INTO user VALUES (?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, nama);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.executeUpdate();
            return(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return(false);
    }
    
    public static int cekDuplikatKode(String email){
        conn.connect();
        int total = 0;
        String query = "SELECT Email FROM user WHERE Email = '" + email + "'";
        ArrayList<User> listusername = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                User usr = new User();
                usr.setEmail(rs.getString("Email"));
                listusername.add(usr);
            }
            total = listusername.size();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
}
