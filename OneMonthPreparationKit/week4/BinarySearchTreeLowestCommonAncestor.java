package week4;

import java.util.Scanner;

public class BinarySearchTreeLowestCommonAncestor {

    public static Node lca(Node root, int v1, int v2) {
        while (true) {
            int current = root.data;
            if (v1 < current && v2 < current) {
                root = root.left;
            } else if (current < v1 && current < v2) {
                root = root.right;
            } else return root;
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = TreePreorderTraversal.insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root, v1, v2);
        System.out.println(ans.data);
    }
}
