// joseph isaacs

package statement;

import main.Customer;
import main.Rental;

public class TextStatement extends Statement {
    public String getHeaderString(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }

    public String getEachRentalString(Rental rental) {
        return "\t" + rental.getMovie().getTitle() + "\t" + rental.getCharge() + "\n";
    }

    public String getFooterString(Customer customer) {
        String result = "";
        result +=  "Amount owed is " + customer.getTotalCharge() + "\n";
        result += "You earned " + customer.getTotalFrequentRenterPoints()
                + " frequent renter points";
        return result;
    }
}
