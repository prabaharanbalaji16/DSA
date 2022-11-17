public class MinHeap{
    Comparable pq[];
    int size;

    public MinHeap(int capacity)
    {
        pq = new Comparable[capacity];
        size = 0;
    }

    void insert(Comparable val)
    {
        size=size+1;
        int index = size;
        pq[index] = val;

        while(index >1)
        {
            if(less(index/2,index))
            {
                swap(index/2,index);
            }
            else return;
        }

    }
    void remove()
    {
        pq[1] = pq[size--];
        int i = 1;

        while(i<size)
        {
            int left = 2*i;
            int right = 2*i+1;
            if(left < size && less(i,left))
            {
                swap(i,left);
                i=left;
            }
            else if(right < size && less(i,right))
            {
                swap(i,right);
                i=right;
            } 
            else return;
        }
    }
    boolean less(int i, int j)
    {
        return pq[i].compareTo(pq[j]) > 0;
    }
    void print()
    {
        for(int i=1;i<=size;i++)
        {
            System.out.print(pq[i]+" ");
        }
        System.out.println();
        
    }

    void swap(int i, int j)
    {
        Comparable temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;   
    }
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(50);
        minHeap.insert(55);
        minHeap.insert(53);
        minHeap.insert(52);
        minHeap.insert(54);
        minHeap.print();
        minHeap.remove();
        minHeap.remove();
        minHeap.remove();
        minHeap.print();
    }
}