import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class ProbC2 {
    public static long PairsCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer stkr=new StringTokenizer(br.readLine());

        long a=Long.parseLong(stkr.nextToken());
        long b=Long.parseLong(stkr.nextToken());
        long res=FastModExpo(a, b, 107);

        
        pw.println(res);
        pw.close();
    }
    private static long FastModExpo(long a, long b, long m){
        if(b<=0) return 1;
        if(b%2==1){
            return ((a%m)*FastModExpo(a*a%m,b/2,m))%m;
        }
        return FastModExpo(a*a%107,b/2,m);
    }

}