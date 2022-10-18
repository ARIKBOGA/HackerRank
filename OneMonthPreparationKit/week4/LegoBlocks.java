package week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class LegoBlocks {

    public static int legoBlocks(int h, int w) {

        final int MOD = 1000000007;

        // Permutations of a single row of given width
        ArrayList<Integer> permutations = new ArrayList<>(Arrays.asList(1, 1, 2, 4, 8));
        for (int i = 5; i <= w; i++) {
            permutations.add((int) (permutations.subList(i - 4, i)
                    .stream()
                    .mapToLong(t -> t)
                    .sum() % MOD)
            );
        }

        // Permutation for a wall of height h of the given width.
        // Each row is independent and thus their combined permutations count is
        // permutations(1 row)^(number of rows)
        List<Integer> totals = permutations.stream()
                .map(perm -> LongStream.range(0, h).boxed().reduce(1L, (acc, el) -> (acc * perm) % MOD).intValue())
                .collect(Collectors.toList());


        // Invalid permutation for a wall of height h of given width
        ArrayList<Integer> invalid = new ArrayList<>(Arrays.asList(0, 0));
        for (int i = 2; i <= w; i++) {
            int j = i;
            // We multiply the valid permutations count of each "subwall" of width "t"
            // with the total permutations count (both valid and invalid) of the remaining columns
            // because the previous valid permutations are aligned at the end of their respective column
            // and thus every wall beginning with them is invalid.
            invalid.add((int) ((IntStream.range(1, j).mapToLong(t -> {
                        long var = (totals.get(t) - invalid.get(t) + MOD) % MOD;
                        return var * totals.get(j - t) % MOD;
                    })
                    .sum() % MOD)));
        }

        int result = totals.get(w) - invalid.get(w);

        return result < 0 ? result + MOD : result;

    }

    public static void main(String[] args) {

        System.out.println(legoBlocks(4, 5));

        System.out.println(legoBlocks(8, 3));
    }
}