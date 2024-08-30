//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int maxScore(vector<int>& cardPoints, int k) {
        // code here.
        int left = 0;
    int right = 0;
    int n = cardPoints.size();
    int ans = 0;

    // Calculate initial left sum
    for (int i = 0; i < k; i++) {
        left += cardPoints[i];
    }

    ans = left;

    // Sliding window to include rightmost elements
    int last = n - 1;
    for (int i = k - 1; i >= 0; i--) {
        left -= cardPoints[i];
        right += cardPoints[last];
        last--;

        ans = std::max(ans, left + right);
    }

    return ans;
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore(); // Consume the newline character

    while (t--) {
        string input;
        getline(cin, input);
        stringstream ss(input);
        int num;
        vector<int> cardPoints;
        while (ss >> num)
            cardPoints.push_back(num);

        int k;
        cin >> k;
        cin.ignore(); // Consume the newline character

        Solution ob;
        cout << ob.maxScore(cardPoints, k) << endl;
    }

    return 0;
}

// } Driver Code Ends