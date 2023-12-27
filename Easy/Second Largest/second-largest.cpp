//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;

// } Driver Code Ends
//User function template for C++
class Solution{
public:	
	// Function returns the second
	// largest elements
	int print2largest(int arr[], int n) {
	    // code here
	  int  large = arr[0];
	   int  slarge = -1;
	    for(int i=1;i<n;i++)
	    {
	      if(arr[i]>large)
	      {
	          slarge=large;
	          large=arr[i];
	      }
	      else if(arr[i]<large && slarge<arr[i])
	      {
	          slarge=arr[i];
	      }
	    }
	    return slarge;
	}
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int arr[n];
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        auto ans = ob.print2largest(arr, n);
        cout << ans << "\n";
    }
    return 0;
}

// } Driver Code Ends