// Analysis of Alogorithm

class Sum{
    public int find(int[] a)
    {
        int count = 0;
        int N = a.length;
        for(int i=0;i<N;i++)
        {
            for(int j=i+1;j<N;j++)
            {
                for(int k=j+1;k<N;k++)
                {
                    if(a[i]+a[j]+a[k]==0)
                        count+=1;
                }
            }
        }
        return count;
    }
}

public class ThreeSum {
    public static void main(String[] args) {
        Sum sum = new Sum();
        int[] a = {30,-40,10,-20,10};
        int result = sum.find(a);
        System.out.println(result);

    }
}
