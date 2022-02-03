package interview.amazon.bfs;

import java.util.*;

/**
 * Check the link for question info: You can reach link from resource/links.txt
 * Test Cases:
     * Try With:
     * Input:
     * 2
     * 4 2
     * 1 2
     * 1 3
     * 1
     * 3 1
     * 2 3
     * 2
     * Output:
     * 6 6 -1
     * -1 6
     *
     * Input:
     * 1
     * 6 4
     * 1 2
     * 2 3
     * 3 4
     * 1 5
     * 1
     * Output:
     * 6 12 18 6 -1
 *
 */
public class Solution {
    public static class Graph {
        private int V;
        private LinkedList<Integer> [] G;

        public Graph(int size) {
            this.V = size;
            this.G = new LinkedList[V];

            for(int v = 0; v < V; v++)
                G[v] = new LinkedList<>();
        }

        public void addEdge(int first, int second) {
            G[first].add(second);
            G[second].add(first);
        }

        public int[] shortestReach(int startId) { // 0 indexed
            boolean [] visited = new boolean[V];
            Queue<Integer> q = new LinkedList<>();
            q.add(startId);
            visited[startId] = true;
            int size = 1;
            int distance = 6;
            int [] distTo = new int[V];
            Arrays.fill(distTo, -1);
            while(!q.isEmpty()) {
                int v = q.poll();
                for(int w : G[v]) {
                    if(!visited[w]) {
                        visited[w] = true;
                        distTo[w] = distance;
                        q.add(w);
                    }
                }

                if(--size == 0) {
                    size = q.size();
                    distance+=6;
                }
            }
            return distTo;
        }
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int queries = scanner.nextInt();
//
//        for (int t = 0; t < queries; t++) {
//
//            // Create a graph of size n where each edge weight is 6:
//            Graph graph = new Graph(scanner.nextInt());
//            int m = scanner.nextInt();
//
//            // read and set edges
//            for (int i = 0; i < m; i++) {
//                int u = scanner.nextInt() - 1;
//                int v = scanner.nextInt() - 1;
//
//                // add each edge to the graph
//                graph.addEdge(u, v);
//            }
//
//            // Find shortest reach from node s
//            int startId = scanner.nextInt() - 1;
//            int[] distances = graph.shortestReach(startId);
//
//            for (int i = 0; i < distances.length; i++) {
//                if (i != startId) {
//                    System.out.print(distances[i]);
//                    System.out.print(" ");
//                }
//            }
//            System.out.println();
//        }
//
//        scanner.close();
//    }
}