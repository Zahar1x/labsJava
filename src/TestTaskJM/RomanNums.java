package TestTaskJM;

public class RomanNums extends Numbers {
    public RomanNums(String typeOfNum, String strOfNum) {
        super(typeOfNum, strOfNum);
        setNum(strOfNum);
    }

    public void setNum(String str) {
        super.setAmount(count(str));
    }

    private int count(String str) {
        return switch (str) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> 0;
        };
    }

}
