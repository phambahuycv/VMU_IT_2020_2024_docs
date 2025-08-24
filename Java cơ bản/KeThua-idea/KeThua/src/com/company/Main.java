package com.company;

import com.company.data.IInfo;
import com.company.data.Person;
import com.company.data.Student;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        Person[] ds = new Person[3];

        ds[0] = new Person("1", "Nguyen Van A", "Nam");
        ds[1] = new Student(
                "2", "Dao Thi B", "Nữ",
                "sv2");
        ds[2] = new Student(
                "3", "Vu Van C", "Nam",
                "sv3");

        for (IInfo i: ds) {
            i.info();
        }

        Person ref = new Person(
                "1", "Nguyen Van A", "Nam"
        );

        if (ref.equals(ds[0])) {
            System.out.println("ref == ds[0]");
        } else {
            System.out.println("ref <> ds[0]");
        }

        for (Person p: ds) {
            if (p instanceof Student) {
                Student s = (Student) p;
                System.out.printf(
                        "Mã học sinh: %s\n",
                        s.getStudentId());
            }
        }
    }
}
