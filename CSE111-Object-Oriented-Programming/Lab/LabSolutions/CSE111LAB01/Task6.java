package CSE111LAB01;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Leap year check for:");
        int year=input.nextInt();
        if(year%4==0&&year%100!=0){
            System.out.println(year+" is a leap year");
        }else if(year%100==0&&year%400==0){
            System.out.println(year+" is a leap year");
        }else{
            System.out.println(year+" is not a leap year");
        }
        input.close();
    }
}
