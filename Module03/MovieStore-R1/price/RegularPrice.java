// joseph isaacs

package price;

public class RegularPrice extends Price {
    @Override
    public double getCharge(int daysRented) {
        double price = 0;
        price = 2;
        if (daysRented > 2)
            price += (daysRented - 2) * 1.5;
        return price;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }

}
