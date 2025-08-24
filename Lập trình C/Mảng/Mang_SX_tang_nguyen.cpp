#include<stdio.h>

void nhap(int a[], int n){
    int i;
    for(i=0; i<n; i++){
        scanf("%d", &a[i]);
    }
}
void sapxep(int a[], int n){
    int i,j;
    float tg;
    for(i=0; i<n-1; i++)
        for(j=i+1; j<n; j++)
    if(a[i]>a[j]){
        tg=a[i];
        a[i]=a[j];
        a[j]=tg;
    }
}
void in(int a[], int n){
    int i;
    for(i=0; i<n; i++){
        printf("%d ",a[i]);
    }
}
int main(){
    int a[1000];
    int n;
    scanf("%d", &n);
    nhap(a,n);
    printf("%d\n", n);
    sapxep(a,n);
    in(a,n);
    return 0;
}
