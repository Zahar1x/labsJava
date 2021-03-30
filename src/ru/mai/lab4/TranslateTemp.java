package ru.mai.lab4;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TranslateTemp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder str = new StringBuilder(scan.nextLine());

        final String tempRegex = "\\d{1,}\\.?\\d* ?F";

        Pattern pattern = Pattern.compile(tempRegex);
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            String tempStr = str.substring(matcher.start(), matcher.end() - 1);

            if (tempStr.contains(".")) {
                printTemperature(tempStr, str, matcher);
            } else {
                printTemperature(tempStr, str, matcher);
            }
        }
    }
    public static void printTemperature(String tempStr, StringBuilder str, Matcher matcher) {
        double tempInF = Double.parseDouble(tempStr.toString());

        final int thirtyTwo = 32;
        final int five = 5;
        final int nine = 9;

        double tempInC = (tempInF - thirtyTwo) * five / nine;

        String tempString = String.format(Locale.ROOT, "%.2f", tempInC);

        str.replace(matcher.start(), matcher.end(), tempString + "C");

        System.out.println(str);
    }
}
