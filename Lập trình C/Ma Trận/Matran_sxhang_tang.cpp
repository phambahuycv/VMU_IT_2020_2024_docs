#include <stdio.h>
void nhap(int a[][100],int n, int m)
{
    for(int i=0; i<n; i++)
    for(int j=0;j<m; j++)
    scanf("%d",&a[i][j]);
}
void sx(int a[][100], int n, int m)
{
    int i,j,k;
    for(i=0;i<n;i++)
    for(j=0;j<m-1;j++)
    for(k=j+1;k<m;k++)
    if(a[i][j]>a[i][k]){
        int tg= a[i][j];
        a[i][j]=a[i][k];
        a[i][k]=tg;
    }
}
void in(int a[][100],int n, int m)
{
    printf("%d %d\n",n ,m);
    for(int i=0; i<n; i++){
        for(int j=0;j<m; j++){
            printf("%d ",a[i][j]);
        }
        printf("\n");
    }
}
int main(){
    int a[100][100];
    int n,m;
    scanf("%d%d",&n,&m);
    nhap(a,n,m);
    sx(a,n,m);
    in(a,n,m);
}
