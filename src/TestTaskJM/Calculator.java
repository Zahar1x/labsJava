package TestTaskJM;

import java.util.Objects;
import java.util.Scanner;

public class Calculator {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            String strOfExpressions = "";

            String pattern = "^\\d+|[IVXLCDM]*\\s+[+\\-/*]\\s+\\d+|[IVXLCDM]*";
            if (scan.hasNext(pattern)) {
                strOfExpressions = scan.nextLine();
            } else {
                CalculatorExceptions exception = new CalculatorExceptions("Неверные данные!");
                throw exception;
            }

            String[] arrOfExpr = strOfExpressions.split(",");

            for (String s : arrOfExpr) {
                String type = checkRomanOrArabic(s);
                String[] arrStr;
                if (s.startsWith(" ")) {
                    arrStr = s.replaceFirst(" ", "").split(" ");
                } else {
                    arrStr = s.split(" ");
                }
                if (Objects.equals(type, "A")) {
                    ArabicNums arabicNumOne = new ArabicNums(type, arrStr[0].replaceAll("\\s+", ""));
                    ArabicNums arabicNumTwo = new ArabicNums(type, arrStr[2].replaceAll("\\s+", ""));
                    checkAmount(arabicNumOne.getAmount());
                    System.out.println(count(arrStr[1], arabicNumOne, arabicNumTwo));
                } else if (Objects.equals(type, "R")) {
                    RomanNums romanNumOne = new RomanNums(type, arrStr[0].replaceAll("\\s+", ""));
                    RomanNums romanNumTwo = new RomanNums(type, arrStr[2].replaceAll("\\s+", ""));
                    checkAmount(romanNumOne.getAmount());
                    System.out.println(convert(count(arrStr[1], romanNumOne, romanNumTwo)));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            System.exit(-1);
        }
    }

    private static void checkAmount(int num) throws CalculatorExceptions {
        if (num > 10) {
            throw new CalculatorExceptions("Число больше 10!");
        }
    }

    private static String convert(int number) {
        String romanOnes = romanDigit(number % 10, "I", "V", "X");
        number /= 10;

        String romanTens = romanDigit(number % 10, "X", "L", "C");
        number /= 10;

        String romanHundreds = romanDigit(number % 10, "C", "D", "M");
        number /= 10;

        String romanThousands = romanDigit(number % 10, "M", "", "");

        String result = romanThousands + romanHundreds + romanTens + romanOnes;
        return result;
    }

    private static String romanDigit(int n, String one, String five, String ten){
        switch (n) {
            case 1: return one;
            case 2: return one + one;
            case 3: return one + one + one;
            case 4: return one + five;
            case 5: return five;
            case 6: return five + one;
            case 7: return five + one + one;
            case 8: return five + one + one + one;
            case 9: return one + ten;
            case 10: return ten;
            default: return "";
        }
    }

    public static String checkRomanOrArabic(String str) {
        String type = "";
        String patternRoman = "^\\s*[IVXLCDM]*\\s+[+\\-/*]\\s+[IVXLCDM]*";
        String patternArabic = "^\\s*\\d+\\s+[+\\-/*]\\s+\\d+|";
        if (str.matches(patternRoman)) {
            type = "R";
        } else if (str.matches(patternArabic)) {
            type = "A";
        }
        return type;
    }

    public static int count(String typeOfOperations, Numbers num1, Numbers num2) {
        return switch (typeOfOperations) {
            case "+" -> num1.getAmount() + num2.getAmount();
            case "-" -> num1.getAmount() - num2.getAmount();
            case "*" -> num1.getAmount() * num2.getAmount();
            case "/" -> num1.getAmount() / num2.getAmount();
            default -> 0;
        };
    }
}
