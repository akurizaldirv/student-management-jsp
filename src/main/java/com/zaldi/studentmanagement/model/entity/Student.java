package com.zaldi.studentmanagement.model.entity;

public class Student {
    private String studentId;
    private String studentName;
    private Integer mark;
    private String department;

    public Student(String studentId, String studentName, Integer mark, String department) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.mark = mark;
        this.department = department;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", mark=" + mark +
                ", department='" + department + '\'' +
                '}';
    }
}
