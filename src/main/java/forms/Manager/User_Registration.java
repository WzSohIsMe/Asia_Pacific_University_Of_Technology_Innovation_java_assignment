/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.Manager;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Teoh Will Shen
 */
public class User_Registration implements Manager{
        private String username;
        private String password;
        private String con_password;
        private String user_role;
    
    public User_Registration(String name, String pass, String con_pass, String ur){
        this.username = name;
        this.password = pass;
        this.con_password = con_pass;
        this.user_role =ur;
    }
    
        @Override
    public void saveInformation(){
        int user_id = generateID();

        try
        {
            File f2 = new File("D:\\Documents\\Uni_Modules\\Object Oriented Development with Java\\Group Assignment\\Group_9_APU_Cafeteria_Food_Ordering_System\\src\\main\\java\\Database\\user.txt");     //registering account
            FileWriter fw = new FileWriter(f2,true);
            fw.write(user_id + "|" + username + "|" + password + "|" + user_role);
            fw.write(System.getProperty("line.separator"));
            fw.close();
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null, "Error"); 
        }
        JOptionPane.showMessageDialog(null, "Registration Successful");
    }

    @Override
    public int generateID() {
        int useridx=0;
        
        File categoryfile = new File("D:\\Documents\\Uni_Modules\\Object Oriented Development with Java\\Group Assignment\\Group_9_APU_Cafeteria_Food_Ordering_System\\src\\main\\java\\Database\\user.txt");

        try{
            Scanner scan = new Scanner(categoryfile);
            scan.useDelimiter("[|\n]");
            
            while(scan.hasNext()){
                
                useridx = Integer.parseInt(scan.next());
                String username = scan.next();
                String pass = scan.next();
                String userRole = scan.next().trim();
            }
        } catch (Exception ex) {
            Logger.getLogger(frmManagerUpdateMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        useridx = useridx + 1; // get the next category id in the text file
        return useridx;
    }

    @Override
    public void importFiletoTable() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void searchInformation(String searchText) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
