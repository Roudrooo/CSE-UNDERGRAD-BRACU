import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProbC {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer stkr=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(stkr.nextToken());
        long x=Long.parseLong(stkr.nextToken());

        long[] a=new long[n];
        int[] idx=new int[n];
        stkr=new StringTokenizer(br.readLine());
        for(int i=0;i<n;++i){
            a[i]=Long.parseLong(stkr.nextToken());
            idx[i]=i;
        }
        for(int i=0;i<n-1;++i){
            int minIdx=i;
            for(int j=i+1;j<n;++j){
                if(a[j]<a[minIdx]) minIdx=j;
            }
            long t1=a[i];
            a[i]=a[minIdx];
            a[minIdx]=t1;

            int t2=idx[i];
            idx[i]=idx[minIdx];
            idx[minIdx]=t2;
        }

        for(int i=0;i<n;++i){
            int l=i+1,r=n-1;
            while(l<r){
                if(a[i]+a[l]+a[r]==x){
                    pw.println((idx[i]+1)+" "+(idx[l]+1)+" "+(idx[r]+1));
                    pw.flush();
                    return;
                }else if(a[i]+a[l]+a[r]>x){
                    r--;
                }else{
                    l++;
                }
            }
        }
        pw.println(-1);
        pw.close();
    }
}