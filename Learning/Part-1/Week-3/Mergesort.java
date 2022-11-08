public class Mergesort{
    public static void main(String[] args) {
        int[] arr = {38,27,43,3,9,82,10};
        sort(arr,0,arr.length-1);

        for(int i:arr)
        {
            System.out.print(i+" ");
        }
    }

    public static void sort(int arr[],int low,int high)
    {
        int mid = (high+low)/2;

        if(low >= high)
        {
            return;
        }
        
        sort(arr,low,mid);
        sort(arr,mid+1,high);

        merge(arr,low,mid,high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int len1 = mid-low+1;
        int len2 = high-mid;
        int[] lArr = new int[len1];
        int[] rArr = new int[len2]; 
        int k = low;
        for(int i=0;i<len1;i++)
        {
            lArr[i] = arr[k++];
            // k++;
        }

        k=mid+1;
        for(int i=0;i<len2;i++)
        {
            rArr[i] = arr[k++];
            // k++;
        }

        int index1 = 0, index2=0;
        k = low;
        while(index1<len1 && index2<len2)
        {
            if(lArr[index1] < rArr[index2])
            {
                arr[k++] = lArr[index1++];
            }
            else
            {
                arr[k++] = rArr[index2++];
            }
        }

        while(index1<len1)
        {
            arr[k++] = lArr[index1++];
        }

        while(index2<len2)
        {
            arr[k++]=rArr[index2++];
        }
    }
}