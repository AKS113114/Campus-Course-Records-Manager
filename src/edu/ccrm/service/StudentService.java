package edu.ccrm.service;

import edu.ccrm.domain.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class StudentService {
    private List<Student> students = new ArrayList<>();
    private int idGen = 1;

    public Student create(String regNo, String name, String email) {
        Student s = new Student(idGen++, regNo, name, email);
        students.add(s);
        return s;
    }

    public List<Student> list() {
        return students;
    }

    public Student findByRegNo(String regNo) {
        return students.stream()
                       .filter(s -> s.getRegNo().equalsIgnoreCase(regNo))
                       .findFirst()
                       .orElse(null);
    }

    // Stream examples
    public List<Student> searchByNameStream(String q) {
        String lq = q.toLowerCase();
        return students.stream()
                       .filter(s -> s.getName().toLowerCase().contains(lq))
                       .collect(Collectors.toList());
    }

    public List<Student> sortedByName() {
        return students.stream()
                       .sorted(Comparator.comparing(Student::getName))
                       .collect(Collectors.toList());
    }
}

