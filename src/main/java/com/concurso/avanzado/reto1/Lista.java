package com.concurso.avanzado.reto1;

public sealed interface Lista<T> permits Cons, Empty {
    Lista Empty = new Empty();

    T head();

    Lista<T> tail();

    boolean isEmpty();

    static <T> Lista<T> of(T elem, Lista<T> tail) {
        return new Cons<>(elem, tail);
    }

    static <T> Lista<T> of(T... elems) {
        var tmp = Lista.Empty;
        for (int i = elems.length - 1; i >= 0; i--) {
            tmp = Lista.of(elems[i], tmp);
        }

        return tmp;
    }

    default Lista<T> prepend(T elem) {
        return Lista.of(elem, this);
    }

    default Lista<T> concat(Lista<T> ls) {
        if (isEmpty()) {
            return ls;
        } else {
            return Lista.of(this.head(), tail().concat(ls));
        }
    }
}
