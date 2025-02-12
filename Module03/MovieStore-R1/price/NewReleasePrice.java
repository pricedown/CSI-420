package price;

import main.Movie;

public class NewReleasePrice extends Price {
    /*
    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

     */

    @Override
    public double getCharge(int daysRented) {
        double price = 0;
        price = daysRented * 3;
        return price;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        if (daysRented > 1) {
            return 2;
        }
        return 1;
    }
}
