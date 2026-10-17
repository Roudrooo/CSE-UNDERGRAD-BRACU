public class Edge{
    int src;
    int des;
    int weight;
    Edge next;
    public Edge(int src,int des){
        this.src=src;
        this.des=des;
        weight=1;
    }
    public Edge(int src,int des,int weight){
        this.src=src;
        this.des=des;
        this.weight=weight;
    }
}
