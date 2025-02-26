// joseph isaacs

package test;

import main.Customer;
import main.Movie;
import main.Rental;
import price.ChildrensPrice;
import price.NewReleasePrice;
import price.RegularPrice;
import statement.HtmlStatement;
import statement.TextStatement;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @org.junit.jupiter.api.Test
    void testTextMakeStatementBob() {
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
        mov1 = new Movie("dumbo",  new ChildrensPrice());
        mov2 = new Movie("jaws",  new RegularPrice());
        ren1 = new Rental(mov1,2);
        ren2 = new Rental(mov2,5);
        cust1.addRental(ren1);
        cust1.addRental(ren2);

        cust1.setStatementType(new TextStatement());
        assertEquals(expected, cust1.makeStatement());
    }

    @org.junit.jupiter.api.Test
    void testHtmlMakeStatementBob() {
        String expected = """
<h1>Rental Record for bob</h1><p>dumbo<br>1.5<p>jaws<br>6.5<p>Amount owed is 8.0</p><p>You earned 2 frequent renter points</p> """;

        Customer cust1;
        Movie mov1;
        Movie mov2;
        Rental ren1;
        Rental ren2;

        cust1 = new Customer("bob");
        mov1 = new Movie("dumbo",  new ChildrensPrice());
        mov2 = new Movie("jaws",  new RegularPrice());
        ren1 = new Rental(mov1,2);
        ren2 = new Rental(mov2,5);
        cust1.addRental(ren1);
        cust1.addRental(ren2);

        cust1.setStatementType(new HtmlStatement());
        assertEquals(expected, cust1.makeStatement());
    }

    @org.junit.jupiter.api.Test
    void testTextMakeStatementAnn() {
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
        mov3 = new Movie("ghost", new NewReleasePrice());
        ren3 = new Rental(mov3, 1);
        ren4 = new Rental(mov3, 3);
        cust2.addRental(ren3);
        cust2.addRental(ren4);

        cust2.setStatementType(new TextStatement());
        assertEquals(expected, cust2.makeStatement());
    }

    @org.junit.jupiter.api.Test
    void testHtmlMakeStatementAnn() {
        String expected = """
                <h1>Rental Record for ann</h1><p>ghost<br>3.0<p>ghost<br>9.0<p>Amount owed is 12.0</p><p>You earned 3 frequent renter points</p> """;

        Customer cust2;
        Movie mov3;
        Rental ren3;
        Rental ren4;
        cust2 = new Customer("ann");
        mov3 = new Movie("ghost", new NewReleasePrice());
        ren3 = new Rental(mov3, 1);
        ren4 = new Rental(mov3, 3);
        cust2.addRental(ren3);
        cust2.addRental(ren4);

        cust2.setStatementType(new HtmlStatement());
        assertEquals(expected, cust2.makeStatement());
    }
}