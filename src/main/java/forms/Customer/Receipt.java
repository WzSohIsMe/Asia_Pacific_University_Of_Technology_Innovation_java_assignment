/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.Customer;

import static forms.Customer.frmCustReceipt.lblDatetime;
import static forms.Customer.frmCustReceipt.tblReceipt;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Receipt implements Customer{
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
    private String STR_TotalAmount;
    
    private String type;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public Receipt(){
    
    }
    
    /**
     *
     * @param t
     */
    public Receipt(String t){
        this.type = t;
    }

    public Receipt(String ID, String u, String p){
        UserID = ID;
        Username = u;
        Password = p;
    }

    public Receipt(String ID, String u, String p, String d){
        UserID = ID;
        Username = u;
        Password = p;
        Date = d;
    }

    public Receipt(String ID, String u, String p, String payID, String ordID){
        UserID = ID;
        Username = u;
        Password = p;
        PaymentID = payID;
        OrderID = ordID;
    }

    public Receipt(String ID, String u, String p, String d, String payID, String ordID){
        UserID = ID;
        Username = u;
        Password = p;
        Date = d;
        PaymentID = payID;
        OrderID = ordID;
    }

    @Override
    public int getID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void getFoodMenu(String page) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void sendFeedback(int feedbackid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void pay(int paymentID, String order_id, String totalamount) {
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
        DefaultTableModel model = (DefaultTableModel) frmCustReceipt.tblReceipt.getModel();
        model.setRowCount(0);
        
        frmCustReceipt.lblDatetime.setText(Date);
        
        String filePath = "D:\\Documents\\Uni_Modules\\Object Oriented Development with Java\\Group Assignment\\Group_9_APU_Cafeteria_Food_Ordering_System\\src\\main\\java\\Database\\cart.txt";
        File file = new File(filePath);
        
        double TotalAmount = 0;
        double sum = 0;
        
        try{
            
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            Object [] lines = br.lines().toArray();
            
            for(int i=0;i<lines.length;i++){
                String[] row = lines[i].toString().split(Pattern.quote("|"));
                model.addRow(row);
            }
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmCustReceipt.class.getName()).log(Level.SEVERE, null, ex);
        }
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

