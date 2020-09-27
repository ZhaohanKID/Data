package org.Unit02.File;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = -4939891881002472703L;
    private String name;
    private int CScore;
    private int MScore;
    private int EScore;

    public Student() {
    }

    public Student(String name, int CScore, int MScore, int EScore) {
        this.name = name;
        this.CScore = CScore;
        this.MScore = MScore;
        this.EScore = EScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCScore() {
        return CScore;
    }

    public void setCScore(int CScore) {
        this.CScore = CScore;
    }

    public int getMScore() {
        return MScore;
    }

    public void setMScore(int MScore) {
        this.MScore = MScore;
    }

    public int getEScore() {
        return EScore;
    }

    public void setEScore(int EScore) {
        this.EScore = EScore;
    }

    public int getSum() {
        return this.CScore + this.MScore + this.EScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", CScore=" + CScore +
                ", MScore=" + MScore +
                ", EScore=" + EScore +
                '}';
    }
}
