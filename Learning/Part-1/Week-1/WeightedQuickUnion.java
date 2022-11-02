class WQU{
    public int[] id;
    public int[] sz;
    public WQU(int N){
        id = new int[N];
        sz = new int[N];
        for(int i=0;i<N;i++)
        {
            id[i]=i;
            sz[i]=1;
        }
    }
    private int root(int i)
    {
        while(i!=id[i])
        {
            // id[i] = id[id[i]];           // Path compression
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p,int q)
    {
        return root(p)==root(q);
    }
    public void union(int p , int q)
    {
        int i = root(p);
        int j = root(q);
        if(sz[i]>sz[j])
        {
            id[j] = i;
            sz[i]+=sz[j];
        }
        else
        {
            id[i] = j;
            sz[j]+=sz[i];
        }
        for(int I:id)
        {
            System.out.print(I+" ");
        }
        System.out.println();
    }
}
public class WeightedQuickUnion {
    public static void main(String[] args) {
        WQU wqu = new WQU(10);
        wqu.union(1, 6);
        wqu.union(1, 7);
        wqu.union(2, 4);
        wqu.union(2, 5);
        wqu.union(2, 8);
        wqu.union(7, 6);
        System.out.println(wqu.connected(3, 1));
        System.out.println(wqu.connected(6, 7));
    }
}

// The tree won't be too long because all the nodes are somehow nearer to the root.
// Find Operation will be fast.

// To imporve the performance of the Weighted Quick Union we add path compression to it.