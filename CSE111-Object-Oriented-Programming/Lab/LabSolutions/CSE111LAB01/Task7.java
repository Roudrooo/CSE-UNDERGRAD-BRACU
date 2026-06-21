package CSE111LAB01;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the number:");
        int n=input.nextInt();
        if(n%5==0&&n%7==0){
            System.out.println("Divisible by Both");
        }else if(n%5==0){
            System.out.println("Invalid: Divisible by 5 Only");
        }else if(n%7==0){
            System.out.println("Invalid: Divisible by 7 Only");
        }else{
            System.out.println("No");
        }
        input.close();
    }
}
