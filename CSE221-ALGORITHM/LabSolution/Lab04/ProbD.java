import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProbD{


    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer stkr=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(stkr.nextToken());
        int M=Integer.parseInt(stkr.nextToken());

        stkr=new StringTokenizer(br.readLine());
        int[] vertex=new int[N+1];

        int tempM=M;

        while(tempM-->0){
            int vrtx=Integer.parseInt(stkr.nextToken());
            vertex[vrtx]++;
        }

        stkr=new StringTokenizer(br.readLine());

        tempM=M;

        while(tempM-->0){
            int vrtx=Integer.parseInt(stkr.nextToken());
            vertex[vrtx]++;
        }
        int count=0;
        for(int i=1;i<N+1;++i){
            if(vertex[i]%2!=0) count++;
            if(count>2){
                pw.println("NO");
                pw.flush();
                return;
            }
        }
        pw.println("YES");
        pw.close();
    }
}