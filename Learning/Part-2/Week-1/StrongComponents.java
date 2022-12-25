import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
@SuppressWarnings("unchecked")
public class StrongComponents{
    int V;
    LinkedList<Integer> adj[];
    Boolean visited[] ;

    Stack stack = new Stack<>();
    public StrongComponents(int v)
    {
        V=v;
        adj = new LinkedList[V];
        visited = new Boolean[V];

        for(int i=0;i<V;i++)
        {
            adj[i] = new LinkedList<>();
            visited[i] =false;
        }
    }

    void addEdge(int u, int w)
    {
        adj[u].add(w);
    }

    void print()
    {
        for(int v=0;v<V;v++)
        {
            if(visited[v]==false)
            {
                fillOrder(v);
            }
        }

        StrongComponents strongComp = getTranspose();

        for(int i=0;i<V;i++)
        {
            visited[i]=false;
        }

        while(!stack.empty())
        {
            int v = (int)stack.pop();

            if(!visited[v])
            {
                strongComp.dfs(v);
                System.out.println();
            }
        }
    }

    void fillOrder(int v)
    {
        visited[v] = true;

        Iterator<Integer> i = adj[v].iterator();

        while(i.hasNext())
        {
            int n = i.next();
            if(!visited[n])
            {
                fillOrder(n);
            }
        }

        stack.push(new Integer(v));
    }

    void dfs(int v)
    {
        visited[v] =true;

        System.out.print(v+" ");
        int n;
        Iterator<Integer> i = adj[v].iterator();
        while(i.hasNext())
        {
            n = i.next();
            if(!visited[n])
                dfs(n);
        }
    }

    StrongComponents getTranspose()
    {
        StrongComponents strongComponents = new StrongComponents(V);
        for(int v=0;v<V;v++)
        {
            Iterator<Integer> i = adj[v].iterator();
            while(i.hasNext())
            {
                strongComponents.adj[i.next()].add(v);
            }
        }
        return strongComponents;
    }
    public static void main(String[] args) {
        StrongComponents sc = new StrongComponents(5);
        
        sc.addEdge(1, 0);
        sc.addEdge(0,2);
        sc.addEdge(2,1);
        sc.addEdge(0, 3);
        sc.addEdge(3, 4);
        sc.print();
    }

}