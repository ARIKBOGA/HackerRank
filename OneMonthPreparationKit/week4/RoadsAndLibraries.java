package week4;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RoadsAndLibraries {

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {

        if (c_road >= c_lib) {
            return (long) c_lib * (long) n;
        }

        HashMap<Integer, Integer> parent = new HashMap<>();
        HashMap<Integer, Long> count = new HashMap<>();
        for (int idx = 1; idx <= n; idx++) {
            parent.put(idx, idx);
            count.put(idx, 1L);
        }

        for (List<Integer> city : cities) {
            union(parent, city.get(0), city.get(1), count);
        }

        long ans = 0L;
        for (Integer i : count.keySet()) {
            ans += c_lib;
            ans += (count.get(i) - 1) * (long) c_road;
        }

        return ans;

    }

    public static void union(HashMap<Integer, Integer> parent, int a1, int a2, HashMap<Integer, Long> count) {
        int p1 = find(parent, a1);
        int p2 = find(parent, a2);

        if (p1 == p2) {
            return;
        }

        long c1 = count.get(p1);
        long c2 = count.get(p2);

        if (c1 <= c2) {
            parent.put(p1, p2);
            count.remove(p1);
            count.put(p2, c1 + c2);
        } else {
            parent.put(p2, p1);
            count.remove(p2);
            count.put(p1, c1 + c2);
        }


    }

    public static int find(HashMap<Integer, Integer> parent, int me) {
        int p = parent.get(me);
        while (parent.get(p) != p) {
            p = parent.get(p);
        }

        parent.put(me, p);
        return p;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = roadsAndLibraries(n, c_lib, c_road, cities);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}