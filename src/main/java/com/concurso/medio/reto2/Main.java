package com.concurso.medio.reto2;

import com.concurso.medio.reto2.Sesion.Usuario;

public class Main {
    public static void main(String[] args) {
        Sesion sesion = Sesion.crearSesion(
                new Usuario("Mary", true)
        );

        Sesion sesion2 = Sesion.crearSesion(
                new Usuario("Juan", false)
        );

        ProxyRecurso r = new ProxyRecurso();
        r.acceder(sesion);
    }
}
