#include<stdio.h>
void nhap(int a[], int n){
    int i;
    for(i=0; i<n; i++){
        scanf("%d", &a[i]);
    }
}
void le(int a[], int n){
    int i, vt=0;
    for(i=1; i<n; i++){
        if( a[i]<a[vt] && a[i]%2!=0 )
            vt=i;
    }
    if(a[vt]%2!=0)
        printf("So le nho nhat co vi tri %d gia tri %d", vt, a[vt]);
    else
        printf("Khong co so le trong mang");
}
int main(){
    int a[1000];
    int n;
    scanf("%d", &n);
    while(n<0||n>1000)
        scanf("%d",&n);
    nhap(a,n);
    le(a,n);
    return 0;
}
