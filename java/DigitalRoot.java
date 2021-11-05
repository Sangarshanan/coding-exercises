/*
Digital root is the recursive sum of all the digits in a number.

Given n, take the sum of the digits of n. If that value has more than one digit
continue reducing in this way until a single-digit number is produced.

The input will be a non-negative integer.

Examples
    16  -->  1 + 6 = 7
   942  -->  9 + 4 + 2 = 15  -->  1 + 5 = 6
132189  -->  1 + 3 + 2 + 1 + 8 + 9 = 24  -->  2 + 4 = 6
493193  -->  4 + 9 + 3 + 1 + 9 + 3 = 29  -->  2 + 9 = 11  -->  1 + 1 = 2

Run: PROGRAM=DigitalRoot && javac $PROGRAM.java && java $PROGRAM
*/

public class DigitalRoot {
    public static int sum_of_digits(int digits) {
        int sum = 0;
        while (digits > 0) {
            sum += digits % 10;
            digits = digits / 10;
        }
        return sum;
    }

    public static int digital_root(int number) {
        while (number >= 10) {
            number = DigitalRoot.sum_of_digits(number);
        }
        return number;
    }
    public static void main(String[] args) {
        // Should be all True
        System.out.println(1 == DigitalRoot.digital_root(10));
        System.out.println(7 == DigitalRoot.digital_root(16));
        System.out.println(6 == DigitalRoot.digital_root(942));
        System.out.println(6 == DigitalRoot.digital_root(132189));
        System.out.println(2 == DigitalRoot.digital_root(493193));
    }
}

/*
Best Solution

public class DRoot {
  public static int digital_root(int n) {
    return (n != 0 && n%9 == 0) ? 9 : n % 9;
  }
}

*/
