package se.yrgo.domain;

import jakarta.persistence.*;


@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  //This line is optional
    private int id;

    private String enrollmentID;
    private String name;

    @Column(name = "NUM_COURSES")
    private Integer numberOfCourses;



    public Student(String name, String enrollmentID) {
        this.name = name;
        this.numberOfCourses = 10;
        this.enrollmentID = enrollmentID;
    }

    public Student(String name) {
        this.name = name;
        this.numberOfCourses = 10;

    }

    public Student() {

    }

    public int getId() {
        return id;
    }



    @Override
    public String toString() {
        return "name:" + name ;
    }

    public String getEnrollmentID() {
        return enrollmentID;
    }
}
