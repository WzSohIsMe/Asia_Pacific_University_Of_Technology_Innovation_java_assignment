/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.Manager;

import static forms.Manager.frmManagerViewLogActivity.tblLogActivity;
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
public class Log_Activity implements Manager{

    public Log_Activity(){
        
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
        File file = new File("D:\\Documents\\Uni_Modules\\Object Oriented Development with Java\\Group Assignment\\Group_9_APU_Cafeteria_Food_Ordering_System\\logs\\Logs.log");
        
        try{
            String level = ""; 
            String date = "";
            String time = "";
            String eventQueue = "";
            String activity = "";
        
            Scanner scan = new Scanner(file);
            scan.useDelimiter("[|\n]");
            
            DefaultTableModel model = (DefaultTableModel) tblLogActivity.getModel();
            model.setRowCount(0);
            while(scan.hasNext()){
                level = scan.next();
                date = scan.next();
                time = scan.next();
                eventQueue = scan.next();
                activity = scan.next().trim();
         
                model.addRow(new Object[] {level,date,time,activity});
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(frmManagerViewLogActivity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void searchInformation(String searchText) {
        DefaultTableModel model = (DefaultTableModel)tblLogActivity.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        
        tblLogActivity.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(searchText));
    }
}
