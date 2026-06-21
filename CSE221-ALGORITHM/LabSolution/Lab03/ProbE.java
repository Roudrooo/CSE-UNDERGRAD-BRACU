import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProbE {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        long t=Long.parseLong(br.readLine());
        for(int i=0;i<t;++i){
            StringTokenizer stkr=new StringTokenizer(br.readLine());
            long a=Long.parseLong(stkr.nextToken());
            long n=Long.parseLong(stkr.nextToken());
            long m=Long.parseLong(stkr.nextToken());
            long res=fastSeries(a,n,m);
            pw.println(res);
        }
        pw.close();
    }

    private static long fastSeries(long a,long n,long m){
        if(n==1)return a%m;
        long half=fastSeries(a,n/2,m);
        long power=fastPow(a,n/2,m);
        long result=(half+(half*power)%m)%m;
        if(n%2==1)result=(result+fastPow(a,n,m))%m;
        return result;
    }

    private static long fastPow(long a,long b,long m){
        long result=1;
        a%=m;
        while(b>0){
            if((b&1)==1)result=(result*a)%m;
            a=(a*a)%m;
            b>>=1;
        }
        return result;
    }
}