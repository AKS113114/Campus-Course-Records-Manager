package edu.ccrm.domain;

import java.time.LocalDate;

public abstract class Person {
    protected int id;
    protected String name;
    protected String email;
    protected LocalDate createdAt;

    public Person(int id, String name, String email){
        this.id = id; this.name = name; this.email = email;
        this.createdAt = LocalDate.now();
    }

    public int getId(){ return id; }
    public String getName(){ return name; }
    public String getEmail(){ return email; }

    public abstract String getRole();

    @Override
    public String toString(){
        return String.format("%s{id=%d, name='%s', email='%s'}",
            getRole(), id, name, email);
    }
}
