/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.Manager;

import static forms.Manager.frmManagerUpdateMenuCategories.tblAvailableMenuCategory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Teoh Will Shen
 */
public class Category implements Manager{
    private String new_category;
    
    public Category(){
        
    }
    
    public Category(String nc){
        this.new_category = nc;
    }
    
    @Override
    public int generateID(){
        int categoryidx=0;
        
        File categoryfile = new File("D:\\Documents\\Uni_Modules\\Object Oriented Development with Java\\Group Assignment\\Group_9_APU_Cafeteria_Food_Ordering_System\\src\\main\\java\\Database\\category.txt");

        try{
            Scanner scan = new Scanner(categoryfile);
            scan.useDelimiter("[|\n]");
            
            while(scan.hasNext()){
                
                categoryidx = Integer.parseInt(scan.next());
                String categoryx = scan.next().trim();
            }
        } catch (Exception ex) {
            Logger.getLogger(frmManagerUpdateMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        categoryidx = categoryidx + 1; // get the next category id in the text file
        return categoryidx;
    }

    @Override
    public void saveInformation() {
        int category_id = generateID();
        
        try
            {
                File f2 = new File("D:\\Documents\\Uni_Modules\\Object Oriented Development with Java\\Group Assignment\\Group_9_APU_Cafeteria_Food_Ordering_System\\src\\main\\java\\Database\\category.txt");     //registering account
                FileWriter fw = new FileWriter(f2,true);
                fw.write(category_id + "|" + new_category);
                fw.write(System.getProperty("line.separator"));
                fw.close();
            }
            catch(Exception e)
            {
               JOptionPane.showMessageDialog(null, "Error"); 
            }
        JOptionPane.showMessageDialog(null, "Category Successfully added!");
    }

    @Override
    public void searchInformation(String searchText) {
        DefaultTableModel model = (DefaultTableModel)tblAvailableMenuCategory.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        
        tblAvailableMenuCategory.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(searchText));
    }

    @Override
    public void importFiletoTable() {
        File f1 = new File("D:\\Documents\\Uni_Modules\\Object Oriented Development with Java\\Group Assignment\\Group_9_APU_Cafeteria_Food_Ordering_System\\src\\main\\java\\Database\\category.txt");
            
        try {
            BufferedReader br = new BufferedReader(new FileReader(f1));

            DefaultTableModel model = (DefaultTableModel)tblAvailableMenuCategory.getModel();
            model.setRowCount(0);
            Object[] lines = br.lines().toArray();
            
            for(int i=0; i < lines.length; i++){
                String[] row = lines[i].toString().split(Pattern.quote("|"));
                model.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(frmManagerUpdateMenuCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
