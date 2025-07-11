package com.concurso.avanzado.reto2.servicios;

import com.concurso.avanzado.reto2.db.Persona;
import com.concurso.avanzado.reto2.repository.PersonaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
public class ImportarDatosImpl implements ImportarDatos {

    @Inject
    PersonaRepository repo;

    @Inject
    @ConfigProperty(name = "app.file-name",
            defaultValue = "c:/cc/Pichincha_CSV_Poblacion.csv")
    String csvFileName;

    public void importar(Integer count) {

        try {
            AtomicInteger cc = new AtomicInteger(0);;

            Files.lines(Path.of(csvFileName))
                    .skip(1) // 1=header
                    .takeWhile(it->cc.getAndIncrement()<count)
                    .map(it -> it.split(","))
                    .map(values -> {
                        Persona per = new Persona();

                        //sexo: P01->10
                        //edad: P03->12
                        //anioNacimiento: P04A->14
                        //mesNacimiento: P04M->13
                        var sexo = Integer.parseInt(values[10]);
                        var edad = Integer.parseInt(values[12]);
                        var anio = Integer.parseInt(values[14]);
                        var mes = Integer.parseInt(values[13]);

                        per.setProvincia(values[0]);
                        per.setCanton(values[1]);
                        per.setSexo(sexo);
                        per.setEdad(edad);
                        per.setAnioNacim(anio);
                        per.setMesNacim(mes);

                        return per;
                    })
                    .forEach(repo::persist);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
