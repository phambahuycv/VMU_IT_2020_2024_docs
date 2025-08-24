/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.vimaru.fit.kethua.data;

/**
 *
 * @author mushu
 */
public class Student extends Person {
    String studentId;
    
    public Student(
            String id, String name, String gender,
            String sid
    ) {
        super(id, name, gender);
        studentId = sid;
    }
    
    @Override
    public void info() {
        super.info();       
        System.out.printf("Mã học sinh: %s\n", studentId);
    }
    
    public void info(boolean append) {
        if (append) {
            super.info();
        }
        System.out.printf("Mã học sinh: %s\n", studentId);
    }
}