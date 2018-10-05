package com.company;

import java.io.Serializable;

class Course implements Serializable {
    // variables
    private String name;
    private Teacher[] teachers = new Teacher[2];
    private Student[] students = new Student[30];
    private int teacherCount = 0;
    private int studentCount = 0;

    // methods
    public Course(String nam) {
        this.name = nam;
    }

    public boolean addTeacher(Teacher teach) {
        if (this.teacherCount == this.teachers.length) {
            return(false);
        }
        this.teachers[this.teacherCount] = teach;
        this.teacherCount += 1;
        return(true);
    }

    public void removeTeacher(int num) {
        this.teachers[num] = null;
        num ++;
        for (; num < this.teachers.length; num++) {
            this.teachers[num - 1] = this.teachers[num];
            this.teachers[num] = null;
        }
        this.teacherCount -= 1;
    }

    public boolean addStudent(Student stud) {
        if (this.studentCount == this.students.length) {
            return(false);
        }
        this.students[this.studentCount] = stud;
        this.studentCount += 1;
        return(true);
    }

    public void removeStudent(int num) {
        this.students[num] = null;
        num ++;
        for (; num < this.students.length; num++) {
            this.students[num - 1] = this.students[num];
            this.students[num] = null;
        }
        this.studentCount -= 1;
    }

    // setters
    public void setName(String nam) {
        this.name = nam;
    }

    // getters
    public String getName() {
        return(this.name);
    }

}