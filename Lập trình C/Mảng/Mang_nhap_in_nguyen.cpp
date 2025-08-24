#include <stdio.h>
void nhap(int a[],int n)
{
    int i;
    for(i=0;i<n;i++)
    {
        scanf("%d",&a[i]);
    }
}
void in(int a[], int n)
{
    int i;
    printf("Mang ban dau\n");
    printf("%d\n",n);
    for(i=0;i<n;i++)
    {
        printf("%d ", a[i]);
    }
}
int main() {
    int n;
    scanf("%d", &n);
    int a[n];
    nhap(a,n);
    in(a,n);
}
