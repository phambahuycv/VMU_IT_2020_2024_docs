#include <stdio.h>
void nhap(float a[],int n)
{
    int i;
    for(i=0;i<n;i++)
    {
        scanf("%f",&a[i]);
    }
}
void in(float a[], int n)
{
    int i;
    printf("Mang ban dau\n");
    printf("%d\n",n);
    for(i=0;i<n;i++)
    {
        printf("%.3f ", a[i]);
    }
}
int main() {
    int n;
    scanf("%d", &n);
    float a[n];
    nhap(a,n);
    in(a,n);
}
