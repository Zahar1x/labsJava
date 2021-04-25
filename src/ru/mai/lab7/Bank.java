package ru.mai.lab7;

import java.util.*;
import java.util.regex.Pattern;

public class Bank {
    static Scanner scan = new Scanner(System.in);

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
                if (line.length == 4) {
                    sum = Integer.parseInt(line[3]);
                    clientNameToTransfer = line[2];
                    nameKey = line[1];
                } else if (line.length == 3){
                    sum = Integer.parseInt(line[2]);
                    nameKey = line[1];
                }

                if (str.contains("DEPOSIT")) {
                    clientsDepositMap.put(nameKey, sum);
                } else if (str.contains("WITHDRAW")) {
                    if (clientsDepositMap.containsValue(nameKey)) {
                        int newSum = Integer.parseInt(clientsDepositMap.get(nameKey).toString()) + sum;
                        clientsDepositMap.put(nameKey, newSum);
                    } else {
                        clientsDepositMap.put(nameKey, -sum);
                    }
                } else if (str.contains("BALANCE")) {
                    System.out.println(clientsDepositMap.get(nameKey));
                } else if (str.contains("TRANSFER")) {
                    int clientSum = Integer.parseInt(clientsDepositMap.get(nameKey).toString());
                    clientsDepositMap.put(nameKey, clientSum - sum);
                    if (clientsDepositMap.containsKey(clientNameToTransfer)) {
                        clientsDepositMap.put(clientNameToTransfer, sum +
                                Integer.parseInt(clientsDepositMap.get(clientNameToTransfer).toString()));
                    } else {
                        clientsDepositMap.put(clientNameToTransfer, -sum);
                    }
                } else if (str.contains("INCOME")) {
                    percentOfIncome = Integer.parseInt(line[1]);
                    for (int i = 0; i < clientsDepositMap.size(); i++) {
                        int num = Integer.parseInt(clientsDepositMap.get(i).toString());
                        if (num > 0) {
                            accuralOfPercents(percentOfIncome, num);
                        }
                    }
                }
            }
            System.out.println(list);
            System.out.println("\n\n");
            System.out.println(clientsDepositMap);
        } catch (Exception e) {
            System.out.println(e);
            System.exit(-1);
        }
    }

    public static int accuralOfPercents(int percent, int sumOfAccount) {
        double percentage = percent / 100;
        sumOfAccount += percentage;
        return sumOfAccount;
    }
}
