
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class ProbA {
    public static PrintWriter pw=new PrintWriter(System.out);
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stkr=new StringTokenizer(br.readLine());

        ArrayList<Vertex> Graph=new ArrayList<>();

        

        int N=Integer.parseInt(stkr.nextToken());
        int M=Integer.parseInt(stkr.nextToken());
        int S=Integer.parseInt(stkr.nextToken());
        int D=Integer.parseInt(stkr.nextToken());

        Graph.add(null);
        for(int i=1;i<=N;++i){
            Graph.add(new Vertex(i));
        }

        int[] u=new int[M+1];
        int[] v=new int[M+1];
        int[] w=new int[M+1];

        stkr=new StringTokenizer(br.readLine());
        for(int i=1;i<=M;++i) u[i]=Integer.parseInt(stkr.nextToken());
        
        stkr=new StringTokenizer(br.readLine());
        for(int i=1;i<=M;++i) v[i]=Integer.parseInt(stkr.nextToken());
        
        stkr=new StringTokenizer(br.readLine());
        for(int i=1;i<=M;++i) w[i]=Integer.parseInt(stkr.nextToken());


        for(int i=1;i<=M;++i){
            Graph.get(u[i]).neighbor.add(new Edge(Graph.get(v[i]), w[i]));
        }



        int SmallestCost=Dijkstra(Graph, Graph.get(S), Graph.get(D));

        if(SmallestCost==-1){
            pw.println(SmallestCost);
        }else{
            pw.println(SmallestCost);
            printPath(Graph.get(D));
            pw.println();
        }
        

        
        pw.flush();


    }

    private static void printPath(Vertex V){
        if(V.parent!=null){
            printPath(V.parent);
        }
        pw.print(V.id+" ");
    }

    private static int Dijkstra(ArrayList<Vertex> Graph, Vertex source, Vertex destination){
        source.distance=0;
        PriorityQueue<Vertex> priorityQueue=new PriorityQueue<>(Comparator.comparing(v->v.distance));

        priorityQueue.add(source);

        boolean found=false;
        while(!priorityQueue.isEmpty()){
            Vertex u=priorityQueue.poll();

            if(u==destination){
                return u.distance;
            }

            for(Edge edge : u.neighbor){
                Vertex v=edge.destination;

                if(u.distance+edge.weight<v.distance){
                    v.distance=u.distance+edge.weight;
                    v.parent=u;

                    priorityQueue.add(v);
                }
            }
        }
        return destination.distance==Integer.MAX_VALUE? -1 : destination.distance;
    }
}

class Vertex{
    int id;
    int distance=Integer.MAX_VALUE;
    Vertex parent;
    ArrayList<Edge> neighbor=new ArrayList<>();
    Vertex(int id){
        this.id=id;
    }
}

class Edge{
    Vertex destination;
    int weight;
    Edge(Vertex destination, int weight){
        this.destination=destination;
        this.weight=weight;
    }
}
