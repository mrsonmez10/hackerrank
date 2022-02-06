package interview.amazon.binarytree;

import java.util.Scanner;

public class BinaryTreeHeight {

    class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    class Solution {

        /*
        class Node
            int data;
            Node left;
            Node right;
        */
        public int height(Node root) {
            // Write your code here.
            if(root == null)
                return -1;
            if(root.left == null && root.right == null)
                return 0;
            else if(root.left != null && root.right == null)
                return 1 + height(root.left);
            else if(root.left == null && root.right != null)
                return 1 + height(root.right);
            else
                return 1 + Math.max(height(root.left), height(root.right));
        }
    }

    public void runHackerrank() {

        Solution s = new Solution();
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = s.height(root);
        System.out.println(height);
    }

//    public static void main(String[] args) {
//        BinaryTreeHeight binaryTree = new BinaryTreeHeight();
//        binaryTree.runHackerrank();
//    }
}
