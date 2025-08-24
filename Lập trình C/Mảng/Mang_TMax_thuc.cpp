#include<stdio.h>
void nhap(float a[], int n){
    int i;
    for(i=0; i<n; i++){
        scanf("%f", &a[i]);
    }
}
void tmax(float a[], int n){
    int i, vt;
    float max;
	max=a[0];
    for(i=0; i<n; i++){
        if(max< a[i]){
            max=a[i];
            vt=i;
        }
    }
    printf("Phan tu lon nhat co vi tri %d, co gia tri %.3f", vt, a[vt]);
}
int main(){
    float a[1000];
    int n;
    scanf("%d", &n);
    nhap(a, n);
    tmax(a, n);
}
