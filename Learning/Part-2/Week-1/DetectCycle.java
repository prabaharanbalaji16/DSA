import java.util.ArrayList;

public class DetectCycle {
    int V;
    ArrayList<ArrayList<Integer>> adj;
    Boolean visited[];
    Boolean stack[];

    public DetectCycle(int v)
    {
        V=v;
        adj = new ArrayList<ArrayList<Integer>>(V);
        visited = new Boolean[V];
        stack = new Boolean[V];

        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
            visited[i] = false;
            stack[i] = false;
        }
    }

    void addEdge(int u, int v)
    {
        adj.get(u).add(v);
    }

    Boolean isCyclic()
    {
        for(int i=0;i<V;i++)
        {
            if(isCyclic(i))
            {
                return true;
            }
        }
        return false;
    }

    Boolean isCyclic(int i)
    {
        if(stack[i])
        {
            return true;
        }

        if(visited[i])
        {
            return false;
        }

        visited[i] = true;
        stack[i] = true;

        for(int a:adj.get(i))
        {
            if(isCyclic(i))
                return true;
        }
        stack[i] = false;
        return false;

    }

    public static void main(String[] args) {
        DetectCycle detectCycle = new DetectCycle(4);
        
        detectCycle.addEdge(0,1);
        // detectCycle.addEdge(0,2);
        // detectCycle.addEdge(1,2);
        detectCycle.addEdge(2,0);
        // detectCycle.addEdge(2, 3);
        // detectCycle.addEdge(3, 2);

        System.out.println(detectCycle.isCyclic());
    }
}
