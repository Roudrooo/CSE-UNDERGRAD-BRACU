package CSE111LAB01;

public class Task2 {
    public static void main(String[] args) {
        int a=10,b=5;

        //By creating 3rd variable
        int temp=a;
        a=b;
        b=temp;
        System.out.println(a+"\n"+b);

        //Resetting the values of a and b
        a=10;
        b=5;

        //Without creating any other variables
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println(a+"\n"+b);
    }
}