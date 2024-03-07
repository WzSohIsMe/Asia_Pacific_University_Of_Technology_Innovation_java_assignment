/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.Manager;

/**
 *
 * @author Teoh Will Shen
 */
public interface Manager {
    public abstract void saveInformation();
    
    public abstract int generateID();
    
    public abstract void importFiletoTable();
    
    public abstract void searchInformation(String searchText);
}
