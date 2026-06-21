import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProbH{


    private static class Edge{
        int source, destination, weight;
        Edge next;
        private Edge(int source, int destination){
            this.source=source;
            this.destination=destination;
            this.weight=1;
        }
    }
    
    

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer stkr=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(stkr.nextToken());
        int Q=Integer.parseInt(stkr.nextToken());


        Edge[] UndrcGrph=new Edge[N+1];
        
        for(int i=1;i<=N;++i){
            for(int j=i+1;j<=N;++j){
                if(gcd(i, j)!=1) continue;
                Edge newEdge=new Edge(i, j);

                if(UndrcGrph[i]==null) UndrcGrph[i]=newEdge;
                else{
                    Edge temp=UndrcGrph[i];
                    while(temp.next!=null){
                        temp=temp.next;
                    }
                    temp.next=newEdge;
                }
                Edge revEdge=new Edge(j, i);
                if(UndrcGrph[j]==null||UndrcGrph[j].destination>i){
                    revEdge.next=UndrcGrph[j];
                    UndrcGrph[j]=revEdge;
                }else{
                    Edge temp=UndrcGrph[j];
                    while(temp.next!=null&&temp.next.destination<i){
                        temp=temp.next;
                    }
                    revEdge.next=temp.next;
                    temp.next=revEdge;
                }
            }
        }

        while(Q-->0){
            stkr=new StringTokenizer(br.readLine());
            int X=Integer.parseInt(stkr.nextToken()), K=Integer.parseInt(stkr.nextToken());
            Edge temp=UndrcGrph[X];
            while(K-->1){
                if(temp==null) break;
                temp=temp.next;
            }
            if(temp==null) pw.println(-1);
            else pw.println(temp.destination);
        }

        pw.close();

    }

    private static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}