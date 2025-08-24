#include<stdio.h>

void nhap(int a[100][100], int m, int n)
{
    int i, j;
   for(i=0;i<m;i++)
{
for(j=0;j<n;j++)
{
scanf("%d",&a[i][j]);
}
} 
}

void in(int a[100][100], int m, int n)
{
int i, j;
for(i=0;i<m;i++)
{
for(j=0;j<n;j++)
{
printf("%d ",a[i][j]);
}
printf("\n");
}  
}

int main()
{
int a[100][100],b[100][100],matrantich[100][100];
int m1,n1,m2,n2;
int i,j,k;

scanf("%d%d", &m1, &n1);
nhap(a, m1, n1);

scanf("%d%d", &m2, &n2);
nhap(b, m2, n2);

if(n1==m2){
printf("Ma tran tich\n");
for(i=0;i<m1;i++)
{
for(j=0;j<n2;j++)
{
matrantich[i][j]=0;
for(k=0;k<n1;k++)
{
matrantich[i][j]+=a[i][k]*b[k][j];
}
}
}

in(matrantich, m1, n2);
}else{printf("Du lieu vao sai");}
return 0;
}
