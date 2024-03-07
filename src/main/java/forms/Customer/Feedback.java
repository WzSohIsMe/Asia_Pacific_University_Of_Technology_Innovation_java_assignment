/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.Customer;

import static forms.Customer.frmCustFeedback.btgQuestion2;
import static forms.Customer.frmCustFeedback.txaFeedback;
import static forms.Customer.frmCustFeedback.txtDigit1;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Feedback implements Customer{
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
    
    private String Q1;
    private String Q2;
    private String Q3;
    
    public Feedback(){
    
    }
    
    /**
     *
     * @param t
     */
    public Feedback(String t){
        this.type = t;
    }

    public Feedback(String ID, String u, String p){
        UserID = ID;
        Username = u;
        Password = p;
    }

    public Feedback(String ID, String u, String p, String payID, String ordID){
        UserID = ID;
        Username = u;
        Password = p;
        PaymentID = payID;
        OrderID = ordID;
    }

    public Feedback(String ID, String u, String p, String d, String payID, String ordID){
        UserID = ID;
        Username = u;
        Password = p;
        Date = d;
        PaymentID = payID;
        OrderID = ordID;
    }

    @Override
    public int getID() {
        int feedbackidx=0;
            String paymentidx = "";
            String orderidx = "";
            String useridx = "";
            String usernamex = "";
            String q1x ="";
            String q2x ="";
            String q3x ="";

            File feedbackfile = new File("D:\\Documents\\Uni_Modules\\Object Oriented Development with Java\\Group Assignment\\Group_9_APU_Cafeteria_Food_Ordering_System\\src\\main\\java\\Database\\feedback.txt");

            try{
                Scanner scan = new Scanner(feedbackfile);
                scan.useDelimiter("[|\n]");

                while(scan.hasNext()){

                    feedbackidx = Integer.parseInt(scan.next());
                    paymentidx = scan.next();
                    orderidx = scan.next();
                    useridx = scan.next();
                    usernamex = scan.next();
                    q1x = scan.next();
                    q2x = scan.next();                
                    q3x = scan.next().trim();

                }
            } catch (Exception ex) {
                Logger.getLogger(frmCustFeedback.class.getName()).log(Level.SEVERE, null, ex);
            }
            feedbackidx = feedbackidx + 1; // get the next category id in the text file
            System.out.println("New feedback id will be: "+feedbackidx);
            return feedbackidx;
    }

    public void sendFeedback(int f){
        int feedbackid = f;
        if(frmCustFeedback.txtDigit1.getText().equals("")||frmCustFeedback.txtDigit1.getText().equals("0")||btgQuestion2.getSelection().getActionCommand()==null||txaFeedback.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Invalid Input","Feedback Error",JOptionPane.ERROR_MESSAGE);
        }else{
            try {

                File file = new File("D:\\Documents\\Uni_Modules\\Object Oriented Development with Java\\Group Assignment\\Group_9_APU_Cafeteria_Food_Ordering_System\\src\\main\\java\\Database\\feedback.txt");
                FileWriter fw = new FileWriter(file,true);

                Q1 = frmCustFeedback.txtDigit1.getText();
                Q2 = frmCustFeedback.btgQuestion2.getSelection().getActionCommand();
                Q3 = frmCustFeedback.txaFeedback.getText();

                fw.write(feedbackid+"|"+PaymentID+"|"+OrderID+"|"+UserID+"|"+Username+"|"+Q1+"|"+Q2+"|"+Q3);
                fw.write(System.getProperty("line.separator"));
                fw.close();  
                
            } catch (IOException ex) {
                Logger.getLogger(frmCustFeedback.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }
    
    
    
    @Override
    public void getFoodMenu(String page) {
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
