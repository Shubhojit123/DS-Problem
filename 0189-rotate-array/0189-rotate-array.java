class Solution {
    public void rev(int a[],int l , int h)
    {
        while(l<h)
        {
            int temp = a[l];
            a[l]=a[h];
            a[h]=temp;
            l++;
            h--;
        }
    }
    public void rotate(int[] a, int k) {
        
        int n = a.length-1;
        k%=a.length;
       rev(a,0,n);
       rev(a,0,k-1);
       rev(a,k,n);

    }
}