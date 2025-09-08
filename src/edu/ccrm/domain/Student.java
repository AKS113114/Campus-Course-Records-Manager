package edu.ccrm.domain;

public class Student {
    private int id;
    private String regNo;
    private String name;
    private String email;

    public Student(int id, String regNo, String name, String email) {
        this.id = id;
        this.regNo = regNo;
        this.name = name;
        this.email = email;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s (%s) <%s>", id, name, regNo, email);
    }
}

