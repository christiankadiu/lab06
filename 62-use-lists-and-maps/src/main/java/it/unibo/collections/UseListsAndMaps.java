package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int ELEMS = 100000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *          unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        ArrayList<Integer> lista = new ArrayList<>();
        int i;
        int c = 0;
        for (i = 1000; i <= 2000; i++) {
            lista.add(c, i);
            c = c + 1;
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer> lista2 = new LinkedList<>();
        lista2.addAll(0, lista);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int temp = lista.getLast();
        lista.set((lista.size() - 1), lista.getFirst());
        lista.set(lista.indexOf(lista.getFirst()), temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer integer : lista) {
            System.out.println(integer);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */

        long time = System.nanoTime();
        for (i = 1; i <= ELEMS; i++) {
            lista2.addFirst(i);
        }

        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
                +ELEMS
                        + " insertions in a LinkedList took "
                        + time
                        + "ns ("
                        + millis
                        + "ms)");

        for (i = 1; i <= ELEMS; i++) {
            lista.addFirst(i);
        }
        time = System.nanoTime() - time;
        final var millos = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
                +ELEMS
                        + " insertions in an ArrayList took "
                        + time
                        + "ns ("
                        + millos
                        + "ms)");

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        for (i = 0; i < 1000; i++) {
            int elem = lista.get(lista.size() / 2);
        }
        time = System.nanoTime() - time;
        final var milloss = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
                "reading 1000 times the middle element of an arrayList took "
                        + time
                        + "ns ("
                        + milloss
                        + "ms)");

        for (i = 0; i < 1000; i++) {
            int elem = lista2.get(lista2.size() / 2);
        }
        time = System.nanoTime() - time;
        final var millosse = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
                "reading 1000 times the middle element of a LinkedList took "
                        + time
                        + "ns ("
                        + millosse
                        + "ms)");
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String, Integer> mappa = new HashMap<>();
        mappa.put("Africa", 1110635);
        mappa.put("Americas", 972005);
        mappa.put("Antarctica", 00);
        mappa.put("Asia", 4298723);
        mappa.put("Europe", 742452000);
        mappa.put("Oceania", 38304000);

        /*
         * 8) Compute the population of the world
         */
        int somma = 0;
        for (Integer integer : mappa.values()) {
            somma = somma + integer;
        }
        System.out.println("population of the world: " + somma);
    }
}
