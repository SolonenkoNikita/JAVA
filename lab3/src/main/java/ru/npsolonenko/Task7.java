package ru.npsolonenko;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Task7 {

    private static boolean isSorted(ArrayList<String> strings, Comparator<String> comp, ArrayList<String> sortedCopy) {
        if(strings.size() != sortedCopy.size())
            return false;
        for (int i = 0; i < strings.size(); ++i) {
            if (comp.compare(strings.get(i), sortedCopy.get(i)) != 0)
                return false;
        }
        return true;
    }

    public static void luckySort(ArrayList<String> strings, Comparator<String> comp) {
        ArrayList<String> sortedCopy = new ArrayList<>(strings);
        sortedCopy.sort(comp);

        while (!isSorted(strings, comp, sortedCopy))
            Collections.shuffle(strings);
    }

    public static void main(String[] args) {

        ArrayList<String> teams = new ArrayList<>();
        teams.add("Real Madrid");
        teams.add("AC Milan");
        teams.add("Borussia Dortmund");
        teams.add("Ajax");
        teams.add("CSKA");


        Comparator<String> comp = Comparator.naturalOrder();

        System.out.println("Before: " + teams);
        luckySort(teams, comp);
        System.out.println("After: " + teams);
    }
}
