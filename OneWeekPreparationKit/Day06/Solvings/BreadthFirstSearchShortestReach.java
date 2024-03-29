package Day06.Solvings;

import java.util.Scanner;
import java.util.Stack;

public class BreadthFirstSearchShortestReach {
    static int[] bfs(int n, int m, int[][] edges, int s) {
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }
        Stack<Integer> one = new Stack<>();
        Stack<Integer> two = new Stack<>();
        one.add(s);
        int dist = 0;
        while (true) {
            while (!one.isEmpty()) {
                int v = one.pop();
                if (!visited[v - 1]) {
                    visited[v - 1] = true;
                    distance[v - 1] = dist;
                    for (int[] edge : edges) {
                        if (edge[0] == v || edge[1] == v) {
                            two.add(edge[0]);
                            two.add(edge[1]);
                        }
                    }
                }
            }
            dist += 6;
            while (!two.isEmpty()) {
                int v = two.pop();
                if (!visited[v - 1]) {
                    visited[v - 1] = true;
                    distance[v - 1] = dist;
                    for (int[] edge : edges) {
                        if (edge[0] == v || edge[1] == v) {
                            one.add(edge[0]);
                            one.add(edge[1]);
                        }
                    }
                }
            }
            dist += 6;
            if (one.isEmpty() && two.isEmpty()) break;
        }
        return distance;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] edges = new int[m][2];
            for (int edges_i = 0; edges_i < m; edges_i++) {
                for (int edges_j = 0; edges_j < 2; edges_j++) {
                    edges[edges_i][edges_j] = in.nextInt();
                }
            }
            int s = in.nextInt();
            int[] result = bfs(n, m, edges, s);
            for (int i = 0; i < result.length; i++) {
                if (i != s - 1) {
                    if (result[i] == 0) System.out.print("-1 ");
                    else System.out.print(result[i] + " ");
                }
            }
            System.out.println("");
        }
        in.close();
    }
}