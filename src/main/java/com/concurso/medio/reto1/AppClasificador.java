package com.concurso.medio.reto1;

import java.util.List;

public class AppClasificador {

    public static void main(String[] args) {
        List<String[]> datos = List.of(
                new String[]{"Ana", "@clientu"},
                new String[]{"Luis", "#admin1"},
                new String[]{"Carlos", "%dcode.des"},
                new String[]{"Diana", "@betauseru"},
                new String[]{"Pedro", "#super5"},
                new String[]{"Laura", "%dapp.tec"}
        );

        Departamento testing = new Departamento(1, "Testing");
        Departamento admin = new Departamento(2, "Admin");
        Departamento programming = new Departamento(3, "Programming");

// alternativa con streams
//   datos.stream()
//           .map(row -> ClasificadorEtiquetas.clasificar(row[0], row[1]))
//           .filter(Optional::isPresent)
//           .flatMap(Optional::stream)
//           .forEach(emp -> {
//               var depto = switch (emp.getTipo()) {
//                   case Empleado.USUARIO -> testing;
//                   case Empleado.ADMINISTRADOR -> admin;
//                   case Empleado.DESARROLLADOR -> programming;
//                   default -> null;
//               };
//               if (depto != null)
//                   depto.agregarEmpleado(emp);
//           });

        for (String[] d : datos) {
            ClasificadorEtiquetas.clasificar(d[0], d[1])
                    .ifPresent(emp -> {
                var depto = switch (emp.getTipo()) {
                    case Empleado.USUARIO -> testing;
                    case Empleado.ADMINISTRADOR -> admin;
                    case Empleado.DESARROLLADOR -> programming;
                    default -> null;
                };
                if (depto != null)
                    depto.agregarEmpleado(emp);
            });
        }

        // Mostrar resultados
        testing.listarEmpleados();
        admin.listarEmpleados();
        programming.listarEmpleados();
    }
}
