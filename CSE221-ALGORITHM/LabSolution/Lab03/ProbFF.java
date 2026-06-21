import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class ProbFF {
    public static void main(String[]args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        int n=Integer.parseInt(br.readLine());
        int[]input=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;++i)input[i]=Integer.parseInt(st.nextToken());

        buildBalancedBST(input,pw,0,n-1);
        pw.println();
        pw.close();
    }

    private static void buildBalancedBST(int[]data,PrintWriter out,int start,int end){
        if(start>end)return;
        int rootIndex=(start+end)>>>1;
        out.print(data[rootIndex]+" ");
        if(start!=end){
            buildBalancedBST(data,out,start,rootIndex-1);
            buildBalancedBST(data,out,rootIndex+1,end);
        }
    }
}