public class UnorderedPriorityQueue<Key extends Comparable<Key>>{

    private Key[] pq;
    private int N;

    public UnorderedPriorityQueue(int capacity)
    {
        pq =(Key[]) new Comparable[capacity];
        N=0;
    }

    public boolean isEmpty()
    {
        return N ==0;
    }

    public void insert(Key x)
    {
        pq[N++] = x;
    }

    public Key delMax()
    {
        int max = 0;
        for(int i=1;i<N;i++)
        {
            if(pq[max].compareTo(pq[i]) <0 ) max = i;
        }

        Key swap = pq[max];
        pq[max] = pq[N-1];
        pq[N-1] = swap;

        return pq[--N];
    }

    public static void main(String[] args) {
        UnorderedPriorityQueue<Integer> pq = new UnorderedPriorityQueue<Integer>(10);
        pq.insert(4);
        pq.insert(8);
        pq.insert(1);
        pq.insert(10);
        while (!pq.isEmpty())
            System.out.println(pq.delMax());
    }
}