package de.uulm.in.pm.api;

import de.uulm.in.pm.api.Train;
import de.uulm.in.pm.api.Wagon;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrainTest {
   private static Train train1;

    @BeforeAll
    static void setUp() {
        train1 = new Train(412, Train.Engine.ELECTRIC, 13500, 250,
                new Wagon(50, 24, 3, Wagon.Class.FIRST, true,
                        new Wagon(100, 12, 64, Wagon.Class.SECOND, true,
                                new Wagon(100, 32, 11, Wagon.Class.SECOND, true,
                                        new Wagon(50, 17, 3, Wagon.Class.FIRST, true, null))))
        );

        System.out.println("Testing on train: ");
        System.out.println(train1);
    }

    @Test
    void totalSeatCount() {
        int result = train1.totalSeatCount();
        assertEquals(result, 300);
    }

    @Test
    void setLight() {
        train1.setLight(true);

        Wagon w = train1.wagon;
        while(w != null) {
            assertTrue(w.isLightOn);
            w = w.next;
        }

        train1.setLight(false);

        w = train1.wagon;
        while(w != null) {
            assertFalse(w.isLightOn);
            w = w.next;
        }
    }
}
