package price;

import main.Movie;

// Childrens, NewRelease, Regular
public class ChildrensPrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.CHILDRENS;
    }
}
