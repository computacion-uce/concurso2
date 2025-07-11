package com.concurso.medio.reto2;

public class ProxyRecurso implements Recursos {
    // private boolean autenticado;
    private RecursoReal recursoReal = new RecursoReal();

    public ProxyRecurso() {

    }

    public void acceder(Sesion s) {
        if (s.getUsuario().autentica()) recursoReal.acceder(s);
        else System.out.println("Acceso denegado.");
    }
}
