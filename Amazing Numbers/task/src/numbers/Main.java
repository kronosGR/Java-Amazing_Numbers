package numbers;

import java.util.Scanner;

class AmazingNumbers {
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

    private boolean isDuck(){
        String tmp = String.valueOf(num).substring(1);
        return tmp.contains("0");
    }

    public void start() {
        askNumber();
        isNatural();
        System.out.println("Properties of "+ num);
        System.out.println("        even: "+ isEven());
        System.out.println("         odd: "+ isOdd());
        System.out.println("        buzz: "+ isBuzz());
        System.out.println("        duck: "+ isDuck());

    }
}

public class Main {
    public static void main(String[] args) {
//        write your code here

        AmazingNumbers aNum = new AmazingNumbers();
        aNum.start();
    }
}
