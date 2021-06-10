package TestTaskJM;

public class Numbers {
    private String typeOfNum;

    private int amount;

    private String strOfNum;

    public Numbers(String typeOfNum, String strOfNum) {
        this.typeOfNum = typeOfNum;
        this.strOfNum = strOfNum;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
