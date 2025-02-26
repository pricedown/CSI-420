package case5;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
// Uses JUnit5 or know as Jupiter
 

public class CustomerTest {

    @Test
    void testGetBillAmountForRegularCustomer() {
        Customer regular = new RegularCustomer("Jhon");
        regular.createBill(LocalDate.now());
        double expected = 20.0; // Bill Amount: 20.0
        assertEquals(expected, regular.getBillAmount());
    }

    @Test
    void testGetBillAmountForPreferredCustomer() {
        Customer preferred = new PreferredCustomer("Mike");
        preferred.createBill(LocalDate.now());
        double expected = 54.0; // Bill Amount: 54.0
        assertEquals(expected, preferred.getBillAmount());
    }

}
