package test;

/**
 * Created by lewin on 15-4-9.
 */
public class Employee {
    private String name;
    private int salary;
    private MyDate data = new MyDate(2015,3,23);

    public Employee(String name , int salary) {
        this.name = name;
        this.salary = salary;
    }
    public static void main(String[] args) {
        Employee e = new Employee("zhangsan" , 34);
        System.out.println("姓名:" + e.name);
        System.out.println("薪水:" + e.salary);

        e.data.printDate();
    }
}
