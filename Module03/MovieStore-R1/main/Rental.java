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
      return _movie.getCharge(_daysRented);
   }

   public int getFrequentRenterPoints() {
      return _movie.getFrequentRenterPoints(_daysRented);
   }
}

