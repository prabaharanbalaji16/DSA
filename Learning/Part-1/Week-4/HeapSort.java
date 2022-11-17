public class HeapSort{
    static void heapSort(int arr[] , int n)
    {
        int size = n;
        while(size > 1)
        {
            int temp = arr[size];
            arr[size] = arr[1];
            arr[1] = temp;

            size--;

            heapify(arr,size,1);
        }
    }

    static void heapify(int[] arr, int n, int i)
    {
        int largest = i;
        int left = 2*i;
        int right = 2*i+1;

        if(left <= n && arr[largest] < arr[left])
        {
            largest = left;
        }
        else if(right <= n && arr[largest] < arr[right])
        {
            largest = right;
        }

        if(largest!=i)
        {
            int a = arr[i];
            arr[i] = arr[largest];
            arr[largest] = a;

            heapify(arr, n, i);
        }

    }
    public static void main(String[] args) {
        int arr[] = {-1,54,53,55,52,50};
        int n = 5;

        for(int i=n/2;i>0;i--)
        {
            heapify(arr, n, i);
        }
        
        System.out.println("Print after Heapify");
        for(int i=1;i<=n;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        heapSort(arr, n);

        System.out.println("Print after Sort");
        for(int i=1;i<=n;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}