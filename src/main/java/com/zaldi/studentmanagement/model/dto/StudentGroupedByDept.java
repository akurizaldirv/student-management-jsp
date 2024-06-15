package com.zaldi.studentmanagement.model.dto;

import com.zaldi.studentmanagement.model.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentGroupedByDept {
    private String deptName;
    private List<Student> students = new ArrayList<>();

    public StudentGroupedByDept(String deptName, List<Student> students) {
        this.deptName = deptName;
        this.students.addAll(students);
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public double getPassPercentage() {
        double passedStudentCount = this.students.stream()
                .filter(student -> student.getMark() >= 40)
                .count();
        return (passedStudentCount/this.students.size()) * 100;
    }

    @Override
    public String toString() {
        return "StudentGroupedByDept{" +
                "deptName='" + deptName + '\'' +
                ", students=" + students +
                '}';
    }
}
