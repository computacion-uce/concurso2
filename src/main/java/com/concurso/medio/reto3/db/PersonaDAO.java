package com.concurso.medio.reto3.db;

import com.concurso.medio.reto3.model.Persona;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
    public static List<Persona> obtenerPersonas() {
        List<Persona> personas = new ArrayList<>();
        String sql = "SELECT * FROM personas";

        try (Connection conn = ConexionBD.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                personas.add(Persona.builder()
                        .id(rs.getInt("id"))
                        .nombre(rs.getString("nombre"))
                        .edad(rs.getInt("edad"))
                        .correo(rs.getString("correo"))
                        .direccion(rs.getString("direccion"))
                        .telefono(rs.getString("telefono"))
                        .build());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return personas;
    }
}
