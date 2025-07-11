package com.concurso.avanzado.reto1;

final class Empty<T> implements Lista<T> {
    Empty() {

    }

    @Override
    public T head() {
        throw new RuntimeException("Lista vacía");
    }

    @Override
    public Lista<T> tail() {
        throw new RuntimeException("Lista vacía");
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public String toString() {
        return "Empty";
    }
}
