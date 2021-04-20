package ru.mai.lab6;

import java.util.ArrayList;
import java.util.Scanner;

public class CitizensDefence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int villageNum = 0;

        if (scan.hasNextInt()) {
            villageNum = scan.nextInt();
        } else {
            System.out.println("ERROR");
            System.exit(-1);
        }
        ArrayList<Integer> listOfVillages = new ArrayList<>();
        listOfVillages.add(0);

        while (scan.hasNextInt() && listOfVillages.size() <= villageNum) {
            listOfVillages.add(scan.nextInt());
        }

        int asylumNum = 0;
        if (scan.hasNextInt()) {
            asylumNum = scan.nextInt();
        } else {
            System.out.println("ERROR");
            System.exit(-1);
        }

        ArrayList<Integer> listOfAsylums = new ArrayList<>();
        listOfAsylums.add(0);

        while (scan.hasNextInt() && listOfAsylums.size() <= asylumNum) {
            listOfAsylums.add(scan.nextInt());
        }

       countNearestAsylum(listOfVillages, listOfAsylums, villageNum);
    }

    public static void countNearestAsylum(ArrayList<Integer> listOfVillages,
                                          ArrayList<Integer> listOfAsylum,
                                          int villagesNums) {
        int[] suitableAsylums = new int[villagesNums];
        for (int i = 1; i <= villagesNums; i++) {
            int minRange = 109;
            for (int j = 1; j < listOfAsylum.size(); j++) {
                if (minRange >= Math.abs(listOfVillages.get(i) - listOfAsylum.get(j))) {
                    minRange = Math.abs(listOfVillages.get(i) - listOfAsylum.get(j));
                    suitableAsylums[i - 1] = j;
                }
            }
        }
        for (int i : suitableAsylums) {
            System.out.print(i + " ");
        }
    }
}
