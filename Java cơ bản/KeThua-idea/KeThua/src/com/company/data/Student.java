package com.company.data;

public class Student extends Person {
    String studentId;

    public Student(
            String id, String name, String gt,
            String sid) {
        super(id, name, gt);
        studentId = sid;
    }

    @Override
    public void info() {
        super.info();
        System.out.printf("Mã học sinh: %s\n", studentId);
    }

    public String getStudentId() {
        return  studentId.toUpperCase();
    }
}
