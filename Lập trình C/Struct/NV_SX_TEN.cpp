#include<stdio.h>
#include<string.h>
typedef struct{
	char ten[10];
	int manv, pc;
	float hsl,lt;
}NV;
void nhap(NV a[],int n)
{
	int i;
	for(i=0;i<n;i++){
		scanf("%s",a[i].ten);
		scanf("%d",&a[i].manv);
		scanf("%f%d",&a[i].hsl, &a[i].pc);
	}
}
void in(NV a[], int n){
	int i;
	for(i=0;i<n; i++){
		printf("\n%s %d ",a[i].ten, a[i].manv);
		printf("%.2f %d ",a[i].hsl, a[i].pc);
		printf("%.2f\n",a[i].hsl*2000000+a[i].pc);
	}
}
void sx(NV a[],int n)
{
	int i,j;
	NV tg;
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
	NV a[100];
	scanf("%d",&n);
	nhap(a,n);
	printf("Danh sach nhan vien\n%d ", n);
	sx(a,n);
	in(a,n);
}
