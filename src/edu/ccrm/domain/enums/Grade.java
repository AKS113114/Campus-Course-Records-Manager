package edu.ccrm.domain.enums;

public enum Grade {
    A_PLUS(10), A(9), B_PLUS(8), B(7), C(6), D(5), F(0);

    private final int points;
    Grade(int p){ this.points = p; }
    public int getPoints(){ return points; }
}
