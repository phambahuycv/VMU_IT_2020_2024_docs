package com.company;

import com.company.data.*;

public class NhapMonJava {
    public static void main(String[] args) {
        Person[] dslop = new Person[5];
        final int k;
        System.out.println("Xin chào!");
        System.out.println(HangSo.NCOVI);
        k = 9;
        System.out.println("k = " + k);

        for (int i = 0; i < dslop.length; i++) {
            if (i % 2 == 0) {
                dslop[i] = new Person(
                        Integer.toString(i),
                        HangSo.NCOVI
                );
            } else {
                dslop[i] = new Student(
                        Integer.toString(i),
                        "COVID-19",
                        "sid" + Integer.toString(i));
            }
        }

        for (Person p: dslop) {
            p.info();
        }

        System.out.println("Số báo danh");
        for (Person p: dslop) {
            if (p instanceof Student) {
                String sbd = ((Student) p).getSoBaoDanh();
                System.out.println(sbd);
            }
        }

        TamGiac tg = new TamGiac();
        tg.capNhat(3, 4, 5);
        tg.info();

        IInfo info;
        System.out.println("Info");
        info = tg;
        info.info();
        info = dslop[1];
        info.info();

        TamGiac tg2 = new TamGiac();
        tg2.capNhat(3, 4, 5);
        tg2.info();
        if (tg.equals(tg2)) {
            System.out.println("tg == tg2");
        } else {
            System.out.println("tg <> tg2");
        }

        if (dslop[0].equals(dslop[1])) {
            System.out.println("0 == 1");
        } else {
            System.out.println("0 <> 1");
        }

        Object
    }
}
