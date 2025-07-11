package com.concurso.avanzado.reto2.rest;

import com.concurso.avanzado.reto2.repository.PersonaRepository;
import com.concurso.avanzado.reto2.servicios.ImportarDatos;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/personas")
public class PersonasRest {

    @Inject
    ImportarDatos importarDatos;

    @Inject
    PersonaRepository personaRepository;

    @GET
    @Path("/importar/{count}")
    public Response importar(@PathParam("count") Integer count) {
        importarDatos.importar(count);

        return Response.ok("Personas importadas correctamente")
                .build();
    }

    @GET
    @Path("/{canton}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response personasPorCanton(
            @PathParam("canton") String canton) {

        var data = personaRepository.findByCanton(canton);

        if (data.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No se encontraron personas: " + canton)
                    .build();
        }

        return Response.ok(data).build();
    }

    @GET
    @Path("/anio/{anio}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response personasPorAnio(@PathParam("anio") Integer anio) {

        var data = personaRepository.findByAnio(anio);

        if (data.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No se encontraron personas: " + anio)
                    .build();
        }

        return Response.ok(data).build();
    }
}
