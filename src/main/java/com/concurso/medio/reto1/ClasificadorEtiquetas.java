package com.concurso.medio.reto1;

import java.util.Optional;
import java.util.regex.Pattern;

public class ClasificadorEtiquetas {
    private static final Pattern usuarioPattern =
            Pattern.compile("^@.*u$");

    private static final Pattern adminPattern =
            Pattern.compile("^#.*\\d$");

    private static final Pattern devPattern =
            Pattern.compile("^%d.*\\.(info|des|tec|sop)$");

    public static Optional<Empleado> clasificar(String nombre,
                                                String etiqueta) {
        Empleado emp = null;
        if (usuarioPattern.matcher(etiqueta).matches()) {
            emp = new Usuario(nombre, etiqueta);
        } else if (adminPattern.matcher(etiqueta).matches()) {
            emp =  new Administrador(nombre, etiqueta);
        } else if (devPattern.matcher(etiqueta).matches()) {
            emp =  new Desarrollador(nombre, etiqueta);
        }
        // o lanzar excepción si se prefiere
        return Optional.ofNullable(emp);
    }
}
