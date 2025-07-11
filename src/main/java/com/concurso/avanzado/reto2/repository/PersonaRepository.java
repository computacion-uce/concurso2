package com.concurso.avanzado.reto2.repository;

import com.concurso.avanzado.reto2.db.Persona;
import com.concurso.avanzado.reto2.dtos.CountDto;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class PersonaRepository implements
        PanacheRepositoryBase<Persona, Integer> {

    @PersistenceContext
    EntityManager entityManager;

    public List<CountDto> findByCanton(String canton) {

        String sql = "select o.sexo, count(o) " +
                " from Persona o " +
                " where o.canton=?1 group by o.sexo";

        return entityManager.createQuery(sql, Object[].class)
                .setParameter(1, canton)
                .getResultList()
                .stream()
                .map(o -> new CountDto(
                        ((Integer) o[0]) == 1 ? "Hombres" : "Mujeres",
                        (Long) (o)[1]))
                .collect(Collectors.toList());
    }

    public List<CountDto> findByAnio(Integer anio) {
        var map = this.find("anioNacimiento", anio)
                .stream()
                .collect(Collectors.groupingBy(
                        Persona::getSexo, Collectors.counting()
                        ));

        if(map.isEmpty()) {
            return List.of();
        }

        return List.of(
                new CountDto("Hombres", map.getOrDefault(1, 0L)),
                new CountDto("Mujeres", map.getOrDefault(2, 0L))
        );
    }
}
