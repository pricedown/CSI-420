package price;

import main.Movie;

// Childrens, NewRelease, Regular
public class ChildrensPrice extends Price {
    @Override
    public double getCharge(int daysRented) {
        double price;
        price = 1.5;
        if (daysRented > 3)
            price += (daysRented - 3) * 1.5;
        return price;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
