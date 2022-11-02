package numbers;

import java.util.Scanner;

class Buzz {
    private Scanner sc = new Scanner(System.in);
    private int num;

    private void askNumber() {
        System.out.println("Enter a natural number:");
        num = sc.nextInt();
    }

    private void isNatural() {
        if (num < 1) {
            System.out.println("This number is not natural");
            System.exit(1);
        }
    }

    public void isEven() {
        if (num % 2 == 0) {
            System.out.println("The number is Even.");
        } else {
            System.out.println("The number is Odd.");
        }
    }

    public void isBuzz() {
        String msg = "";
        String explanation = "";
        if (num % 7 != 0 && String.valueOf(num).charAt(String.valueOf(num).length() - 1) != 55) {
            explanation = num + " is neither divisible by 7 nor does it end with 7.";
            msg = "It is not a Buzz number.";
        } else if (num % 7 == 0 && String.valueOf(num).charAt(String.valueOf(num).length() - 1) == 55) {
            explanation = num + " is divisible by 7 and ends with 7.";
            msg = "It is a Buzz number.";
        } else if (num % 7 == 0) {
            explanation = num + " is divisible by 7.";
            msg = "It is a Buzz number.";
        } else if (String.valueOf(num).charAt(String.valueOf(num).length() - 1) == 55) {
            explanation = num + " ends with 7";
            msg = "It is a Buzz number.";
        }
        System.out.println(msg);
        System.out.println("Explanation:");
        System.out.println(explanation);
    }

    public void start() {
        askNumber();
        isNatural();
        isEven();
        isBuzz();
    }
}

public class Main {
    public static void main(String[] args) {
//        write your code here

        Buzz buzz = new Buzz();
        buzz.start();
    }
}
