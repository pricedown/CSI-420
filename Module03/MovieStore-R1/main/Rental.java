package main;

public class Rental {

   private Movie _movie;
   private int _daysRented;

   public Rental(Movie movie, int daysRented) {
      _movie = movie;
      _daysRented = daysRented;
   }

   // TODO: take some methods from Customer.statement()

   public int getDaysRented() {
      return _daysRented;
   }

   public Movie getMovie() {
      return _movie;
   }

   public double getCharge() {
      return getMovie().getCharge(getDaysRented());
   }

   public int getFrequentRenterPoints() {
      if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1) {
         return 2;
      }
      return 1;
   }
}

