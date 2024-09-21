//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class ReverseInSize {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());

        while (t-- > 0) {

            String s[] = in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < s.length; i++) {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res, out);
            out.println();
        }
        out.close();
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
    }
}

// } Driver Code Ends


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
  public static void revNode(Node temp) {
        Node ptr = temp;
        Node prv = null;
        Node next = null;

        while (ptr != null) {
            next = ptr.next;
            ptr.next = prv;
            prv = ptr;
            ptr = next;
        }
    }

    public static Node getKthNode(Node node, int k) {
        Node temp = node;
        k = k - 1;

        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }

        return temp;
    }

    public static Node reverse(Node node, int k) {
       if(node==null || node.next==null)
        {
            return node;
        }
        
        
        Node currNode=node;
        Node prevNode=null;
        Node nextNode=null;
        
        int temp=k;
        
        while(currNode!=null && temp>0)
        {
            nextNode=currNode.next;
            currNode.next=prevNode;
            prevNode=currNode;
            currNode=nextNode;
            
            temp--;
        }
        
        if(currNode!=null)
        {
            node.next = reverse(currNode,k);
        }
        
        
        return prevNode;
    }
}
