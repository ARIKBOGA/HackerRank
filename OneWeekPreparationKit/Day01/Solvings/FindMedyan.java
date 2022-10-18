package Day01.Solvings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FindMedyan {

    public static int getMedyan(ArrayList<Integer> list) {
        Collections.sort(list);
        int medyan;
        if (list.size() % 2 == 0) {
            medyan = (list.get(list.size() / 2) + list.get((list.size() / 2) - 1));
        } else {
            medyan = (list.get(list.size() / 2));
        }
        return medyan;
    }

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("ArrayList boyutunu giriniz : ");
        int n = sc.nextInt();
        System.out.println("ArrayList elemanlarını giriniz : ");
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        sc.close();
        System.out.println("Girilen listenin Medyanı : " + getMedyan(arr));

    }
}
