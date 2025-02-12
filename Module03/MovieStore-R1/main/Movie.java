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
   // Third step: move getCharge to subclasses
      // First, move entire switch statement into base class (test)
      // Then, copy + paste the method into subclasses with override, (test)
      // Edit each one and trim out the unnecessary branches (test for each)
      // Finally, make it abstract
   // Fourth step: move getFrequentRenterPoints
   // Fifth step: Observe that getPriceCode is not being used...
      // Comment out and remove
      // Suddenly all of the final ints are not being used!
      // Completely rid of the smell

   private String _title;
   private Price _price;

   public Movie(String title, Price priceCode) {
      setTitle(title);
      setPriceCode(priceCode);
   }
   public double getCharge(int daysRented) {
      return _price.getCharge(daysRented);
   }

   public int getFrequentRenterPoints(int daysRented) {
      return _price.getFrequentRenterPoints(daysRented);
   }

   public void setPriceCode (Price price) {
      _price = price;
   }

   public String getTitle() {
      return _title;
   }
   public void setTitle(String title) {
      _title = title;
   }

}

