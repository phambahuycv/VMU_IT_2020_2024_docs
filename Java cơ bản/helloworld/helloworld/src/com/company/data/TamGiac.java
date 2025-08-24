package com.company.data;

public class TamGiac implements IInfo, Comparable {
    int a, b, c;
    public TamGiac() {}

    public void capNhat(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void info() {
        System.out.printf("Tam giác: %d, %d, %d\n", a, b, c);
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof TamGiac) {
            TamGiac r = (TamGiac) o;

            return (a + b + c) - (r.a + r.b + r.c);
        }
        return 0;
    }


    @Override
    public boolean equals(Object o) {
        if (o instanceof TamGiac) {
            return (a == ((TamGiac) o).a)
                    && b == ((TamGiac) o).b
                    && c == ((TamGiac) o).c;
        }
        return false;
    }
}
