#include<stdio.h>
#include<string.h>
typedef struct{
	char ten[10];
	int masv;
	float d1, d2, d3;
}SV;
void nhap(SV a[],int n)
{
	int i;
	for(i=0;i<n;i++){
		scanf("%s",a[i].ten);
		scanf("%d",&a[i].masv);
		scanf("%f%f%f",&a[i].d1, &a[i].d2, &a[i].d3);
	}
}
void in(SV a[], int n){
	int i;
	for(i=0;i<n; i++){
		printf("\n%s %d ",a[i].ten, a[i].masv);
		printf("%.2f %.2f %.2f ",a[i].d1, a[i].d2, a[i].d3);
		printf("%.2f\n",(float)(a[i].d1+a[i].d2+a[i].d3)/3);
	}
}
void sx(SV a[], int n)
{
    int i,j;
	SV tg;
	for(i=0;i<n-1;i++){
		for(j=i+1;j<n;j++){
			if(strcmp(a[i].ten,a[j].ten)>0){
				tg=a[i];
				a[i]=a[j];
				a[j]=tg;
			}
		}
	}
}
int main(){
	int n;
	SV a[100];
	scanf("%d",&n);
	nhap(a,n);
	printf("Danh sach sinh vien\n%d ", n);
	sx(a,n);
	in(a,n);
}
