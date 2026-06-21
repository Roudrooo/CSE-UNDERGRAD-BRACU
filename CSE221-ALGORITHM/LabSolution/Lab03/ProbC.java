import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;
public class ProbC {
    public static long PairsCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer stkr=new StringTokenizer(br.readLine());
        BigInteger a=new BigInteger(stkr.nextToken());
        BigInteger b=new BigInteger(stkr.nextToken());
        BigInteger n=new BigInteger("107");

        
        
        pw.println(a.modPow(b, n));
        pw.close();
    }
}