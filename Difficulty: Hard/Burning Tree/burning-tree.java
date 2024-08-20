//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
      static int ans = 0;  // Class-level variable to store the maximum time

    public static int burn(Node root, int target) {
        if (root == null) return 0;

        if (root.data == target) {
            return -1;  // Target node found, start the burn process
        }

        int left = burn(root.left, target);
        int right = burn(root.right, target);

        if (left < 0) {
            ans = Math.max(ans, right + Math.abs(left));
            return left - 1;
        }
        if (right < 0) {
            ans = Math.max(ans, left + Math.abs(right) );
            return right - 1;
        }

        return 1 + Math.max(left, right);  // Return height of the subtree
    }

    public static Node find(Node root, int target) {
        if (root == null) return null;

        if (root.data == target) {
            return root;
        }

        Node left = find(root.left, target);
        if (left != null) return left;

        return find(root.right, target);
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static int minTime(Node root, int target) {
        ans = 0;  
        burn(root, target); 
        Node burnNode = find(root, target);  // Find the node where the burn starts
        int high = height(burnNode) - 1;  // Calculate the height of the subtree starting from burnNode
        return Math.max(ans, high);  
    }
}