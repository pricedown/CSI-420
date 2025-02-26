package case5;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RegularCustomer extends Customer {

    public RegularCustomer(String name) {
        super(name);
    }

    public double chargeFor(LocalDate start, LocalDate end) {
        return ChronoUnit.DAYS.between(start, end) * 2; // $2 per day
    }
}