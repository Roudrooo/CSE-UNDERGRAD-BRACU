
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class ProbC {
    public static PrintWriter pw=new PrintWriter(System.out);
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stkr=new StringTokenizer(br.readLine());

        ArrayList<Vertex> Graph=new ArrayList<>();

        

        int N=Integer.parseInt(stkr.nextToken());
        int M=Integer.parseInt(stkr.nextToken());

        Graph.add(null);
        for(int i=1;i<=N;++i){
            Graph.add(new Vertex(i));
        }

        for (int i=0;i<M;i++){
            stkr=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(stkr.nextToken());
            int v=Integer.parseInt(stkr.nextToken());
            int w=Integer.parseInt(stkr.nextToken());

            Graph.get(u).neighbor.add(new Edge(Graph.get(v), w));
            Graph.get(v).neighbor.add(new Edge(Graph.get(u), w));
        }



        Dijkstra(Graph, Graph.get(1));
        
        for(int i=1;i<=N;++i){
            Vertex v=Graph.get(i);
            if(v.distance==Integer.MAX_VALUE){
                pw.print(-1+" ");
            }else{
                pw.print(v.distance+" ");
            }
        }
        pw.println();

        
        pw.flush();


    }

    private static void Dijkstra(ArrayList<Vertex> Graph, Vertex source){
        source.distance=0;
        PriorityQueue<Vertex> priorityQueue=new PriorityQueue<>(Comparator.comparing(v->v.distance));

        priorityQueue.add(source);


        while(!priorityQueue.isEmpty()){
            Vertex u=priorityQueue.poll();


            for(Edge edge : u.neighbor){
                Vertex v=edge.destination;

                int danger=Math.max(u.distance, edge.weight);

                if(danger<v.distance){
                    v.distance=danger;
                    v.parent=u;

                    priorityQueue.add(v);
                }
            }
        }
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
