#include<stdio.h>
void nhap(int a[][100], int sh, int sc)
{
int i,j;
for(i=0; i<sh; i++)
for(j=0; j<sc; j++)
{
    scanf("%d",&a[i][j]);
}
}
void max_h(int a[100][100], int sh, int sc)
     {
    int i,j, vtc=0;
    for(i=0; i<sh; i++){
        vtc=0;
    for(j=1; j<sc; j++)
        if (a[i][j] > a[i][vtc])
        {
        vtc=j;
        }
        printf("%d %d %d\n",i,vtc,a[i][vtc]);
    }
}
int main(){
    int a[100][100], sh,sc;
    scanf("%d%d",&sh,&sc);
    nhap(a,sh,sc);
    max_h(a,sh,sc);
    return 0;
}
