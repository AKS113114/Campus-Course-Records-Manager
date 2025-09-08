package edu.ccrm.domain;

import edu.ccrm.domain.enums.Grade;
import edu.ccrm.domain.enums.Semester;
import java.time.LocalDate;

public class Enrollment {
    private final int id;
    private final int studentId;
    private final int courseId;
    private final Semester semester;
    private Grade grade;
    private LocalDate enrolledAt;

    public Enrollment(int id, int studentId, int courseId, Semester sem){
        this.id = id; this.studentId = studentId; this.courseId = courseId; this.semester = sem;
        this.enrolledAt = LocalDate.now();
    }

    public int getStudentId(){ return studentId; }
    public int getCourseId(){ return courseId; }
    public Grade getGrade(){ return grade; }
    public void setGrade(Grade g){ this.grade = g; }
    public Semester getSemester(){ return semester; }
    public String toString(){ return String.format("Enrollment{id=%d stud=%d course=%d sem=%s grade=%s}", id, studentId, courseId, semester, grade); }
}
