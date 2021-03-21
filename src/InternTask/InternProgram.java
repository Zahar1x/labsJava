package InternTask;

import java.util.Scanner;

public class InternProgram {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Входная строка
        String str = scan.next();

        //Копирование входной строки в массив символов
        char[] ch = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
        }

        System.out.println(str);

        int multiplyer = 1;

        String subStr = "";

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != 91) {
                if (ch[i] > 47 && ch[i] < 58) {
                    multiplyer = Character.getNumericValue(ch[i]);
                } else if (ch[i] != 93) {
                    int j = i;
                    if (j == ch.length - 1) {
                        subStr += Character.toString(ch[j]);
                        print(multiplyer, subStr);
                    } else {
                        while (ch[j] != 91 && ch[j] != 93 && ch[j] > 48 && ch[j] > 57) {
                            subStr += Character.toString(ch[j]);
                            j++;
                        }
                        i = j - 1;
                        print(multiplyer, subStr);
                    }
                    multiplyer = 1;
                    subStr="";
                } 
            }
        }
    }
    public static void print(int multiplyer, String str) {
        for (int k = 1; k <= multiplyer; k++) {
            System.out.print(str);
        }
    }
}
