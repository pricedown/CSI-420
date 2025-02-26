package case5;

import java.time.LocalDate;
// Author: Murat Gungor 
// Champlain College
// For UML Class Diagram, install plug-in 
// https://www.objectaid.com/install-objectaid
public class Company {

    public static void main(String[] args) {
        Customer regular = new RegularCustomer("Jhon");
        regular.createBill(LocalDate.now());
        //Bill Amount: 20.0
        System.out.println("Bill Amount: " +  regular.getBillAmount());
        
        Customer preferred = new PreferredCustomer("Mike");
        preferred.createBill(LocalDate.now());
        //Bill Amount: 54.0
        System.out.println("Bill Amount: " +  preferred.getBillAmount());
    }
}
