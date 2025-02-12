package main;

import price.ChildrensPrice;
import price.NewReleasePrice;
import price.Price;
import price.RegularPrice;

public class Movie {

   // TODO: could be enums, or different classes
   // Use strategy pattern for movie type: Price
   // First step: "Self encapsulate field"
      // Don't set directly, use getting and setting methods
      // flexible for refactoring
   // Second step: replace data with strategy and cleanup
   // Third step: divide functions
      // First, move entire switch statement into base class
      // Then, copy + paste the method into subclasses with override,
      // Edit each one and trim out the unnecessary branches
      // Finally, make it abstract

   public static final int  CHILDRENS = 2;
   public static final int  REGULAR = 0;
   public static final int  NEW_RELEASE = 1;

   private String _title;
   private Price _price;

   public Movie(String title, int priceCode) {
      setTitle(title);
      setPriceCode(priceCode);
   }
   public double getCharge(int daysRented) {
      return _price.getCharge(daysRented);
   }

   public int getFrequentRenterPoints(int daysRented) {
      if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
         return 2;
      }
      return 1;
   }

   public int getPriceCode() {
      return _price.getPriceCode();
   }

   public void setPriceCode (int arg) {
      switch (arg) {
         case Movie.REGULAR:
            _price = new RegularPrice();
            break;
         case Movie.NEW_RELEASE:
            _price = new NewReleasePrice();
            break;
         case Movie.CHILDRENS:
            _price = new ChildrensPrice();
            break;
         default:
            throw new IllegalArgumentException("Unexpected Price Code");
      }
   }

   public String getTitle() {
      return _title;
   }
   public void setTitle(String title) {
      _title = title;
   }

}

