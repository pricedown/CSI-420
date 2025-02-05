package main;

import java.util.* ;

public class Customer {

    private String _name;
    private ArrayList<Rental> _rentals = new ArrayList<>();

    public Customer(String name) {
       _name = name;
    }

    public void addRental(Rental arg) {
       _rentals.add(arg);
    }

    public String getName() {
       return _name;
    }

    // TODO: massive function, offload some to rental class
    // TODO: Split display from calculation
        // "extract method refactoring"
            // functions should have the same LEVEL of complexity (low-high), so dont printBanner() and then System. ...
            // basically where there are comments, you can extract if its better
            // process: // copy, compile, replace, compile & test
            // feels like good form in rock climbing, or movement in tai chi
            // I am a slow walker, but I never walk backwards

        // "move method refactoring"
            // AmountOwed() does not really belong to this class
            // process: copy over, old invokes new, test, deprecate or remove (sudden movements = destruction)
                // then change all references to use the reference.method directly

        // modules refactoring
            // normally in java we have a main package and a testing package

        // On optimization...
            // The best way to optimize performance is to first write a well factored program, then optimize it
            // Later you can run profiler to find the problem "hot spots"
                // [ Unless you have evidence, code is innocent ]
            // Temps are often a problem in that they cause a lot of parameters to be passed around unnecessarily
                // - Look at temporary local variables like question marks
                //  Variables are like pets
        // "replace temp with query"
            // lays the groundwork for applying extract method, cause otherwise you will need to redefine the var across extracted methods

        // getOutstanding()
        // getRenterPoints()
        // statement() // string and formatting
    // TODO: we can store records in some state surely, not all at runtime
    public String statement() {
        String result = "Rental Record for " + getName() + "\n";

        int frequentRenterPoints = 0;
        double totalAmount = 0;

        for (Rental rental : _rentals) {
            // add frequent renter points
            frequentRenterPoints++;

            // TODO: Does this need to be separate here?
            // add bonus for a two day new release rental
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1) {
                frequentRenterPoints++;
            }

            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + rental.getCharge() + "\n";

            totalAmount += rental.getCharge();
        }

        //add footer lines
        result +=  "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints
                + " frequent renter points";

        return result;
    }
}


