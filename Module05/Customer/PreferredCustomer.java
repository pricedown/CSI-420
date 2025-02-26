package case5;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PreferredCustomer extends Customer {

    public PreferredCustomer(String name) {
        super(name);
    }

    public double chargeFor(LocalDate start, LocalDate end) {
        return ChronoUnit.DAYS.between(start, end) * 5 * 1.08; // $5 per day + TAX (8%)
    }
}