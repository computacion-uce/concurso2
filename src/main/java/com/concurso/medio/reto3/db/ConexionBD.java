package com.concurso.medio.reto3.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
    public static final String URL = "jdbc:sqlite:reporte.db";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
