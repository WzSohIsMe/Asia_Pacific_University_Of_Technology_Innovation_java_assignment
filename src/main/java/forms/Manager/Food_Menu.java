/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.Manager;

import static forms.Manager.frmManagerUpdateMenu.tblMenuList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Teoh Will Shen
 */
public class Food_Menu implements Manager{
    private String item_name;
    private String item_category;
    private String item_price;
    private String item_desc;
    
    public Food_Menu(){
        
    }
    
    public Food_Menu(String n, String c, String p, String d){
        this.item_name = n;
        this.item_category = c;
        this.item_price = p;
        this.item_desc = d;
    }
    
    @Override
    public void saveInformation() {
        int item_id = generateID();

        try{
            File f2 = new File("D:\\Documents\\Uni_Modules\\Object Oriented Development with Java\\Group Assignment\\Group_9_APU_Cafeteria_Food_Ordering_System\\src\\main\\java\\Database\\food.txt");     //registering account
            FileWriter fw = new FileWriter(f2,true);
            fw.write(item_id + "|" + item_category + "|" + item_name + "|" + item_price + "|" + item_desc);
            fw.write(System.getProperty("line.separator"));
            fw.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error"); 
        }
    }

    @Override
    public int generateID(){
        int itemid=0;
        
        File Foodfile = new File("D:\\Documents\\Uni_Modules\\Object Oriented Development with Java\\Group Assignment\\Group_9_APU_Cafeteria_Food_Ordering_System\\src\\main\\java\\Database\\food.txt");

        try{
            Scanner scan = new Scanner(Foodfile);
            scan.useDelimiter("[|\n]");
            
            while(scan.hasNext()){
                itemid = Integer.parseInt(scan.next());
                String itemCat = scan.next();
                String itemName = scan.next();
                double itemPrice = Double.parseDouble(scan.next());
                String itemDesc = scan.next().trim();
            }
        } catch (Exception ex) {
            Logger.getLogger(frmManagerUpdateMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        itemid = itemid + 1; // get the next category id in the text file
        return itemid;
    }

    @Override
    public void searchInformation(String searchText) {
        DefaultTableModel model = (DefaultTableModel)tblMenuList.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        
        tblMenuList.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(searchText));
    }

    @Override
    public void importFiletoTable() {
        File file = new File("D:\\Documents\\Uni_Modules\\Object Oriented Development with Java\\Group Assignment\\Group_9_APU_Cafeteria_Food_Ordering_System\\src\\main\\java\\Database\\food.txt");
        
        try{
            int foodID = 0;
            double foodPrice = 0;        
            String foodName = "";
            String foodCat = "";
            String foodDesc = "";
        
            Scanner scan = new Scanner(file);
            scan.useDelimiter("[|\n]");
            
            DefaultTableModel model = (DefaultTableModel) tblMenuList.getModel();
            model.setRowCount(0);
            while(scan.hasNext()){
                foodID = Integer.parseInt(scan.next());
                foodCat = scan.next();
                foodName = scan.next();
                foodPrice = Double.parseDouble(scan.next());
                foodDesc = scan.next().trim();               
            
                model.addRow(new Object[] {foodID,foodCat,foodName,foodPrice,foodDesc});
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(frmManagerUpdateMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}
