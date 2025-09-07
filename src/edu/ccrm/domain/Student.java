package edu.ccrm.domain;

import java.time.LocalDate;

public class Student {
    private int id;
    private String regNo;
    private String name;
    private String email;
    private LocalDate createdAt;

    public Student(int id, String regNo, String name, String email) {
        this.id = id;
        this.regNo = regNo;
        this.name = name;
        this.email = email;
        this.createdAt = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", regNo='" + regNo + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
