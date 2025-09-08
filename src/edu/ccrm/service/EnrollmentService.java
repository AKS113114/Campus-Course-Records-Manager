package edu.ccrm.service;

import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.enums.Semester;
import edu.ccrm.exceptions.DuplicateEnrollmentException;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class EnrollmentService {
    private final List<Enrollment> enrollments = new ArrayList<>();
    private final AtomicInteger idGen = new AtomicInteger(1);

    public Enrollment enroll(int studentId, int courseId, Semester sem) throws DuplicateEnrollmentException {
        boolean exists = enrollments.stream().anyMatch(e -> e.getStudentId()==studentId && e.getCourseId()==courseId);
        if (exists) throw new DuplicateEnrollmentException("Student already enrolled in course");
        Enrollment e = new Enrollment(idGen.getAndIncrement(), studentId, courseId, sem);
        enrollments.add(e);
        return e;
    }

    public List<Enrollment> listForStudent(int studentId){
        return enrollments.stream().filter(e -> e.getStudentId()==studentId).collect(Collectors.toList());
    }

    public void assignGrade(int enrollmentId, edu.ccrm.domain.enums.Grade g){
        enrollments.stream().filter(en -> en.getStudentId()==enrollmentId).findFirst().ifPresent(en -> en.setGrade(g));
    }
}
