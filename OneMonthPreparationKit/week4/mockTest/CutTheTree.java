package week4.mockTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class CutTheTree {
    static int[] subarray;
    static ArrayList<Integer>[] adjlist;
    static boolean[] visited;

    static HashMap<Integer, Integer> map;  //child,parent

    public static int getunvisited(int index) {
        for (int i = 0; i < adjlist[index].size(); i++) {
            int v = adjlist[index].get(i);

            if (!visited[v])
                return v;
        }
        return -1;

    }

    public static void dfs(int index) {
        Stack<Integer> stack = new Stack<>();
        stack.add(index);
        map.put(index, -1); // root of parent is none
        visited[index] = true;

        while (stack.size() >= 1) {
            int s = stack.peek();
            int next = getunvisited(s);

            if (next == -1) {
                int out = stack.pop();

                int sum = subarray[out];
                for (int j = 0; j < adjlist[out].size(); j++) {
                    int v = adjlist[out].get(j);
                    sum = sum + subarray[v];

                }
                subarray[out] = sum;
                if (map.get(out) != -1) {
                    subarray[out] = subarray[out] - subarray[map.get(out)];
                }
                System.out.println("popping " + (out + 1) + " : " + subarray[out]);

            } else {
                System.out.println("pushing" + (next + 1));

                map.put(next, s); //child,parent

                stack.add(next);
                visited[next] = true;
            }

        }
    }


    public static int cutTheTree(List<Integer> data, List<List<Integer>> edges) {

        int n = data.size();

        subarray = new int[n];
        visited = new boolean[n];
        adjlist = new ArrayList[n];
        int total = 0;
        map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adjlist[i] = new ArrayList<>();
            total = total + data.get(i);
            subarray[i] = data.get(i);
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adjlist[u - 1].add(v - 1);
            adjlist[v - 1].add(u - 1);
        }

        dfs(0);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int x = Math.abs(total - 2 * subarray[i]);
            if (x < min) {
                min = x;
            }
        }
        return min;

    }
}