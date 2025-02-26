package case5;

import java.time.*;
import java.time.temporal.ChronoUnit;

public abstract class Customer {

    protected LocalDate lastBillDate;
    protected double billAmount;
    protected String name;

    public Customer(String name) {
        this.name = name;
        lastBillDate = LocalDate.now().minusDays(10);
    }

    public void addBill(LocalDate date, double amount) {
        lastBillDate = date;
        billAmount = amount;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public abstract double chargeFor(LocalDate start, LocalDate end);

    public void createBill(LocalDate date) {
        double chargeAmount = chargeFor(lastBillDate, date);
        addBill(date, chargeAmount);
    }
}
