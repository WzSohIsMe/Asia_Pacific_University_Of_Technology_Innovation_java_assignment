/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.Customer;

import static forms.Customer.frmCustTransactionRecord.tblTransactionRecord;
import static forms.Customer.frmCustViewReceipt.lblDatetime;
import static forms.Customer.frmCustViewReceipt.tblReceipt;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class TransactionHistory implements Customer{
    private String UserID;
    private String Username;
    private String Password;
    private String UserRole;
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
    public TransactionHistory(){
    
    }
    
    /**
     *
     * @param t
     */
    public TransactionHistory(String t){
        this.type = t;
    }

    public TransactionHistory(String ID, String u, String p){
        UserID = ID;
        Username = u;
        Password = p;
    }
    
    public TransactionHistory(String ID, String u, String p, String r){
        UserID = ID;
        Username = u;
        Password = p;
        UserRole = r;
    }

    public TransactionHistory(String ID, String u, String p, String r, String d){
        UserID = ID;
        Username = u;
        Password = p;
        UserRole = r;
        Date = d;
    }

    public TransactionHistory(String ID, String u, String p, String r, String payID, String ordID){
        UserID = ID;
        Username = u;
        Password = p;
        UserRole = r;
        PaymentID = payID;
        OrderID = ordID;
    }

    public TransactionHistory(String ID, String u, String p, String r, String d, String payID, String ordID){
        UserID = ID;
        Username = u;
        Password = p;
        UserRole = r;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void viewTransactionHistory() {
        DefaultTableModel model = (DefaultTableModel) frmCustTransactionRecord.tblTransactionRecord.getModel();
        
        if(frmCustTransactionRecord.tblTransactionRecord.getSelectedRow()!=-1){
            int rowcount = frmCustTransactionRecord.tblTransactionRecord.getSelectedRow();
        
            String paymentid = frmCustTransactionRecord.tblTransactionRecord.getValueAt(rowcount, 0).toString();
            PaymentID = paymentid;
            String orderid = frmCustTransactionRecord.tblTransactionRecord.getValueAt(rowcount, 1).toString();
            OrderID = orderid;
            String date = frmCustTransactionRecord.tblTransactionRecord.getValueAt(rowcount, 3).toString();
            Date = date;

            System.out.println("Selected PaymentID: "+PaymentID);
            System.out.println("Selected OrderID: "+OrderID);
            System.out.println("Selected Date: "+Date);
            frmCustViewReceipt recp = new frmCustViewReceipt(UserID,Username,Password,UserRole,Date,PaymentID,OrderID);
            recp.setVisible(true);
            
        }else{
            JOptionPane.showMessageDialog(null, "Please Select A Payment To View Receipt!","View Receipt Error",JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    public String getFoodID(String fname){
        File file = new File("D:\\Documents\\Uni_Modules\\Object Oriented Development with Java\\Group Assignment\\Group_9_APU_Cafeteria_Food_Ordering_System\\src\\main\\java\\Database\\food.txt");
        
        try{
            Scanner scan = new Scanner(file);
            scan.useDelimiter("[|\n]");
            
            while(scan.hasNext()){
                String foodidx = scan.next();
                String foodcatx = scan.next();
                String foodnamex = scan.next();
                String foodpricex = scan.next();
                String fooddescx = scan.next().trim();
                
                if(foodnamex.equals(fname)){
                    return foodidx;
                }else{
                    
                }
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(frmCustViewReceipt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String getFoodPrice(String fname){
        File file = new File("D:\\Documents\\Uni_Modules\\Object Oriented Development with Java\\Group Assignment\\Group_9_APU_Cafeteria_Food_Ordering_System\\src\\main\\java\\Database\\food.txt");
        
        try{
            Scanner scan = new Scanner(file);
            scan.useDelimiter("[|\n]");
            
            while(scan.hasNext()){
                String foodidx = scan.next();
                String foodcatx = scan.next();
                String foodnamex = scan.next();
                String foodpricex = scan.next();
                String fooddescx = scan.next().trim();
                
                if(foodnamex.equals(fname)){
                    return foodpricex;
                }else{
                    
                }
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(frmCustViewReceipt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void showTransaction(){
        DefaultTableModel model = (DefaultTableModel) frmCustViewReceipt.tblReceipt.getModel();
        model.setRowCount(0);
        File file = new File("D:\\Documents\\Uni_Modules\\Object Oriented Development with Java\\Group Assignment\\Group_9_APU_Cafeteria_Food_Ordering_System\\src\\main\\java\\Database\\order.txt");
        
        try{
            Scanner scan = new Scanner(file);
            scan.useDelimiter("[|\n]");
            
            while(scan.hasNext()){
                String orderidx = scan.next();
                String useridx = scan.next();
                String usernamex = scan.next();
                String orderdatex = scan.next();
                String foodnamex = scan.next();
                
                String foodidx = getFoodID(foodnamex);
                String foodpricex = getFoodPrice(foodnamex);
                
                String categoryx = scan.next();
                String quantityx = scan.next();
                String paidamount = scan.next();
                String paymentdate = scan.next().trim();
                
                if(orderidx.equals(OrderID)&&usernamex.equals(Username)&&useridx.equals(UserID)){
                   
                    model.addRow(new Object[] {foodidx,categoryx,foodnamex,quantityx,foodpricex,paidamount});
                    frmCustViewReceipt.lblDatetime.setText(Date);
                    
                }else{
                    
                }
            
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmCustViewReceipt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showHistory(){
        DefaultTableModel model = (DefaultTableModel) frmCustTransactionRecord.tblTransactionRecord.getModel();
        model.setRowCount(0);
        
        
        try{
            File file = new File("D:\\Documents\\Uni_Modules\\Object Oriented Development with Java\\Group Assignment\\Group_9_APU_Cafeteria_Food_Ordering_System\\src\\main\\java\\Database\\payment.txt");
            Scanner scan = new Scanner(file);
            scan.useDelimiter("[|\n]");
            
            FileReader fr = new FileReader(file);
            
            while(scan.hasNext()){
                
                String paymentidx = scan.next();
                String orderidx = scan.next();
                String useridx = scan.next();
                String usernamex = scan.next();
                String totalamountx = scan.next();
                String datex = scan.next().trim();
                
                if(useridx.equals(UserID)&&usernamex.equals(Username)){
                    System.out.println("------------------------------");
                    System.out.println("Payment ID: "+paymentidx);
                    System.out.println("Order ID: "+orderidx);
                    System.out.println("Customer ID: "+useridx);
                    System.out.println("Username: "+usernamex);
                    System.out.println("Total Amount: "+totalamountx);
                    System.out.println("Date: "+datex);
                    System.out.println("------------------------------");
                    
                    model.addRow(new Object[] {paymentidx,orderidx,"RM "+totalamountx,datex});
                }else{
                    
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmCustTransactionRecord.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("File Not Found");
        }
    }

    @Override
    public void viewRceipt() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
