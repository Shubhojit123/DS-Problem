class Solution {
    public void sortColors(int[] a) {
      
        int l=0;
        int h=a.length-1;
        int mid = 0;
        
        while(mid<=h)
        {
            if(a[mid]==0)
            {
                int temp = a[mid];
                 a[mid]=a[l];
                a[l]=temp;
                l++;
                mid++;
            }
            else if(a[mid]==1)
            {
                mid++;
            }
            else if (a[mid]==2)
            {
                int temp = a[mid];
                a[mid]=a[h];
                a[h]=temp;
                h--;
            }
        }
       
    }
}