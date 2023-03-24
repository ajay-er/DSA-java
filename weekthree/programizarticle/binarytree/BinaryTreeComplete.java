package programizarticle.binarytree;

// Checking if a binary tree is a complete binary tree in Java

// Node creation
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTreeComplete {
    Node root;

    // Count the number of nodes
    int countNumNodes(Node root) {
        if (root == null)
            return (0);
        return (1 + countNumNodes(root.left) + countNumNodes(root.right));
    }

    // Check for complete binary tree
    boolean checkComplete(Node root, int index, int numberNodes) {

        // Check if the tree is empty
        if (root == null)
            return true;

        if (index >= numberNodes)
            return false;

        return (checkComplete(root.left, 2 * index + 1, numberNodes)
                && checkComplete(root.right, 2 * index + 2, numberNodes));
    }

    public static void main(String args[]) {
        BinaryTreeComplete tree = new BinaryTreeComplete();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.left.left = new Node(4);
        tree.root.right.left = new Node(6);

        int node_count = tree.countNumNodes(tree.root);
        int index = 0;

        if (tree.checkComplete(tree.root, index, node_count))
            System.out.println("The tree is a complete binary tree");
        else
            System.out.println("The tree is not a complete binary tree");
    }

}
