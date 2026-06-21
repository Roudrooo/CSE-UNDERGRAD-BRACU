import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int start=input.nextInt(),end=input.nextInt(),count=0;
        for(int i=start;i<=end;i++){
            for(int j=1;j<=i;j++){
                if(i%j==0){
                    count++;
                }
            }
        }
        System.out.println(count);
        input.close();
    }
}
