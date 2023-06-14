package de.uulm.sp.oop.exercises.e06;

import de.uulm.sp.oop.exercises.e06.util.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GradeOverviewTests {
    static GradeOverview overview;

    @BeforeAll
    static void setUp() {
        overview = new GradeOverview();
        overview.addTestResult("Meth 1", new Pair<>(1.0, 8));
        overview.addTestResult("GDTI", new Pair<>(2.0, 2));
        overview.addTestResult("OOP", new Pair<>(1.0, 8));
        overview.addTestResult("LOGIK", new Pair<>(2.7, 4));
    }

    @Test
    void currentECTS() {
        Assertions.assertEquals(overview.currentECTS(), 22);
    }

    @Test
    void getExamResults() {
        Assertions.assertTrue(overview.getExamResults("Meth 1").isPresent());
        Assertions.assertEquals(overview.getExamResults("Meth 1").get(), new Pair<>(1.0, 8));

        Assertions.assertTrue(overview.getExamResults("GDTI").isPresent());
        Assertions.assertEquals(overview.getExamResults("GDTI").get(), new Pair<>(2.0, 2));

        Assertions.assertTrue(overview.getExamResults("OOP").isPresent());
        Assertions.assertEquals(overview.getExamResults("OOP").get(), new Pair<>(1.0, 8));

        Assertions.assertTrue(overview.getExamResults("LOGIK").isPresent());
        Assertions.assertEquals(overview.getExamResults("LOGIK").get(), new Pair<>(2.7, 4));

        Assertions.assertFalse(overview.getExamResults("Shitass").isPresent());
    }

    @Test
    void totalGradeAverage() {
        Assertions.assertEquals(overview.totalGradeAverage(), 1.4, 0.001);
    }
}
