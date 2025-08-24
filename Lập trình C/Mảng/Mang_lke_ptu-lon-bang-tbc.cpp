#include <stdio.h>
#include <math.h>
void nhap( int a[], int n) {
    int i;
    for(i=0; i<n; i++)
        scanf("%d ", &a[i]);
}

float tbc(int a[], int n) {
	float s=0;
    for( int i=0; i<n; i++ ){
    	s=s+a[i];
	}
    return s/n;
}

int main() {
    int n, i, dem=0;
    scanf("%d ",&n);
    int a[1000];
    nhap(a,n);
    for(i=0; i<n; i++){
    	if(a[i]>=tbc(a,n)){
    		dem++;
    		printf("%d ", a[i]);
    	}
	}
	printf("\n");
	printf("So phan tu thoa man: %d", dem);
	return 0;
}
