import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProbF{


    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer stkr=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(stkr.nextToken());

        stkr=new StringTokenizer(br.readLine());
        int x=Integer.parseInt(stkr.nextToken()), y=Integer.parseInt(stkr.nextToken());
        
        int moves=0;
        

        for(int r=x-1;r<=x+1;++r){
            for(int c=y-1;c<=y+1;++c){
                if((r==x&&c==y)||(r<1||r>N||c<1||c>N)) continue;
                moves++;
            }
        }

        pw.println(moves);
        
        for(int r=x-1;r<=x+1;++r){
            for(int c=y-1;c<=y+1;++c){
                if((r==x&&c==y)||(r<1||r>N||c<1||c>N)) continue;
                pw.println(r+" "+c);
            }
        }



        pw.close();

    }
}