@SuppressWarnings("unchecked")
public class SelectionSort{
    public static void main(String[] args) {
        Comparable[] a = {3,2,6,4,1,8,9};
        sort(a);

        for(Comparable v:a)
        {
            System.out.println(v);
        }
    }

    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for(int i=0;i<N;i++)
        {
            int min = i;
            for(int j=i+1;j<N;j++)
            {
                if(less(a[j],a[min]))
                    min = j;
                swap(a,i,min);
            }
        }
    }

    public static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w)<0;
    }

    public static void swap(Comparable[] a, int i, int m)
    {
        Comparable temp = a[i];
        a[i] = a[m];
        a[m] = temp;
    }
}

// Quadratic Time