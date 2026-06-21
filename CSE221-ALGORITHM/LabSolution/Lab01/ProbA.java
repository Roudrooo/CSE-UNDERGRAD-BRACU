import java.util.Scanner;

public class ProbA {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int T=input.nextInt();
        for(int i=1;i<=T;++i){
            int N=input.nextInt();
            if(N%2==0) System.out.println(N+" is an Even number.");
            else System.out.println(N+" is an Odd number.");
        }
        input.close();
    }
}