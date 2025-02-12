package statement;

import main.Customer;
import main.Rental;

public class TextStatement extends Statement {
    public String makeStatement(Customer customer) {
        String result = "Rental Record for " + customer.getName() + "\n";

        //show figures for this rental
        for (Rental rental : customer.getRentals()) {
            result += "\t" + rental.getMovie().getTitle() + "\t" + rental.getCharge() + "\n";
        }

        //add footer lines
        result +=  "Amount owed is " + customer.getTotalCharge() + "\n";
        result += "You earned " + customer.getTotalFrequentRenterPoints()
                + " frequent renter points";

        return result;
    }
}
