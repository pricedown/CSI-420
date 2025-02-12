package price;

import main.Movie;

public class NewReleasePrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }
}
