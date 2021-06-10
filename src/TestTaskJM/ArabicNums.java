package TestTaskJM;

public class ArabicNums extends Numbers{
    public ArabicNums(String typeOfNum, String strOfNum)  {
        super(typeOfNum, strOfNum);
        setNum(strOfNum);
    }

    public void setNum (String str) {
        int num = Integer.parseInt(str);
        super.setAmount(num);
    }
}
