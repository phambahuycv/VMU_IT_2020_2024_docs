#include <stdio.h>
#include <string.h>

typedef struct {
    char ten[50];
    int sbd;
    float d1, d2, d3, dtong;
} Thisinh;

void nhap( int n, Thisinh a[] ) {
    for( int i=0; i<n; i++ ) {
        scanf( "%s%d%f%f%f", a[i].ten, &a[i].sbd, &a[i].d1, &a[i].d2, &a[i].d3 );
        a[i].dtong=a[i].d1+a[i].d2+a[i].d3;
    }
}

void in( int n, Thisinh a[] ) {
	int vt=-1;
	for( int i=0; i<n; i++ ) {
		if( a[i].d1>=1 && a[i].d2>=1 && a[i].d3>=1 && a[i].dtong>=15 ) {
			if( a[i].dtong > a[vt].dtong ) {
				vt=i;
			}
		}
	}
	if( vt>=0 ) {
		printf( "So thu tu cua thu khoa: %d\n", vt );
		printf( "%s %d %.2f %.2f %.2f %.2f", a[vt].ten, a[vt].sbd, a[vt].d1, a[vt].d2, a[vt].d3, a[vt].dtong );
	}
	else {
		printf( "Khong co ai thi do" );
	}
}

int main() {
	Thisinh a[100];
	int n;
	scanf( "%d", &n );
	nhap(n,a);
	in(n,a);
	return 0;
}
