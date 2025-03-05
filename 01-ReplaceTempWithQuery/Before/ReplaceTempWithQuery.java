/*
 Replace Temp with Query
Steps 
1- Extract the expression into a method. 
2- Replace all references to the temp with the expression
   Select (Highlight) _quantity * _itemPrice then right click Extract Method via Refactoring menu.


Benefit:
The new method can then be used in other methods.

Motivation
The problem with temps is that they are temporary and local. 
Because they can be seen only in the context of the method 
in which they are used, temps tend to encourage longer methods,
because that's the only way you can reach the temp. By replacing 
the temp with a query method,any method in the class can get at 
the information. That helps a lot in coming up with cleaner code for the class.

 */

public class ReplaceTempWithQuery {

    double _quantity = 10.0;
    double _itemPrice = 3.5;

    double getPrice() {
        return calculateBasePrice() * calculateDiscountFactor();
    }

    private double calculateDiscountFactor() {
        if (calculateBasePrice() > 1000)
            return 0.95;
        return 0.98;
    }

    private double calculateBasePrice() {
        return _quantity * _itemPrice;
    }


    public static void main(String[] args) {
        ReplaceTempWithQuery em = new ReplaceTempWithQuery();
        em.getPrice();
    }
}
