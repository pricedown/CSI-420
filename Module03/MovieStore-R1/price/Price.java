package price;

import main.Movie;

public abstract class Price {
    abstract public double getCharge(int daysRented);
    abstract public int getFrequentRenterPoints(int daysRented);
}
