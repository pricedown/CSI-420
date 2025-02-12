package main;

import price.ChildrensPrice;
import price.NewReleasePrice;
import price.RegularPrice;
import statement.HtmlStatement;

public class Vids {

   public static void main (String args[]) {

      Customer cust1;
      Customer cust2;
      Movie mov1;
      Movie mov2;
      Movie mov3;
      Rental ren1;
      Rental ren2;
      Rental ren3;
      Rental ren4;

      cust1 = new Customer("bob");
      cust2 = new Customer("ann");

      mov1 = new Movie("dumbo", new ChildrensPrice());
      mov2 = new Movie("jaws", new RegularPrice());
      mov3 = new Movie("ghost", new NewReleasePrice());

      ren1 = new Rental(mov1,2);
      ren2 = new Rental(mov2,5);
      ren3 = new Rental(mov3,1);
      ren4 = new Rental(mov3,3);

      cust1.addRental(ren1);
      cust1.addRental(ren2);
      cust2.addRental(ren3);
      cust2.addRental(ren4);

      System.out.println ("\n"+cust1.makeStatement()+"\n" );
      System.out.println ("\n"+cust2.makeStatement()+"\n");

      cust1.setStatementType(new HtmlStatement());
      cust2.setStatementType(new HtmlStatement());
      System.out.println ("\n"+cust1.makeStatement()+"\n" );
      System.out.println ("\n"+cust2.makeStatement()+"\n");
   }

}
