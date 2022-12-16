import java.util.ArrayList;

public class DirectedGraph {

    int V;
    ArrayList<ArrayList<Integer>> adj;
    public DirectedGraph(int v)
    {
        V = v;
        adj = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(i,new ArrayList<>());
        }
    }

    void addEdge(int u, int v)
    {
        adj.get(u).add(v);
    }

    void print()
    {
       for(int i=0;i<V;i++)
       {
        System.out.print(i+"->");
        for(int a:adj.get(i))
        {
            System.out.print(a+", ");
        }
        System.out.println();
       }
    }

    public static void main(String[] args) {
        DirectedGraph diGraph = new DirectedGraph(5);
        diGraph.addEdge(0, 1);
        diGraph.addEdge(0, 4);
        diGraph.addEdge(1, 4);
        diGraph.addEdge(1,0);
        diGraph.addEdge(2, 3);
        diGraph.addEdge(3, 1);
        diGraph.addEdge(3,4);
        diGraph.addEdge(4, 0);
        diGraph.addEdge(4, 1);

        diGraph.print();
    }
}
