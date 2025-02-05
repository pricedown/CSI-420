package test;

import main.Customer;
import main.Movie;
import main.Rental;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @org.junit.jupiter.api.Test
    void testStatementBob() {
        String expected = """
                Rental Record for bob
                	dumbo	1.5
                	jaws	6.5
                Amount owed is 8.0
                You earned 2 frequent renter points""";

        Customer cust1;
        Movie mov1;
        Movie mov2;
        Rental ren1;
        Rental ren2;

        cust1 = new Customer("bob");
        mov1 = new Movie("dumbo", 2);
        mov2 = new Movie("jaws", 0);
        ren1 = new Rental(mov1,2);
        ren2 = new Rental(mov2,5);
        cust1.addRental(ren1);
        cust1.addRental(ren2);

        assertEquals(expected, cust1.statement());
    }

    @org.junit.jupiter.api.Test
    void testStatementAnn() {
        String expected = """
                Rental Record for ann
                	ghost	3.0
                	ghost	9.0
                Amount owed is 12.0
                You earned 3 frequent renter points""";

        Customer cust2;
        Movie mov3;
        Rental ren3;
        Rental ren4;
        cust2 = new Customer("ann");
        mov3 = new Movie("ghost", 1);
        ren3 = new Rental(mov3, 1);
        ren4 = new Rental(mov3, 3);
        cust2.addRental(ren3);
        cust2.addRental(ren4);

        assertEquals(expected, cust2.statement());
    }
}