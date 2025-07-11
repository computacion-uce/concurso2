package com.concurso.avanzado.reto1;

import java.util.Comparator;

public class QuickSort {
    record Pair<T>(Lista<T> ls1, Lista<T> ls2) {
    }

    static <T> Pair<T> partition(T pivot, Lista<T> ls,
                                          Comparator<T> cmp) {
        // se toma la cabecera de la lista
        //   si la cabecera es menor que el PIVOT,
        //     se agrega a la lista de la izquierda
        //   si la cabecera es mayor que el PIVOT,
        //     se agrega a la lista de la derecha
        // se repite el procedimiento para la cola
        // el procedimiento termina si la lista está vacía
        if (ls.isEmpty()) {
            return new Pair<>(Lista.Empty, Lista.Empty);
        } else {
            var h = ls.head();

            var tmp = partition(pivot, ls.tail(), cmp);

            if (cmp.compare(h, pivot) < 0) { //h<elem
                return new Pair<>(tmp.ls1.prepend(h), tmp.ls2);
            } else { //h>=elem
                return new Pair<>(tmp.ls1, tmp.ls2.prepend(h));
            }
        }
    }

    public static <T> Lista<T> sort(Lista<T> ls, Comparator<T> cmp) {
        if (ls.isEmpty()) {
            return Lista.Empty;
        } else {
            var mid = ls.head();

            var tmp = partition(mid, ls.tail(), cmp);

            var smallerSorted = QuickSort.sort(tmp.ls1, cmp);
            var largerSorted = QuickSort.sort(tmp.ls2, cmp);

            return smallerSorted.concat(Lista.of(mid, largerSorted));
        }
    }

    public static <T extends Comparable<T>> Lista<T> sort(Lista<T> ls) {
        return QuickSort.sort(ls, Comparable::compareTo);
    }

    public static void main(String[] args) {
        //var ls = Lista.of(12,10,1,11,9,7,8);
        var ls = Lista.of(4, 10, 1, 11, 9, 3, 8);

        var sortedList = QuickSort.sort(ls);

        System.out.println(sortedList);
    }
}
