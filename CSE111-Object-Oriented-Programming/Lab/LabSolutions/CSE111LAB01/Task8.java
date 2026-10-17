package CSE111LAB01;
import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter your student id:");
        int std_id=input.nextInt();
        int year=std_id/1000000;
        int session=(std_id/100000)%10;
        String s=new String();
        if(session==1){
            s="Spring";
        }else if(session==2){
            s="Fall";
        }else if(session==3){
            s="Summer";
        }
        System.out.println("Student Joined BRAC in "+s+" "+year);
        input.close();
    }
}
