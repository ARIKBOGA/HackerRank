package week3.Mock_test;


import java.util.*;
import java.util.stream.Collectors;

public class BigSorting {

    static List<String> sorted = new ArrayList<>();

    public static void bigSorting(List<String> unsorted) {
        unsorted = unsorted.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
        int start = 0;
        for (int i = 0; i < unsorted.size(); i++) {
            int end = start;
            while (i < unsorted.size() - 1 && unsorted.get(i).length() == unsorted.get(i + 1).length()) {
                end++;
                i++;
            }
            deepSort(unsorted.subList(start, end + 1));
            start = end + 1;
        }

    }

    private static void deepSort(List<String> subList) {
        Collections.sort(subList);
        sorted.addAll(subList);
    }

    public static void main(String[] args) {
        List<String> numbers = new ArrayList<>(Arrays.asList("268634597256734585764325726971198891186932769507248"
                , "27897053794375009852371",
                "582457390704517832347528345178794753745869732572582998852349856", "21", "342", "3", "12","27897053794375009852375"));
        bigSorting(numbers);
        sorted.forEach(System.out::println);
    }
}