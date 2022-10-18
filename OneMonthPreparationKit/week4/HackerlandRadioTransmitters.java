package week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HackerlandRadioTransmitters {

    public static int hackerlandRadioTransmittersMine(List<Integer> x, int k) { // Half of the test cases were failed with this (my solution)
        Collections.sort(x);
        int count = 0;
        for (int i = 0; i < x.size(); i++) {
            if (i < x.size() - 1 && x.get(i) + k < x.get(i + 1)) {
                count++;
                continue;
            }
            int j = i + 1;
            while (j < x.size() && x.get(i) + 2 * k >= x.get(j)) j++;
            count++;
            i = j - 1;
        }
        return count;
    }

    public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
        // Sort the house positions, so we can iterate from smallest to largest
        Collections.sort(x);

        // Keep track of the earliest (lowest number) house covered by
        // the current radio and the location (house) of the current radio.
        int radios = 1;
        int last = x.get(0);
        int mustCover = x.get(0);
        for (Integer h : x) {
            if ((h - last) > k) {
                // Need a new radio, cannot reach
                radios++;
                last = h;
                mustCover = h;
            } else if (h - mustCover <= k) {
                // Radio can move to this new house
                last = h;
            } else {
                // Radio cannot reach from earliest house to this one,
                // but it CAN reach both of us from the current location.
                // No action needed, leave radio where it is.
            }
        }
        return radios;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 9, 12));
        System.out.println(hackerlandRadioTransmitters(list, 2));


        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(hackerlandRadioTransmitters(list2, 1));

        System.out.println("-------------------------------");
        System.out.println(hackerlandRadioTransmittersMine(list, 2));
        System.out.println(hackerlandRadioTransmittersMine(list2, 1));
    }
}