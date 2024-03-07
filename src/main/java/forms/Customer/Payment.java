/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.Customer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Payment implements Customer{
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
    public Payment(){
    
    }
    
    /**
     *
     * @param t
     */
    public Payment(String t){
        this.type = t;
    }

    public Payment(String ID, String u, String p){
        UserID = ID;
        Username = u;
        Password = p;
    }

    public Payment(String ID, String u, String p, String d){
        UserID = ID;
        Username = u;
        Password = p;
        Date = d;
    }

    public Payment(String ID, String u, String p, String payID, String ordID){
        UserID = ID;
        Username = u;
        Password = p;
        PaymentID = payID;
        OrderID = ordID;
    }

    public Payment(String ID, String u, String p, String d, String payID, String ordID){
        UserID = ID;
        Username = u;
        Password = p;
        Date = d;
        PaymentID = payID;
        OrderID = ordID;
    }
    @Override
    public int getID() {
        int paymentIDx = 0;
        String orderIDx = "";
        String UserIDx = "";
        String Usernamex = "";
        String TotalAmountx="";
        String Datex="";
        String feedbackIDx="";

        File paymentfile = new File("D:\\Documents\\Uni_Modules\\Object Oriented Development with Java\\Group Assignment\\Group_9_APU_Cafeteria_Food_Ordering_System\\src\\main\\java\\Database\\payment.txt");

        try{
            Scanner scan = new Scanner(paymentfile);
            scan.useDelimiter("[|\n]");

            while(scan.hasNext()){

                paymentIDx = Integer.parseInt(scan.next());
                orderIDx = scan.next();
                UserIDx = scan.next();
                Usernamex = scan.next();
                TotalAmountx = scan.next();
                Datex = scan.next().trim();

                System.out.println("The latest Payment id is: "+paymentIDx);

            }
        } catch (Exception ex) {
            Logger.getLogger(frmCustCart.class.getName()).log(Level.SEVERE, null, ex);
        }

        paymentIDx = paymentIDx + 1; // get the next category id in the text file
        System.out.println("New Payment ID will be: "+paymentIDx);
        return paymentIDx;
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
    public void pay(int paymentID, String order_id,String totalamo){
        try{
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.now();
            Date = dtf.format(localDate).toString();
            
            System.out.println("the date is "+Date);
            File f1 = new File("D:\\Documents\\Uni_Modules\\Object Oriented Development with Java\\Group Assignment\\Group_9_APU_Cafeteria_Food_Ordering_System\\src\\main\\java\\Database\\payment.txt");
            FileWriter fw1 = new FileWriter(f1,true);
            fw1.write(paymentID+"|"+order_id+"|"+UserID+"|"+Username+"|"+totalamo+"|"+Date);
            fw1.write(System.getProperty("line.separator"));
            fw1.close();
        }catch(IOException ex){
            Logger.getLogger(frmCustCart.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void getFoodCart(){
        DefaultTableModel model = (DefaultTableModel) frmCustCart.tblCart.getModel();
        model.setRowCount(0);
        
        String filePath = "D:\\Documents\\Uni_Modules\\Object Oriented Development with Java\\Group Assignment\\Group_9_APU_Cafeteria_Food_Ordering_System\\src\\main\\java\\Database\\cart.txt";
        File file = new File(filePath);
        
        double TotalAmount = 0;
        double sum = 0;
        
        try {
            
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            Object[] lines = br.lines().toArray();
            
            for(int i=0;i<lines.length;i++){
                String[] row = lines[i].toString().split(Pattern.quote("|"));
                model.addRow(row);
            }
            
            for(int i =0; i<frmCustCart.tblCart.getRowCount();i++){
                sum = sum + Double.parseDouble(frmCustCart.tblCart.getValueAt(i, 5).toString());
            }
            TotalAmount = sum;
            System.out.println("SUM is"+sum);
            System.out.println("TotalAmount is"+TotalAmount);
            System.out.println(sum);
            
            df.setRoundingMode(RoundingMode.UP);
            String str_TotalAmount = df.format(TotalAmount);
            System.out.println("str_TotalAmount is"+str_TotalAmount);
            
            frmCustCart.lblCalculatedTotal.setText("RM "+str_TotalAmount);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmCustCart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getSTRTotalAmount(){
        return STR_TotalAmount;
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
