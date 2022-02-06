package interview.amazon.binarytree;

import java.util.*;
import java.io.*;

public class LevelOrderTraversal {

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

    class Solution {

        /*

        class Node
            int data;
            Node left;
            Node right;
        */

        // Arraylist pref. check LevelOrderTraversalSpeedComparison.java
        public void levelOrder(Node root) {

            StringBuilder sb = new StringBuilder();

            if(root == null)
                throw new NullPointerException("Node can not be null");

            //LinkedList<Node> queue = new LinkedList();
            List<Node> queue = new ArrayList<>();
            queue.add(root);

            while(!queue.isEmpty()){
                // Node currentNode = queue.poll();
                Node currentNode = queue.remove(0);
                sb.append(currentNode.data);
                sb.append(" ");
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }
            System.out.println(sb.toString());
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

    }

    public void runHackerRank() {
        Scanner scan = new Scanner(System.in);
        Solution s = new Solution();
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = s.insert(root, data);
        }
        scan.close();
        s.levelOrder(root);
    }

//    public static void main(String[] args) {
//        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
//        levelOrderTraversal.runHackerRank();
//    }
}
