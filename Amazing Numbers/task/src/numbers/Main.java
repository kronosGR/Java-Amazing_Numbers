package numbers;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

class AmazingNumbers {
    private Scanner sc = new Scanner(System.in);
    private Long num;
    private Long num2;
    private String keyword = "";
    private List<String> properites = new ArrayList<>();

    private Pattern numericPattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public AmazingNumbers() {
        properites.add("BUZZ");
        properites.add("DUCK");
        properites.add("PALINDROMIC");
        properites.add("GAPFUL");
        properites.add("SPY");
        properites.add("EVEN");
        properites.add("ODD");
    }

    private boolean askInput() {
        boolean isGoodOne = false;
        boolean isGoodTwo = false;
        //TODO
        num = 0L;
        num2 = 0L;
        System.out.println();
        System.out.println("Enter a request: ");
        String value = sc.nextLine();
        String[] valueA = value.split(" ");
        if (isNumeric(valueA[0])) {
            num = Long.parseLong(valueA[0]);
            if (num < 0) {
                System.out.println("The first parameter should be a natural number or zero.");
            } else {
                isGoodOne = true;
            }
        } else {
            System.out.println("The first parameter should be a natural number or zero.");
        }

        if (valueA.length > 1) {
            if (isNumeric(valueA[1]))
                num2 = Long.parseLong(valueA[1]);
            if (num2 < 1) {
                System.out.println("The second parameter should be a natural number.");
            } else {
                isGoodTwo = true;
            }
        }
        if (valueA.length == 3) {
            keyword = valueA[2];
        }
        return isGoodOne || isGoodTwo;
    }

    private boolean isNumeric(String number) {
        if (number == null) return false;
        return numericPattern.matcher(number).matches();
    }

    private boolean isEven(Long number) {
        return number % 2 == 0;
    }

    private boolean isOdd(Long number) {
        return number % 2 != 0;
    }

    private boolean isBuzz(Long number) {
        char c = String.valueOf(number).charAt(String.valueOf(number).length() - 1);
        if (number % 7 != 0 && c != 55) {
            return false;
        } else if (number % 7 == 0 && c == 55) {
            return true;
        } else if (number % 7 == 0) {
            return true;
        } else if (c == 55) {
            return true;
        }
        return false;
    }

    private boolean isDuck(Long number) {
        String tmp = String.valueOf(number).substring(1);
        return tmp.contains("0");
    }

    private boolean isSpy(Long number) {
        String tmp = String.valueOf(number);
        Long sum = 0L;
        Long product = 1L;

        for (int i = 0; i < tmp.length(); i++) {
            int tnum = Integer.parseInt(String.valueOf(tmp.charAt(i)));
            sum += tnum;
            product *= tnum;
        }
        return sum == product;
    }

    private String formatNumber(Long number) {
        return NumberFormat.getNumberInstance(Locale.US).format(number);
    }

    private void printIntro() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println();
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameters show how many consecutive numbers are to be processed;");
        System.out.println("- two natural numbers and a property to search for;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
        System.out.println();
    }

    private boolean isPalindromic(Long number) {
        String reverse = "";
        String org = String.valueOf(number);
        int length = org.length();
        for (int i = length - 1; i >= 0; i--) {
            reverse = reverse + org.charAt(i);
        }
        return org.equals(reverse);
    }

    private boolean isGapFul(Long number) {
        String numberString = String.valueOf(number);
        if (numberString.length() < 3) {
            return false;
        } else {
            char first = numberString.charAt(0);
            char last = numberString.charAt(numberString.length() - 1);
            String newNumber = String.valueOf(first) + String.valueOf(last);
            if (number % Integer.parseInt(newNumber) == 0) {
                return true;
            }
        }


        return false;
    }

    private boolean keywordIsValid() {
        return properites.contains(keyword.toUpperCase());
    }

    private boolean checkNumWithKeyword(Long num) {
        switch (keyword.toLowerCase()) {
            case "buzz":
                return isBuzz(num);
            case "duck":
                return isDuck(num);
            case "palindromic":
                return isPalindromic(num);
            case "gapful":
                return isGapFul(num);
            case "spy":
                return isSpy(num);
            case "even":
                return isEven(num);
            case "odd":
                return isOdd(num);
        }
        return false;
    }

    public void start() {
        printIntro();
        while (true) {
            if (!askInput()) {
                continue;
            }
            if (num == 0) {
                break;
            }
            if (num2 == 0) {
                System.out.println("Properties of " + formatNumber(num));
                System.out.println("        buzz: " + isBuzz(num));
                System.out.println("        duck: " + isDuck(num));
                System.out.println(" palindromic: " + isPalindromic(num));
                System.out.println("      gapful: " + isGapFul(num));
                System.out.println("         spy: " + isSpy(num));
                System.out.println("        even: " + isEven(num));
                System.out.println("         odd: " + isOdd(num));
            } else {
                if (keyword == "") {
                    for (Long i = num; i <= num + num2 - 1; i++) {
                        List<String> prop = new ArrayList<>();

                        StringBuilder sb = new StringBuilder("             " + String.valueOf(i) + " is ");
                        if (isBuzz(i)) {
                            prop.add("buzz");
                        }
                        if (isDuck(i)) {
                            prop.add("duck");
                        }
                        if (isPalindromic(i)) {
                            prop.add("palindromic");
                        }
                        if (isGapFul(i)) {
                            prop.add("gapful");
                        }
                        if (isSpy(i)) {
                            prop.add("spy");
                        }
                        if (isEven(i)) {
                            prop.add("even");
                        }
                        if (isOdd(i)) {
                            prop.add("odd");
                        }
                        sb.append(String.join(", ", prop));
                        System.out.println(sb);
                    }
                } else if (keyword != "" && keywordIsValid()) {
                    Long i = num;
                    int total = 0;
                    while (total < num2) {
                        List<String> prop = new ArrayList<>();
                        if (checkNumWithKeyword(i)) {
                            StringBuilder sb = new StringBuilder("             " + String.valueOf(i) + " is ");
                            if (isBuzz(i)) {
                                prop.add("buzz");
                            }
                            if (isDuck(i)) {
                                prop.add("duck");
                            }
                            if (isPalindromic(i)) {
                                prop.add("palindromic");
                            }
                            if (isGapFul(i)) {
                                prop.add("gapful");
                            }
                            if (isSpy(i)) {
                                prop.add("spy");
                            }
                            if (isEven(i)) {
                                prop.add("even");
                            }
                            if (isOdd(i)) {
                                prop.add("odd");
                            }
                            sb.append(String.join(", ", prop));
                            System.out.println(sb);
                            // System.out.print(i + " ");
                            total++;
                        }
                        i++;
                    }


                } else if (!keywordIsValid()) {
                    System.out.println("The property [" + keyword.toUpperCase() + "] is wrong");
                    System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD]");
                    continue;
                }
            }
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
