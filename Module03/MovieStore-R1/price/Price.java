package price;

import main.Movie;

public abstract class Price {
    abstract public int getPriceCode();
    abstract public double getCharge(int daysRented);
}
