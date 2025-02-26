// joseph isaacs

package statement;

import main.Customer;
import main.Rental;

public abstract class Statement {
    public String makeStatement(Customer customer) {
        String result = getHeaderString(customer);

        for (Rental rental : customer.getRentals()) {
            result += getEachRentalString(rental);
        }

        result += getFooterString(customer);

        return result;
    }

    public abstract String getFooterString(Customer customer);
    public abstract String getEachRentalString(Rental rental);
    public abstract String getHeaderString(Customer customer);
}
