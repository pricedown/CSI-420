package statement;

import main.Customer;
import main.Rental;

public class JsonStatement extends Statement {
    public String getHeaderString(Customer customer) {
        return "[" + customer.getName() + "]";
    }

    public String getEachRentalString(Rental rental) {
        return "["+ rental.getMovie().getTitle() + ": " + rental.getCharge() + "]";
    }

    public String getFooterString(Customer customer) {
        String result = "";
        result +=  "[Amount owed is " + customer.getTotalCharge() + "]";
        result += "[You earned " + customer.getTotalFrequentRenterPoints()
                + " frequent renter points]";
        return result;
    }
}
