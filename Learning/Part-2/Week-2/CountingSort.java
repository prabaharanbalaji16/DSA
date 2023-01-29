public class CountingSort{
    public static void main(String[] args) {
        CountingSort counting = new CountingSort();
        int[] arr = new int[]{2,1,1,0,2,5,4,0,2,8,7,7,9,2,0,1,9};
        int range = 9;
        counting.sort(arr,range);
    }

    void sort(int[] arr, int range)
    {
        int[] count = new int[range+1];

        for(int i=0;i<arr.length;i++)
        {
            count[arr[i]]++;
        }

        for(int i=1;i<=range;i++)
        {
            count[i] = count[i-1]+count[i];
        }

        int[] aux  = new int[arr.length];
        
        for(int i=arr.length-1;i>=0;i--)
        {
            aux[--count[arr[i]]]  = arr[i];

            // System.out.println(aux[i]);
        }

        for(int c:aux)
        {
            System.out.print(c+" ");
        }
    }
}