#include<stdio.h>

void nhap(float a[], int n){
    int i;
    for(i=0; i<n; i++){
        scanf("%f", &a[i]);
    }
}
int timkiem(float a[], int n, float key){
    int i;
    for(i = 0; i <n; i++)
        if(a[i]==key)   return i;
    return -1;
}
int main(){
    float a[1000];
    int n;
    float x;
    scanf("%d", &n);
    nhap(a,n);
    scanf("%f", &x);
    int vt= timkiem(a,n,x);
    if(vt!= -1) 
    printf("Phan tu %.3f co vi tri %d", x, vt);
    else    printf("%.3f not found", x);
    }
