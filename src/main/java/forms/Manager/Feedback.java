/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.Manager;

import static forms.Manager.frmManagerViewFeedback.tblViewFeedbackList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Teoh Will Shen
 */
public class Feedback implements Manager{

    public Feedback() {
    }
    
    @Override
    public void importFiletoTable() {
        File file = new File("D:\\Documents\\Uni_Modules\\Object Oriented Development with Java\\Group Assignment\\Group_9_APU_Cafeteria_Food_Ordering_System\\src\\main\\java\\Database\\feedback.txt");
        
        try{
            int feedbackID = 0;
            int paymentID = 0;
            int orderID = 0;
            int custID = 0;     
            String custName = "";
            String Ques1 = "";
            String Ques2 = "";
            String Ques3 = "";
        
            Scanner scan = new Scanner(file);
            scan.useDelimiter("[|\n]");
            
            DefaultTableModel model = (DefaultTableModel) tblViewFeedbackList.getModel();
            model.setRowCount(0);
            while(scan.hasNext()){
                feedbackID = Integer.parseInt(scan.next());
                paymentID = Integer.parseInt(scan.next());
                orderID = Integer.parseInt(scan.next());
                custID = Integer.parseInt(scan.next());     
                custName = scan.next();
                Ques1 = scan.next();
                Ques2 = scan.next();
                Ques3 = scan.next().trim();            
                model.addRow(new Object[] {feedbackID,custName,Ques1,Ques2,Ques3});
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(frmManagerViewFeedback.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void searchInformation(String searchText) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void saveInformation() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int generateID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
