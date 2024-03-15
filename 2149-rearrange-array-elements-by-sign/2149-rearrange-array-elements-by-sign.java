class Solution {
    public int[] rearrangeArray(int[] a) {
        
        int n=a.length;
        ArrayList<Integer>pos = new ArrayList<>();
        ArrayList<Integer>neg = new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            if(a[i]>0)
            {
                pos.add(a[i]);
            }
            else
            {
                neg.add(a[i]);
            }
        }
        
        if(pos.size()>neg.size())
        {
            for(int i=0;i<pos.size();i++)
            {
                a[i*2]  = pos.get(i);
                a[i*2+1] = neg.get(i);
            }
            int idx = neg.size()*2;
            for(int i=neg.size();i<pos.size();i++)
            {
                a[idx] = pos.get(i);
                idx++;
            }
        }
        else
        {
             for(int i=0;i<neg.size();i++)
            {
                a[i*2]  = pos.get(i);
                a[i*2+1] = neg.get(i);
            }
            int idx = pos.size()*2;
            for(int i=pos.size();i<neg.size();i++)
            {
                a[idx] = neg.get(i);
                idx++;
            }
        }
        return a;
    }
}