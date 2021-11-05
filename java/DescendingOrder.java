/*

Your task is to make a function that can take any non-negative integer as an argument
and return it with its digits in descending order.
Essentially, rearrange the digits to create the highest possible number.

Examples:
Input: 42145 Output: 54421

Input: 145263 Output: 654321

Input: 123456789 Output: 987654321

Run: PROGRAM=DescendingOrder && javac $PROGRAM.java && java $PROGRAM
*/

public class DescendingOrder {
  public static int sortDesc(final int num) {
    int sortedNumber = 0;
    for (int i = 9; i >= 0; i--) {
        int tmpNumber = num;

        while (tmpNumber > 0) {
            int digit = tmpNumber % 10;

            if (digit == i) {
                sortedNumber *= 10;
                sortedNumber += digit;
            }
            tmpNumber /= 10;
        }
    }
    // return our sorted number
    return sortedNumber;
  }
    public static void main(String[] args) {
        // Should be all True
        System.out.println(54321 == DescendingOrder.sortDesc(12345));
        System.out.println(654321 == DescendingOrder.sortDesc(145263));
    }
}


/*

CleverSolution:

import java.util.Comparator;
import java.util.stream.Collectors;

public class DescendingOrder {
    public static int sortDesc(final int num) {
        return Integer.parseInt(String.valueOf(num)
                                      .chars()
                                      .mapToObj(i -> String.valueOf(Character.getNumericValue(i)))
                                      .sorted(Comparator.reverseOrder())
                                      .collect(Collectors.joining()));
    }
}

*/
