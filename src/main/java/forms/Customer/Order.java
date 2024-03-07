/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.Customer;

import static forms.Customer.frmCustCart.tblCart;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Order implements Customer{
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
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public Order(){
    
    }
    
    /**
     *
     * @param t
     */
    public Order(String t){
        this.type = t;
    }

    public Order(String ID, String u, String p){
        UserID = ID;
        Username = u;
        Password = p;
    }

    public Order(String ID, String u, String p, String payID, String ordID){
        UserID = ID;
        Username = u;
        Password = p;
        PaymentID = payID;
        OrderID = ordID;
    }

    public Order(String ID, String u, String p, String d, String payID, String ordID){
        UserID = ID;
        Username = u;
        Password = p;
        Date = d;
        PaymentID = payID;
        OrderID = ordID;
    }
    
    public int getID(){
        int orderidx=0;
        String customeridx = "";
        String usernamex = "";
        String orderdatex = "";
        String foodnamex = "";
        String categoryx = "";
        int quantity = 0;
        String paidamountx = "";
        String paymentdatex = "";
        File orderfile = new File("D:\\Documents\\Uni_Modules\\Object Oriented Development with Java\\Group Assignment\\Group_9_APU_Cafeteria_Food_Ordering_System\\src\\main\\java\\Database\\order.txt");

        try{
            Scanner scan = new Scanner(orderfile);
            scan.useDelimiter("[|\n]");

            while(scan.hasNext()){

                orderidx = Integer.parseInt(scan.next());
                customeridx = scan.next();
                usernamex = scan.next();
                orderdatex = scan.next();
                foodnamex = scan.next();
                categoryx = scan.next();
                quantity = Integer.parseInt(scan.next());
                paidamountx = scan.next();
                paymentdatex = scan.next().trim();

                System.out.println("The latest order id is: "+orderidx);

            }
        } catch (Exception ex) {
            Logger.getLogger(frmCustCart.class.getName()).log(Level.SEVERE, null, ex);
        }
        orderidx = orderidx + 1; // get the next category id in the text file
//        this.OrderID=orderidx;
        return orderidx;
    }
    
    /**
     *
     * @param order_id
     * @throws IOException
     */
    public String getTotalAmount(){
       double sum = 0;
       double TotalAmount = 0;
       for(int i =0; i<frmCustCart.tblCart.getRowCount();i++){
               sum = sum + Double.parseDouble(frmCustCart.tblCart.getValueAt(i, 5).toString());
           }
           TotalAmount = sum;
           System.out.println("SUM is"+sum);
           System.out.println("TotalAmount is"+TotalAmount);
           System.out.println(sum);

           df.setRoundingMode(RoundingMode.UP);
           String str_TotalAmount = df.format(TotalAmount);
           return str_TotalAmount;
   }
    @Override
    public void sendOrder(String order_id){
        double sum = 0;
        try
        {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.now();

            Date = dtf.format(localDate).toString();
            File f = new File("D:\\Documents\\Uni_Modules\\Object Oriented Development with Java\\Group Assignment\\Group_9_APU_Cafeteria_Food_Ordering_System\\src\\main\\java\\Database\\order.txt");
            FileWriter fw = new FileWriter(f,true);
            
            String foodname="";
            String foodcategory = "";
            String paidamount = "";
            int quantity = 0;
            
            for(int i=0;i<tblCart.getRowCount();i++){
                foodname = tblCart.getValueAt(i, 2).toString();
                foodcategory = tblCart.getValueAt(i, 1).toString();
                paidamount = tblCart.getValueAt(i, 5).toString();
                quantity = Integer.parseInt((tblCart.getValueAt(i, 3).toString()));
                fw.write(order_id+"|"+UserID+"|"+Username+"|"+Date+"|"+foodname+"|"+foodcategory+"|"+quantity+"|"+paidamount+"|"+Date);
                fw.write(System.getProperty("line.separator"));
                
                sum = sum + Double.parseDouble(tblCart.getValueAt(i,5).toString());
            
            }
            fw.close();
            double TotalAmount = 0.00;
            TotalAmount = sum;
            df.setRoundingMode(RoundingMode.UP);
            String str_TotalAmount = df.format(TotalAmount);
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(frmCustCart.class.getName()).log(Level.SEVERE, null, ex);
        }
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
