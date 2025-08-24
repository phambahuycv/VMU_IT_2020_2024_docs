#include<stdio.h>
#include<string.h>
typedef struct{
	char ten[10];
	int sbd;
	float d1,d2,d3;
}TS;
void nhap(TS a[],int n)
{
	int i;
	for(i=0;i<n;i++){
		scanf("%s",a[i].ten);
		scanf("%d",&a[i].sbd);
		scanf("%f%f%f",&a[i].d1, &a[i].d2,&a[i].d3);
	}
}
void in(TS a[], int n){
	int i;
	for(i=0;i<n; i++){
		printf("\n%s %d ",a[i].ten, a[i].sbd);
		printf("%.2f %.2f %.2f ",a[i].d1, a[i].d2,a[i].d3);
		printf("%.2f",a[i].d1+a[i].d2+a[i].d3);
	}
}
int main(){
	int n;
	TS a[100];
	scanf("%d",&n);
	nhap(a,n);
	printf("Danh sach thi sinh\n%d", n);
	in(a,n);
}
