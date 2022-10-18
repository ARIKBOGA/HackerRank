import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MinimumHealth {

    public static long getMinimumHealth(List<Integer> initial_players, List<Integer> new_players, int rank) {

        Collections.sort(initial_players);
        AtomicReference<Integer> first = new AtomicReference<>(initial_players.get(initial_players.size() - rank));

        new_players.forEach(add -> {
            initial_players.add(add);
            Collections.sort(initial_players);
            first.updateAndGet(v -> v + initial_players.get(initial_players.size() - rank));
        });

        return (long) first.get();
    }


    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 8, 7, 6));
        System.out.println("getMinimumHealth(l1,l2,2) = " + getMinimumHealth(l1, l2, 2));


    }
}
