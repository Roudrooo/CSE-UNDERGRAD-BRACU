import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProbA{
    public static void main(String[] args) throws IOException{

        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(in);
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer stkr=new StringTokenizer(br.readLine());

        
        int N=Integer.parseInt(stkr.nextToken());
        long S=Long.parseLong(stkr.nextToken());

        stkr=new StringTokenizer(br.readLine());
        
        long[] arr=new long[N];
        for(int i=0;i<N;++i){
            arr[i]=Long.parseLong(stkr.nextToken());
        }

        for(int i=0;i<N-1;++i){
            int l=i+1,r=N-1;
            long rem=S-arr[i];
            while(!(l>r)){
                int mid=(r+l)/2;
                if(i!=mid && rem==arr[mid]){
                    pw.println((i+1)+" "+(mid+1));
                    pw.flush();
                    return;
                }else if(rem>arr[mid]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        pw.println(-1);
        pw.close();
    }
}