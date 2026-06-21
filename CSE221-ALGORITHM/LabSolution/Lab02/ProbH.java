import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProbH {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer stkr=new StringTokenizer(br.readLine());
        int T=Integer.parseInt(stkr.nextToken());

        for(int i=0;i<T;++i){
            stkr=new StringTokenizer(br.readLine());
            long k=Long.parseLong(stkr.nextToken()),x=Long.parseLong(stkr.nextToken());

            pw.println(k+((k-1)/(x-1)));
        }
        pw.close();

    }
}
