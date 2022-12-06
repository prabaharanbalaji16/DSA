import java.util.ArrayList;

public class Graph {

    public static void main(String[] args) {
        int V=5;
        Implementation impl = new Implementation(V);
        impl.addEdge(0,1);
        impl.addEdge(0,4);
        impl.addEdge(1,2);
        impl.addEdge(1,3);
        impl.addEdge(1,4);
        impl.addEdge(2,3);
        impl.addEdge(3,4);

        impl.printGraph();
    }

}
class Implementation{
    
    public ArrayList<ArrayList<Integer>> adj;

    public Implementation(int V)
    {
       adj = new ArrayList<ArrayList<Integer>>(V);

       for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
    }

    void addEdge(int u , int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public void printGraph() {
        for(int i =0;i<adj.size();i++)
        {
            System.out.print(i+": ");

            for(int j=0;j<adj.get(i).size();j++)
            {
                System.out.print(adj.get(i).get(j)+" ");
            }
        System.out.println();
        }
    }
}
