import java.util.Scanner;

public class ProbE {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int N=input.nextInt();
        int[] arr=new int[N];
        for(int i=0;i<N;++i){
            arr[i]=input.nextInt();
        }
        if(N>2){
            while(true){
                int check=0;
                for(int i=0;i<N-2;++i){
                    if(arr[i]>arr[i+2]){
                        check=1;
                        int temp=arr[i];
                        arr[i]=arr[i+2];
                        arr[i+2]=temp;
                    }
                }
                if(check==0) break;
            }
        }
        boolean check=true;
        for(int i=0;i<N-1;++i){
            if(arr[i]>arr[i+1]){
                check=false;
                break;
            }
        }
        if(check) System.out.println("YES");
        else System.out.println("NO");
        input.close();
    }
}