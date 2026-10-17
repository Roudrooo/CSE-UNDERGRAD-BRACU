package CSE111LAB01;
import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Your CGPA:");
        float cg=input.nextFloat();
        System.out.print("Completed credits:");
        int credit=input.nextInt();
        if(credit>=30){
            if(3.80<=cg&&cg<=3.89){
                System.out.println("The student is eligible for a waiver of 25 percent");
            }else if(3.90<=cg&&cg<=3.94){
                System.out.println("The student is eligible for a waiver of 50 percent");
            }else if(3.95<=cg&&cg<=3.99){
                System.out.println("The student is eligible for a waiver of 75 percent");
            }else if(cg==4.00){
                System.out.println("The student is eligible for a waiver of 100 percent");
            }else{
                System.out.println("The student is not eligible for a waiver");
            }
        }else{
            System.out.println("The student is not eligible for a waiver");
        }
        input.close();
    }
}
