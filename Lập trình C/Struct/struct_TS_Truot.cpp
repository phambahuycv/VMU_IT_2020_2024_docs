#include<stdio.h>
#include<string.h>
typedef struct{
	char ten[10];
	int sbd;
	float d1, d2, d3;
}TS;
void nhap(TS a[], int n)
{
	int i;
	for(i=0;i<n;i++){
		scanf("%s",a[i].ten);
		scanf("%d",&a[i].sbd);
		scanf("%f%f%f",&a[i].d1, &a[i].d2, &a[i].d3);
	}
}
void tKe(TS a[], int n){
    int dem=0;
    for(int i=0; i<n; i++)
    if(a[i].d1 < 1.0 || a[i].d2 < 1.0 || a[i].d3 < 1.0 || a[i].d1+a[i].d2+a[i].d3 < 15)
    {
        printf("%s %d %.2f %.2f %.2f ", a[i].ten, a[i].sbd, a[i].d1, a[i].d2, a[i].d3);
        printf("%.2f\n",(float)(a[i].d1+a[i].d2+a[i].d3));
        dem++;
    }
    printf("So thi sinh thi truot: %d",dem);
}
int main(){
	int n;
	TS a[100];
	scanf("%d",&n);
	nhap(a,n);
	printf("Danh sach thi sinh thi truot\n");
	tKe(a,n);
}
