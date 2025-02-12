package statement;

import main.Customer;
import main.Rental;

public class HtmlStatement extends Statement {
    public String makeStatement(Customer customer) {
        String result = "<h1>Rental Record for " + customer.getName() + "</h1>";

        //show figures for this rental
        for (Rental rental : customer.getRentals()) {
            result += "<p>"+ rental.getMovie().getTitle() + "<br>" + rental.getCharge();
        }

        //add footer lines
        result +=  "<p>Amount owed is " + customer.getTotalCharge() + "</p>";
        result += "<p>You earned " + customer.getTotalFrequentRenterPoints()
                + " frequent renter points</p>";

        return result;
    }
}
