package statement;

import main.Customer;
import main.Rental;

public class HtmlStatement extends Statement {
    public String getHeaderString(Customer customer) {
        return "<h1>Rental Record for " + customer.getName() + "</h1>";
    }

    public String getEachRentalString(Rental rental) {
        return "<p>"+ rental.getMovie().getTitle() + "<br>" + rental.getCharge();
    }

    public String getFooterString(Customer customer) {
        String result = "";
        result +=  "<p>Amount owed is " + customer.getTotalCharge() + "</p>";
        result += "<p>You earned " + customer.getTotalFrequentRenterPoints()
                + " frequent renter points</p>";
        return result;
    }
}
