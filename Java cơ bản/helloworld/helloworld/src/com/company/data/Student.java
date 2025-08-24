package com.company.data;

public class Student extends Person {
    String studentId;
    public Student(String id, String name, String sid) {
        super(id, name); // Gọi hàm tạo/cấu tử của lớp Person.
        studentId = sid;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Student ID: " + studentId);
    }

    public String getSoBaoDanh() {
        return name + studentId;
    }

}
