package Day04.Solvings;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;


public class TruckTour {
    public static int truckTour(List<List<Integer>> petrolpumps) {
        int sum = 0;
        int baslangic = 0;
        for (int i = 0; i < petrolpumps.size(); i++) {
            sum += petrolpumps.get(i).get(0) - petrolpumps.get(i).get(1);
            if (sum < 0) {
                sum = 0;
                baslangic = i + 1;
            }
        }
        return (baslangic >= petrolpumps.size()) ? -1 : baslangic;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<List<Integer>> petrolpumps = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> {
            try {
                petrolpumps.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        int result = truckTour(petrolpumps);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}