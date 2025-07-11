package com.concurso.medio.reto2;

public class Sesion {
    private static Sesion instancia;
    private Usuario usuario;

    private Sesion(Usuario usuario) {
        this.usuario = usuario;
    }

    public static Sesion crearSesion(Usuario usuario) {
        if (instancia == null) {
            instancia = new Sesion(usuario);
            System.out.println(" Se creo instancia");
        } else System.out.println(" solo existe una instancia " +
                "de sesión para los usuarios");
        return instancia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    record Usuario(String name, boolean autentica) {

    }
}

