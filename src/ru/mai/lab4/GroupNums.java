package ru.mai.lab4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupNums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int arrSize = 0;
        if (scan.hasNextInt()) {
           arrSize = scan.nextInt();
        } else {
            System.exit(-1);
        }

        String[] arrOfNums = new String[arrSize];

        for (int i = 0; i < arrSize; i++) {
            arrOfNums[i] = scan.nextLine();
        }

        for (int i = 0; i < arrSize; i++) {
            if (arrOfNums[i] != "") {
                checkGroupNum(arrOfNums[i]);
            } else {
                System.exit(-1);
            }
        }



    }
    public static void checkGroupNum(String groupNum) {
        Pattern p = Pattern.compile("^М3О-[0-9]{3}Б-1[4-9]{1}$");
        Matcher m = p.matcher(groupNum);
        if (m.matches()) {
            System.out.println(groupNum);
        }
    }
}
