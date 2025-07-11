package com.concurso.medio.reto2;

public class RecursoReal implements Recursos {
    public void acceder(Sesion s) {
        System.out.println("Accediendo al recurso protegido.");
    }
}

