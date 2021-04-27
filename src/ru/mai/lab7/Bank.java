package ru.mai.lab7;

import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Pattern;

public class Bank {
    static Scanner scan = new Scanner(System.in);
    static final int THREE = 3;
    static final int TWO = 2;
    static final int ONE = 1;
    static final int FOUR = 4;
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("[DEPOSIT, WITHDRAW, BALANCE, TRANSFER, INCOME]\\s*.+");
        while (scan.hasNext(pattern)) {
            list.add(scan.nextLine());
        }

        craeateUser(list);
    }

    public static void craeateUser(ArrayList<String> list) {
        try {
            HashMap clientsDepositMap = new HashMap();
            for (String str : list) {
                String[] line = str.split(" ");
                int sum = 0;
                String clientNameToTransfer = "";
                int percentOfIncome = 0;
                String nameKey = "";
                if (line.length == FOUR) {
                    sum = Integer.parseInt(line[THREE]);
                    clientNameToTransfer = line[TWO];
                    nameKey = line[ONE];
                } else if (line.length == THREE) {
                    sum = Integer.parseInt(line[TWO]);
                    nameKey = line[ONE];
                }

                if (str.contains("DEPOSIT")) {
                    if (!clientsDepositMap.containsKey(nameKey)) {
                        clientsDepositMap.put(nameKey, sum);
                    } else {
                        clientsDepositMap.put(nameKey,
                                Integer.parseInt(clientsDepositMap.get(nameKey).toString()) + sum);
                    }
                } else if (str.contains("WITHDRAW")) {
                    withdrawMethod(clientsDepositMap, sum, nameKey);
                } else if (str.contains("BALANCE")) {
                    nameKey = line[1];
                    balanceMethod(clientsDepositMap, nameKey);
                } else if (str.contains("TRANSFER")) {
                    transferMethod(clientsDepositMap, sum, clientNameToTransfer, nameKey);
                } else if (str.contains("INCOME")) {
                    percentOfIncome = Integer.parseInt(line[ONE]);
                    Set clientsSet = clientsDepositMap.keySet();
                    Iterator<String> iter = clientsSet.iterator();
                    while (iter.hasNext()) {
                        String nextName = iter.next();
                        int num = Integer.parseInt(clientsDepositMap.get(nextName).toString());
                        if (num > 0) {
                            clientsDepositMap.put(nextName, accuralOfPercents(percentOfIncome, num));
                        }
                    }
                } else {
                    System.out.println("Invalid Data!");
                    System.exit(-1);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            System.exit(-1);
        }
    }

    public static void transferMethod(HashMap clientsDepositMap, int sum, String clientNameToTransfer, String nameKey) {
        if (!clientsDepositMap.containsKey(nameKey)) {
            clientsDepositMap.put(nameKey, 0);
        }
        int clientSum = Integer.parseInt(clientsDepositMap.get(nameKey).toString());
        clientsDepositMap.put(nameKey, clientSum - sum);
        if (clientsDepositMap.containsKey(clientNameToTransfer)) {
            clientsDepositMap.put(clientNameToTransfer, sum
                    + Integer.parseInt(clientsDepositMap.get(clientNameToTransfer).toString()));
        } else {
            clientsDepositMap.put(clientNameToTransfer, sum);
        }
    }

    public static void balanceMethod(HashMap clientsDepositMap, String nameKey) {
        if (clientsDepositMap.containsKey(nameKey)) {
            System.out.println(clientsDepositMap.get(nameKey));
        } else {
            System.out.println("ERROR");
        }
    }

    public static void withdrawMethod(HashMap clientsDepositMap, int sum, String nameKey) {
        if (clientsDepositMap.containsKey(nameKey)) {
            int newSum = Integer.parseInt(clientsDepositMap.get(nameKey).toString()) - sum;
            clientsDepositMap.put(nameKey, newSum);
        } else {
            clientsDepositMap.put(nameKey, -sum);
        }
    }

    public static int accuralOfPercents(int percent, int sumOfAccount) {
        final double hundred = 100.0;
        double percentage = percent / hundred;
        sumOfAccount += sumOfAccount * percentage;
        return sumOfAccount;
    }
}
