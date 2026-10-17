package CSE111LAB01;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the number:");
        int n=input.nextInt();
        if(n%2==0&&n%5==0){
            System.out.println("Multiple of 2 and 5 both");
        }else if(n%2==0){
            System.out.println(n);
        }else if(n%5==0){
            System.out.println(n);
        }else{
            System.out.println("Not a multiple we want");
        }
        input.close();
    }
}
