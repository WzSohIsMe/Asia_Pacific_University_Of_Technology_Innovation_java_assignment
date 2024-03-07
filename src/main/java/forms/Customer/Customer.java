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

/**
 *
 * @author User
 */
public interface Customer {

    public abstract int getID();
    public abstract void getFoodMenu(String page);
    public abstract void sendFeedback(int feedbackid);
    public abstract void pay(int paymentID, String order_id, String totalamount);
    public abstract void getFoodCart();
    public abstract void sendOrder(String order_id);
    public abstract void getReceipt();
    public abstract void viewTransactionHistory();
    public abstract void viewRceipt();
    
}
