package edu.ccrm.domain;

public class Instructor extends Person {
    private String department;
    public Instructor(int id, String name, String email, String dept){
        super(id,name,email); this.department = dept;
    }
    public String getDepartment(){ return department; }
    @Override public String getRole(){ return "Instructor"; }
}
