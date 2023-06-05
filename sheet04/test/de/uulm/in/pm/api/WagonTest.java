package de.uulm.in.pm.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.server.ExportException;

import static org.junit.jupiter.api.Assertions.*;

class WagonTest {
    @Test
    void parameterValidationTest() {
        RuntimeException re = assertThrows(
                RuntimeException.class,
                () -> {new Wagon(50,100,100, Wagon.Class.SECOND,true, null);}
        );

        assertEquals("Less total seats than freeSeats + reservedSeats", re.getMessage());
    }
}