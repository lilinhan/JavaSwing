package test;

/**
 * Created by lewin on 15-4-9.
 */
public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int year , int month , int day)  {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void printDate()  {
        System.out.println("入职时间:" +year+"年"+month+"月"+day+"日");
    }
}
