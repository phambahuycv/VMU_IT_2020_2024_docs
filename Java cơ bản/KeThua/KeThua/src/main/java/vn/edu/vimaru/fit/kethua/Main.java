/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.vimaru.fit.kethua;

import vn.edu.vimaru.fit.kethua.data.*;

/**
 *
 * @author mushu
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Person[] ds = new Person[3];
        ds[0] = new Person(
                "1",
                "Nguyen Van A",
                "Nam"
        );
        
        ds[1] = new Student(
                "2",
                "Dao Thi B",
                "Nu",
                "SV2"
        );
        
        ds[2] = new Student(
                "3",
                "Vu Van C",
                "Nam",
                "SV3"
        );
        
        for (IInfo p: ds) {
            p.info();
        }
        
        System.out.println("");
        System.out.println("Danh sách học sinh:");
        for (Person p: ds) {
            System.out.println(p.getClass());
            if (p instanceof Student) {
                p.info();
            }
        }
        
        Person ref = new Person(
                "1",
                "Nguyen Van A",
                "Nam"
        );
        
        if (ref.equals(ds[0])) {
            System.out.println("ref == ds[0]");
        } else {
            System.out.println("ref <> ds[0]");
        }
        
        System.out.println("ref.name");
        System.out.println(ref.getName());
    }
}
