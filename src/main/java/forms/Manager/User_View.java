/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.Manager;

import static forms.Manager.frmManagerViewUser.tblUserList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Teoh Will Shen
 */
public class User_View implements Manager{

    public User_View(){
        
    }
    
    @Override
    public void saveInformation() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int generateID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void importFiletoTable() {
        File file = new File("D:\\Documents\\Uni_Modules\\Object Oriented Development with Java\\Group Assignment\\Group_9_APU_Cafeteria_Food_Ordering_System\\src\\main\\java\\Database\\user.txt");
        
        try{
            int userID = 0; 
            String userName = "";
            String userPass = "";
            String userRole = "";
        
            Scanner scan = new Scanner(file);
            scan.useDelimiter("[|\n]");
            
            DefaultTableModel model = (DefaultTableModel) tblUserList.getModel();
            model.setRowCount(0);
            while(scan.hasNext()){
                userID = Integer.parseInt(scan.next());
                userName = scan.next();
                userPass = scan.next();
                userRole = scan.next().trim();
         
                model.addRow(new Object[] {userID,userName,userRole});
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(frmManagerViewUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void searchInformation(String searchText) {
        DefaultTableModel model = (DefaultTableModel)tblUserList.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        
        tblUserList.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(searchText));
    }
}
