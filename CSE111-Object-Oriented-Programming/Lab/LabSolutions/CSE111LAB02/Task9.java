import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        //a
        System.out.println("A:");
        int num_a=input.nextInt();
        int temp=num_a,count_a=0;
        while(temp!=0){
            temp/=10;
            count_a++;
        }
        System.out.println(count_a+" digits");
        //b
        System.out.println("B:");
        int num_b=input.nextInt(),x,count_b=0;
        temp=num_b;
        while(temp!=0){
            temp/=10;
            count_b++;
        }
        temp=num_b;
        while(temp!=0){
            x=temp/(int)Math.pow(10,--count_b);
            System.out.print(x*7+" ");
            temp%=(int)Math.pow(10,count_b);
        }
        System.out.println();
        input.close();
    }
}
