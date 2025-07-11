package com.concurso.medio.reto3.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreacionBase {
    private Connection conn;

    public void connect() throws SQLException {
        conn = DriverManager.getConnection(ConexionBD.URL);
    }

    public void close() throws SQLException {
        if (conn != null) conn.close();
    }

    public void createTable() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS Personas (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nombre TEXT NOT NULL,
                    edad INTEGER,
                    correo TEXT,
                    direccion TEXT,
                    telefono TEXT
                );
                """;

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    // Insertamos datos para probar (solo si no hay)
    public void insertSampleData() throws SQLException {
        String checkSql = "SELECT COUNT(*) FROM Personas";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(checkSql)) {
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) return; // ya hay datos
            }
        }

        String insertSql = """
            INSERT INTO Personas 
            (nombre, edad, correo, direccion, telefono) 
            VALUES
            ('Ana', 28, 'ana@mail.com', 'Cumbaya','2456789'),
            ('Luis', 34, 'luis@mail.com', 'Conocto', '0987654321'),
            ('Marta', 40, 'marta@mail.com', 'Quito', '045666777');
            """;

        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(insertSql);
        }
    }
}
