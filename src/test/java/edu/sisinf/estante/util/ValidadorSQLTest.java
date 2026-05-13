package edu.sisinf.estante.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidadorSQLTest {

    @Test
    @DisplayName("Debe detectar SELECT independientemente de mayúsculas/minúsculas")
    void testSelectVariaciones() {
        assertTrue(ValidadorSQL.esSelect("SELECT * FROM usuarios"), "Fallo en SELECT mayúsculas");
        assertTrue(ValidadorSQL.esSelect("select * from usuarios"), "Fallo en select minúsculas");
        assertTrue(ValidadorSQL.esSelect("   SELECT * FROM productos"), "Fallo con espacios al inicio");
    }

    @Test
    @DisplayName("Debe detectar comandos DML (INSERT, UPDATE, DELETE)")
    void testComandosDML() {
        assertTrue(ValidadorSQL.esDML("INSERT INTO usuarios VALUES (1,'Juan')"));
        assertTrue(ValidadorSQL.esDML("UPDATE usuarios SET nombre='Carlos'"));
        assertTrue(ValidadorSQL.esDML("DELETE FROM usuarios"));
    }

    @Test
    @DisplayName("DDL como DROP o CREATE no deben ser detectados como SELECT o DML")
    void testComandosDDL() {
        String drop = "DROP TABLE usuarios";
        String create = "CREATE TABLE usuarios";

        assertFalse(ValidadorSQL.esSelect(drop));
        assertFalse(ValidadorSQL.esDML(drop));
        assertFalse(ValidadorSQL.esSelect(create));
        assertFalse(ValidadorSQL.esDML(create));
    }

    @Test
    @DisplayName("Manejo de casos borde: nulos y vacíos")
    void testCasosBorde() {
        assertFalse(ValidadorSQL.esSelect(""), "La cadena vacía no es SELECT");
        assertFalse(ValidadorSQL.esDML(""), "La cadena vacía no es DML");
        assertFalse(ValidadorSQL.esSelect(null), "Null no debe lanzar excepción y ser false");
        assertFalse(ValidadorSQL.esDML(null), "Null no debe lanzar excepción y ser false");
    }
}
