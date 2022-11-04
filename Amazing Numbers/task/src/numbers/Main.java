package numbers;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

class AmazingNumbers {
    private Scanner sc = new Scanner(System.in);
    private Long num;

    private void askNumber() {
        System.out.println("Enter a request: ");
        num = sc.nextLong();
    }

    private boolean isNatural() {
        if (num < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
        }
        return num >= 0;
    }

    private boolean isEven() {
//        if (num % 2 == 0) {
//            System.out.println("The number is Even.");
//        } else {
//            System.out.println("The number is Odd.");
//        }
        return num % 2 == 0;
    }

    private boolean isOdd() {
        return num % 2 != 0;
    }

    private boolean isBuzz() {
//        String msg = "";
//        String explanation = "";
        if (num % 7 != 0 && String.valueOf(num).charAt(String.valueOf(num).length() - 1) != 55) {
//            explanation = num + " is neither divisible by 7 nor does it end with 7.";
//            msg = "It is not a Buzz number.";
            return false;
        } else if (num % 7 == 0 && String.valueOf(num).charAt(String.valueOf(num).length() - 1) == 55) {
//            explanation = num + " is divisible by 7 and ends with 7.";
//            msg = "It is a Buzz number.";
            return true;
        } else if (num % 7 == 0) {
//            explanation = num + " is divisible by 7.";
//            msg = "It is a Buzz number.";
            return true;
        } else if (String.valueOf(num).charAt(String.valueOf(num).length() - 1) == 55) {
//            explanation = num + " ends with 7";
//            msg = "It is a Buzz number.";
            return true;
        }
//        System.out.println(msg);
//        System.out.println("Explanation:");
//        System.out.println(explanation);
        return false;
    }

    private boolean isDuck() {
        String tmp = String.valueOf(num).substring(1);
        return tmp.contains("0");
    }

    private String formatNumber() {
        return NumberFormat.getNumberInstance(Locale.US).format(num);
    }

    private void printIntro() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println();
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter 0 to exit.");
        System.out.println();
    }

    private boolean isPalindromic() {
        String reverse = "";
        String org = String.valueOf(num);
        int length = org.length();
        for (int i = length - 1; i >= 0; i--) {
            reverse = reverse + org.charAt(i);
        }
        return org.equals(reverse);
    }

    public void start() {
        printIntro();
        while (true) {
            askNumber();
            if (num == 0) {
                break;
            }
            if (!isNatural()){
                continue;
            }
            System.out.println("Properties of " + formatNumber());
            System.out.println("        even: " + isEven());
            System.out.println("         odd: " + isOdd());
            System.out.println("        buzz: " + isBuzz());
            System.out.println("        duck: " + isDuck());
            System.out.println(" palindromic: " + isPalindromic());
        }
        System.out.println("Goodbye!");
    }
}

public class Main {
    public static void main(String[] args) {
//        write your code here

        AmazingNumbers aNum = new AmazingNumbers();
        aNum.start();
    }
}
