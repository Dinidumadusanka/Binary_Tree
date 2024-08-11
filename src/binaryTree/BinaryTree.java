package binaryTree;
//Binary Tree Node class
class Node {
 int key;
 Node left, right;

 // Constructor to create a new node
 public Node(int item) {
     key = item;
     left = right = null;
 }
}
public class BinaryTree {
	 Node root;

	    // Constructor to initialize the root of the binary tree
	    BinaryTree() {
	        root = null;
	    }

	    // Insert a new key in the binary tree
	    void insert(int key) {
	        root = insertRec(root, key);
	    }

	    // Recursive function to insert a new key in the binary tree
	    Node insertRec(Node root, int key) {
	        // If the tree is empty, return a new node
	        if (root == null) {
	            root = new Node(key);
	            return root;
	        }

	        // Otherwise, recur down the tree
	        if (key < root.key) {
	            root.left = insertRec(root.left, key);
	        } else if (key > root.key) {
	            root.right = insertRec(root.right, key);
	        }

	        // Return the unchanged node pointer
	        return root;
	    }

	    // Delete a key from the binary tree
	    void deleteKey(int key) {
	        root = deleteRec(root, key);
	    }

	    // Recursive function to delete a key from the binary tree
	    Node deleteRec(Node root, int key) {
	        // Base case: if the tree is empty
	        if (root == null) return root;

	        // Recur down the tree
	        if (key < root.key) {
	            root.left = deleteRec(root.left, key);
	        } else if (key > root.key) {
	            root.right = deleteRec(root.right, key);
	        } else {
	            // If the key is the same as root's key, then this is the node to be deleted

	            // Node with only one child or no child
	            if (root.left == null) return root.right;
	            else if (root.right == null) return root.left;

	            // Node with two children: get the inorder successor (smallest in the right subtree)
	            root.key = minValue(root.right);

	            // Delete the inorder successor
	            root.right = deleteRec(root.right, root.key);
	        }

	        return root;
	    }

	    // Get the minimum value node in the given tree (used in deletion)
	    int minValue(Node root) {
	        int minValue = root.key;
	        while (root.left != null) {
	            minValue = root.left.key;
	            root = root.left;
	        }
	        return minValue;
	    }

	    // In-order traversal of the binary tree (Left, Root, Right)
	    void inOrder() {
	        inOrderRec(root);
	    }

	    void inOrderRec(Node root) {
	        if (root != null) {
	            inOrderRec(root.left); // Recur on left subtree
	            System.out.print(root.key + " "); // Print the root node
	            inOrderRec(root.right); // Recur on right subtree
	        }
	    }

	    // Pre-order traversal of the binary tree (Root, Left, Right)
	    void preOrder() {
	        preOrderRec(root);
	    }

	    void preOrderRec(Node root) {
	        if (root != null) {
	            System.out.print(root.key + " "); // Print the root node
	            preOrderRec(root.left); // Recur on left subtree
	            preOrderRec(root.right); // Recur on right subtree
	        }
	    }

	    // Post-order traversal of the binary tree (Left, Right, Root)
	    void postOrder() {
	        postOrderRec(root);
	    }

	    void postOrderRec(Node root) {
	        if (root != null) {
	            postOrderRec(root.left); // Recur on left subtree
	            postOrderRec(root.right); // Recur on right subtree
	            System.out.print(root.key + " "); // Print the root node
	        }
	    }

	    // Main method to test the above functions
	    public static void main(String[] args) {
	        BinaryTree tree = new BinaryTree();

	        /* Inserting nodes into the binary tree */
	        tree.insert(50);
	        tree.insert(30);
	        tree.insert(20);
	        tree.insert(40);
	        tree.insert(70);
	        tree.insert(60);
	        tree.insert(80);

	        System.out.println("In-order traversal of the given tree:");
	        tree.inOrder(); // Output: 20 30 40 50 60 70 80

	        System.out.println("\n\nPre-order traversal of the given tree:");
	        tree.preOrder(); // Output: 50 30 20 40 70 60 80

	        System.out.println("\n\nPost-order traversal of the given tree:");
	        tree.postOrder(); // Output: 20 40 30 60 80 70 50

	        System.out.println("\n\nDelete 20");
	        tree.deleteKey(20);
	        System.out.println("In-order traversal after deletion:");
	        tree.inOrder(); // Output: 30 40 50 60 70 80

	        System.out.println("\n\nDelete 30");
	        tree.deleteKey(30);
	        System.out.println("In-order traversal after deletion:");
	        tree.inOrder(); // Output: 40 50 60 70 80

	        System.out.println("\n\nDelete 50");
	        tree.deleteKey(50);
	        System.out.println("In-order traversal after deletion:");
	        tree.inOrder(); // Output: 40 60 70 80
	    }
	}

