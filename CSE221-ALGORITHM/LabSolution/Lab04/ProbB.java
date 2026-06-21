import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProbB {
    private static class Edge{
        int source, destination, weight;
        Edge next;
        private Edge(int source, int destination, int weight){
            this.source=source;
            this.destination=destination;
            this.weight=weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer stkr=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(stkr.nextToken());
        int M=Integer.parseInt(stkr.nextToken());

        Edge[] DrcWtd=new Edge[N+1];

        int[] u=new int[M];
        int[] v=new int[M];
        int[] w=new int[M];


        stkr=new StringTokenizer(br.readLine());
        for(int i=0;i<M;++i){
            u[i]=Integer.parseInt(stkr.nextToken());
        }
        stkr=new StringTokenizer(br.readLine());
        for(int i=0;i<M;++i){
            v[i]=Integer.parseInt(stkr.nextToken());
        }
        stkr=new StringTokenizer(br.readLine());
        for(int i=0;i<M;++i){
            w[i]=Integer.parseInt(stkr.nextToken());
        }
        
        for(int i=0;i<M;++i){
            int source=u[i];
            int destination=v[i];
            int weight=w[i];
            Edge newEdge=new Edge(source, destination, weight);
        
            if(DrcWtd[source]==null){
                DrcWtd[source]=newEdge;
            }else{
                Edge temp=DrcWtd[source];
                while(temp.next!=null){
                    temp=temp.next;
                }
                temp.next=newEdge;
            }
        }

        for(int i=1;i<N+1;++i){
            pw.print(i+": ");
            Edge temp=DrcWtd[i];
            while(temp!=null){
                pw.print("("+temp.destination+","+temp.weight+") ");
                temp=temp.next;
            }
            pw.println();
        }
        pw.close();
    }
}