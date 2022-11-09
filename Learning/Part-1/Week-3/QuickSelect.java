public class QuickSelect{
    public static void main(String[] args) {
        QuickSelect qs = new QuickSelect();
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k =4;
        System.out.println(qs.select(arr, k));
    } 

    public int select(int[] a, int k)
    {
        int low = 0, high = a.length-1;

        while(low < high)
        {
            int j = partition(a, low, high);
            if(j<k) 
                low = j+1;
            else if(j>k)
                high = j-1;
            else 
                return a[k-1];
        }
        return a[k-1];
    }
    int partition(int[] a , int low, int high)
    {
        int i=low,j = high+1;

        while(true)
        {
            while(a[++i]<a[low])
            {
                if(i==high) break;
            }

            while(a[low]<a[--j])
            {
                if(j==low) break;
            }
            if(i>=j) break;

            swap(a,i, j);
        }
        swap(a,low,j);

        for(int arr:a)
        {
            System.out.print(arr+" ");
        }
        System.out.println();

        return j;
    }

    // private Boolean less(int a, int b)
    // {
    //    return a.compareTo(b) > 1 ;
    // }
    private void swap(int[] a , int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}