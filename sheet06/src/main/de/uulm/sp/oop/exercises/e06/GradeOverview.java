package de.uulm.sp.oop.exercises.e06;

import de.uulm.sp.oop.exercises.e06.util.Pair;

import java.util.HashMap;
import java.util.Optional;

public class GradeOverview {
    public GradeOverview() {
        m_Grades = new HashMap<>();
    }

    public Pair<Double, Integer> addTestResult(String lectureName, Pair<Double,Integer> gradeAndECTS) {
        m_Grades.put(lectureName, gradeAndECTS);
        return gradeAndECTS;
    }

    public int currentECTS() {
        int sum = 0;
        for(var entry : m_Grades.entrySet()) {
            sum += entry.getValue().getSecond();
        }

        return sum;
    }

    public Optional<Pair<Double, Integer>> getExamResults(String lectureName) {
        if(!m_Grades.containsKey(lectureName)) {
            return Optional.empty();
        }

        return Optional.of(m_Grades.get(lectureName));
    }

    public double totalGradeAverage() {
        double sum = 0;
        for(var entry : m_Grades.entrySet()) {
            sum += entry.getValue().getFirst() * entry.getValue().getSecond();
        }

        return sum / currentECTS();
    }


    private HashMap<String, Pair<Double, Integer>> m_Grades;
}
