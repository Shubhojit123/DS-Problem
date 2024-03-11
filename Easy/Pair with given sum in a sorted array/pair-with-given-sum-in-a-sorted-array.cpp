//{ Driver Code Starts
#include <bits/stdc++.h>


using namespace std;




// } Driver Code Ends

class Solution{
  public:
    int Countpair(int a[], int n, int sum){
        
        // Complete the function
        int l = 0;
        int h = n-1;
        int k = 0;
        int c = 0;
        while(l<h)
        {
            k = a[l]+a[h];
            if(k==sum)
            {
                c++;
                l++;
                h--;
            }
            else if (sum < k)
            {
                h--;
            }
            else
            {
                l++;
            }
        }
        if(c == 0)
        {
            return -1;
        }
        return c;
    
        
    }
};

//{ Driver Code Starts.
int main()
 {
    int t;
    cin>>t;
    while(t--)
    {
        
        int n;
        cin>>n;
        int arr[n+1];
        
        for(int i=0;i<n;i++)
        cin>>arr[i];

        int sum;
        cin>>sum;
        Solution obj;
        cout << obj.Countpair(arr, n, sum) << endl;
        
    }
	return 0;
}

// } Driver Code Ends