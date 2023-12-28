//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function template for C++
class Solution{
    public:
   bool match(string wild, string pattern)
    {
        // code here
        int wStart{-1}, pStart{0}, wSize{wild.size()}, pSize(pattern.size());
        // 0 to '*' code.....
        for (int i{0}; i < wSize; i++)
        {
            if (wild[i] == '*')
            {
                wStart = pStart = i;
                break;
            }
            else if (wild[i] == '?')
                continue;
            else if (wild[i] != pattern[i])
                return false;
        }
        if (wStart == -1)
            return (wSize == pSize) ? true : false;
         // '*' to '*' code ..........
        for (int i{++wStart}; i <= wSize; i++)
        {
            if (wild[i] == '*')
            {
                pStart = checkPattern(wild.substr(wStart, i - wStart), pattern, pStart);
                if (pStart == -1)
                    return false;
    
                wStart = i + 1;
            }
            // '*' to wild.end() code ............
            else if (i == wSize)
            {
                if (wStart == i)
                    return true;
                else if (pStart == pSize)
                    return false;
                else if ((pSize - pStart) < (wSize - wStart))
                    return false;
                for (int p{pSize - 1}, w{wSize - 1}; w >= wStart; p--, w--)
                {
                    if (wild[w] == '?')
                        continue;
                    else if (wild[w] != pattern[p])
                        return false;
                }
                return true;
            }
        }
    }
    // checks if string with '?' mark only matches in pattern...............
    int checkPattern(string pattern, string mainString, int pStart)
    {
        int mSize{mainString.size()}, ptsize{pattern.size()};
        if (ptsize == 0)
            return pStart;
    
        bool ismatch{true};
        for (int i{pStart}; i <= (mSize - ptsize); i++)
        {
            for (int j{i}, k{0}; k < ptsize; k++, j++)
            {
                if (pattern[k] == '?')
                    continue;
                else if (pattern[k] != mainString[j])
                {
                    ismatch = false;
                    break;
                }
            }
            if (ismatch)
                return i + ptsize;
            else
                ismatch = true;
        }
        return -1;
}
};

//{ Driver Code Starts.
int main()
{
    int t;
    cin>>t;
    while(t-->0)
    {
        string wild, pattern;
        cin>>wild>>pattern;
        
        Solution ob;
        bool x=ob.match(wild, pattern);
        if(x)
        cout<<"Yes\n";
        else
        cout<<"No\n";
    }
    return 0;
}
// } Driver Code Ends