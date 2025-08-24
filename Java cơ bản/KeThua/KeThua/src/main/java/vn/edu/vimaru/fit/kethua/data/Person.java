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
public class Person implements IInfo {
    String id;
    String name;
    final String gender;
    
    public Person(String id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }
    
    // Getter
    public String getId() {
        return id;
    }
    
    // Setter
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }
    
    @Override
    public void info() {
        System.out.printf("ID: %s\n", id);
        System.out.printf("Họ và tên: %s\n", name);
        System.out.printf("Giới tính: %s\n", gender);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof Person) {
            Person p = (Person) o;
            return p.id.equals(id);
        }
        return false;
    }
}
