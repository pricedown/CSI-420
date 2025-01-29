import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CalculationTest {

    static int MIN_ELEMENT = -1000;
    static int MAX_ELEMENT = 1000;

    @org.junit.jupiter.api.Test
    void testFindMaxOneElement() {
        for (int i = MIN_ELEMENT; i <= MAX_ELEMENT; i++) {
            int[] arr = { i };
            assertTrue(Calculation.findMax(arr) == i);
        }
    }

    @org.junit.jupiter.api.Test
    void testFindMaxRange() {
        int[] arr1 = { 5, -1, -2, -3, -5, -6, 0, 1, 2, 3, 4, };
        assertTrue(Calculation.findMax(arr1) == 5);

        int[] arr2 = { -1, -2, -3, -5, -6, 0, 1, 2, 3, 4, 5 };
        assertTrue(Calculation.findMax(arr2) == 5);

        int[] arr3 = { 0, -11, 10 };
        assertTrue(Calculation.findMax(arr3) == 10);
    }

    @org.junit.jupiter.api.Test
    void testFindMaxAllPositive() {
        int[] arr1 = { 1, 2, 3, 1 };
        assertTrue(Calculation.findMax(arr1) == 3);

        int[] arr2 = { 4, 2, 3, 1 };
        assertTrue(Calculation.findMax(arr2) == 4);
    }

    @org.junit.jupiter.api.Test
    void testFindMaxAllNegative() {
        int[] arr1 = { -1, -2, -3, -1 };
        assertTrue(Calculation.findMax(arr1) == -1);
    }

    @org.junit.jupiter.api.Test
    void testFindMaxDuplicates() {
        int[] arr1 = { -1, -1, -1, -1 };
        assertTrue(Calculation.findMax(arr1) == -1);

        int[] arr2 = { 1, 1, 1, 1, 1 };
        assertTrue(Calculation.findMax(arr2) == 1);
    }

    @org.junit.jupiter.api.Test
    void testFindMaxEmptyArray() {
        int[] arr = { };
        // https://stackoverflow.com/questions/156503/how-do-you-assert-that-a-certain-exception-is-thrown-in-junit-tests
        IndexOutOfBoundsException e = assertThrows(ArrayIndexOutOfBoundsException.class, () -> Calculation.findMax(arr));
        assertEquals("Index 0 out of bounds for length 0", e.getMessage());
    }
}