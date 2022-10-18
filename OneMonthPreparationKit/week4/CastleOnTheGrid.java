package week4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


class Result {
    public static int minimumMoves(List<String> grid, int startRow, int startCol, int goalRow, int goalCol) {
        // Initialize
        Node[][] nodes = new Node[grid.size()][grid.size()];
        for (int r = 0; r < nodes.length; r++) {
            for (int c = 0; c < nodes.length; c++) {
                if (grid.get(r).charAt(c) != 'X') nodes[r][c] = new Node(r, c, r == goalRow && c == goalCol);
            }
        }
        Node.setEnvironment(nodes);

        // Connect
        for (Node[] node : nodes) {
            for (int c = 0; c < nodes.length; c++) {
                if (node[c] != null) node[c].connect();
            }
        }

        // Traverse
        Node startNode = nodes[startRow][startCol];
        startNode.visited = true;
        Node[] toVisit = new Node[]{startNode};
        int distance = 0;
        while (toVisit.length > 0) {
            if (Arrays.stream(toVisit).anyMatch(t -> t.isGoal)) break;
            distance++;
            toVisit = Arrays.stream(toVisit).flatMap(Node::getConnectedNotVisited).toArray(Node[]::new);
        }
        return distance;
    }

    static class Node {
        private static Node[][] nodes;
        List<Node> connectedTo = new ArrayList<>();
        boolean isGoal;
        boolean visited;
        int row;
        int col;

        public Node(int row, int col, boolean isGoal) {
            this.row = row;
            this.col = col;
            this.isGoal = isGoal;
            this.visited = false;
        }

        public static void setEnvironment(Node[][] nodes) {
            Node.nodes = nodes;
        }

        public void connect() {
            connectBottom();
            connectTop();
            connectRight();
            connectLeft();
        }

        private void connectBottom() {
            ArrayList<int[]> positions = new ArrayList<>();
            for (int r = row; r + 1 < nodes.length && nodes[r + 1][col] != null && !nodes[r][col].isGoal; r++)
                positions.add(new int[]{r + 1, col});
            connect(positions);
        }

        private void connectTop() {
            ArrayList<int[]> positions = new ArrayList<>();
            for (int r = row; r - 1 >= 0 && nodes[r - 1][col] != null && !nodes[r][col].isGoal; r--)
                positions.add(new int[]{r - 1, col});
            connect(positions);
        }

        private void connectRight() {
            ArrayList<int[]> positions = new ArrayList<>();
            for (int c = col; c + 1 < nodes.length && nodes[row][c + 1] != null && !nodes[row][c].isGoal; c++)
                positions.add(new int[]{row, c + 1});
            connect(positions);
        }

        private void connectLeft() {
            ArrayList<int[]> positions = new ArrayList<>();
            for (int c = col; c - 1 >= 0 && nodes[row][c - 1] != null && !nodes[row][c].isGoal; c--)
                positions.add(new int[]{row, c - 1});
            connect(positions);
        }

        private void connect(ArrayList<int[]> positions) {
            for (int[] pos : positions) {
                int r = pos[0], c = pos[1];
                connectedTo.add(nodes[r][c]);
            }
        }

        public Stream<Node> getConnectedNotVisited() {
            return connectedTo.stream().filter(t -> !t.visited).peek(t -> t.visited = true);
        }

        @Override
        public String toString() {
            return "\nNode{isGoal=" + isGoal + ", row=" + row + ", col=" + col + ", connectedTo=" + connectedTo.stream()
                    .map(t -> t.row + "-" + t.col)
                    .collect(Collectors.toList()) + '}';
        }
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(Collectors.toList());

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int startX = Integer.parseInt(firstMultipleInput[0]);

        int startY = Integer.parseInt(firstMultipleInput[1]);

        int goalX = Integer.parseInt(firstMultipleInput[2]);

        int goalY = Integer.parseInt(firstMultipleInput[3]);

        int result = Result.minimumMoves(grid, startX, startY, goalX, goalY);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}