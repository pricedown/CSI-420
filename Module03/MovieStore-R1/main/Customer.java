// Joseph Isaacs

package main;

import statement.Statement;
import statement.TextStatement;

import java.util.* ;

public class Customer {

    private String _name;
    private ArrayList<Rental> _rentals = new ArrayList<>();
    private Statement statement;

    public Customer(String name) {
       _name = name;
       statement = new TextStatement();
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
            // optimize later
            // lays the groundwork for applying extract method, cause otherwise you will need to redefine the var across extracted methods
            // worst case scenario, at the end when you are optimizing, you just set temp = Query(); !!

        // small, single-pointed and grounded refactors

        // getOutstanding()
        // getRenterPoints()
        // statement() // string and formatting


    // 2/12/25 notes TODO: Move switch statements inside relevant class
        // If you use a switch statement, it should be on your own data
        // so more getCharge() from rental to movie (switch on type of movie)
        // and getFrequentRenterPoints() from rental to movie
        // least ripple effect when changing movie class
        // Use Template method for statement!!

    public void setStatementType(Statement statementType) {
        statement = statementType;
    }
    public String makeStatement() {
        return statement.makeStatement(this);
    }

    public ArrayList<Rental> getRentals() {
        return _rentals;
    }

    public double getTotalCharge() {
        double totalAmount = 0;

        for (Rental rental : _rentals) {
            totalAmount += rental.getCharge();
        }

        return totalAmount;
    }

    public int getTotalFrequentRenterPoints() {
        int totalPoints = 0;
        for (Rental rental : _rentals) {
            totalPoints += rental.getFrequentRenterPoints();
        }
        return totalPoints;
    }

}