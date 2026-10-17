import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProbG {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer stkr=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(stkr.nextToken()),q=Integer.parseInt(stkr.nextToken());

        stkr=new StringTokenizer(br.readLine());
        long[] a=new long[n];
        for(int i=0;i<n;++i){
            a[i]=Long.parseLong(stkr.nextToken());
        }
        for(int i=0;i<q;++i){
            stkr=new StringTokenizer(br.readLine());
            long l=Long.parseLong(stkr.nextToken()),r=Long.parseLong(stkr.nextToken());;
            int L=n,R=-1;
            int ll=0,rr=n-1;

            while(ll<=rr){
                int mid=ll+(rr-ll)/2;
                if(a[mid]>=l){
                    L=mid;
                    rr=mid-1;
                }else{
                    ll=mid+1;
                }
            }
            ll=0;rr=n-1;
            while(ll<=rr){
                int mid=ll+(rr-ll)/2;
                if(a[mid]<=r){
                    R=mid;
                    ll=mid+1;
                }else{
                    rr=mid-1;
                }
            }
            int P=Math.max(0,R-L+1);
            
            pw.println(P);
        }
        pw.close();
    }
}
