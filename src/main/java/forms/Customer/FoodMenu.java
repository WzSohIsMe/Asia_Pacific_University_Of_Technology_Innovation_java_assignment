/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.Customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class FoodMenu implements Customer{
    private String UserID;
    private String Username;
    private String Password;
    private String Date;
    private String PaymentID;
    private String OrderID;
    private double firstclickTotalAmount;
    
    private String foodidx;
    private String foodcatx;
    private String foodnamex;
    private double foodpricex;
    private String fooddescx;
    
    private String type;
    
    public FoodMenu(){
    
    }
    
    /**
     *
     * @param t
     */
    public FoodMenu(String t){
        this.type = t;
    }

    public FoodMenu(String ID, String u, String p){
        UserID = ID;
        Username = u;
        Password = p;
    }

    public FoodMenu(String ID, String u, String p, String payID, String ordID){
        UserID = ID;
        Username = u;
        Password = p;
        PaymentID = payID;
        OrderID = ordID;
    }

    public FoodMenu(String ID, String u, String p, String d, String payID, String ordID){
        UserID = ID;
        Username = u;
        Password = p;
        Date = d;
        PaymentID = payID;
        OrderID = ordID;
    }
    
    public void getFoodMenu(String page){
        if(page.equals("FoodMenu")){
            File file = new File("D:\\Documents\\Uni_Modules\\Object Oriented Development with Java\\Group Assignment\\Group_9_APU_Cafeteria_Food_Ordering_System\\src\\main\\java\\Database\\food.txt");
            DefaultTableModel model = (DefaultTableModel) frmCustOrderingMenu.tblCart.getModel();
            model.setRowCount(0);
            try{

                Scanner scan = new Scanner(file);
                scan.useDelimiter("[|\n]");

                DefaultListModel foodmenu = new DefaultListModel();
                frmCustOrderingMenu.lstFoodMenu.setModel(foodmenu); 

                while(scan.hasNext()){
                    int foodidx = Integer.parseInt(scan.next());
                    String foodcatx = scan.next();
                    String foodnamex = scan.next();
                    double foodpricex = Double.parseDouble(scan.next());
                    String fooddescx = scan.next().trim();

                    foodmenu.addElement(foodnamex);
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(frmCustOrderingMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public int getID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void sendFeedback(int feedbackid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void pay(int paymentID, String order_id, String str_TotalAmount) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void getFoodCart() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void sendOrder(String order_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void getReceipt() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void viewTransactionHistory() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void viewRceipt() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
