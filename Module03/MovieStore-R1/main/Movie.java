package main;

public class Movie {

   // TODO: could be enums, or different classes
   public static final int  CHILDRENS = 2;
   public static final int  REGULAR = 0;
   public static final int  NEW_RELEASE = 1;

   private String _title;
   private int _priceCode;

   public Movie(String title, int priceCode) {
      _title = title;
      _priceCode = priceCode;
   }

   public int getPriceCode() {
      return _priceCode;
   }

   public void setPriceCode (int arg) {
      _priceCode = arg;
   }

   public String getTitle() {
      return _title;
   }

   public double getCharge(int daysRented) {
      double price = 0;
      switch (getPriceCode()) {
         case Movie.REGULAR:
            price = 2;
            if (daysRented > 2)
               price += (daysRented - 2) * 1.5;
            break;
         case Movie.NEW_RELEASE:
            price = daysRented * 3;
            break;
         case Movie.CHILDRENS:
            price = 1.5;
            if (daysRented > 3)
               price += (daysRented - 3) * 1.5;
            break;
      }
      return price;
   }

   public int getFrequentRenterPoints(int daysRented) {
      if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
         return 2;
      }
      return 1;
   }
}

