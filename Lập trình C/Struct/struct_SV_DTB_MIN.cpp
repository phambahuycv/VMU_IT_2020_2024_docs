#include<stdio.h>

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
void tMin(SV a[], int n) {
	int vt=0;
	for(int i=1; i<n; i++) {
		if(a[i].d1+a[i].d2+a[i].d3 <= a[vt].d1+a[vt].d2+a[vt].d3) {
			vt=i;
		}
	}
	printf("So thu tu cua sv: %d\n", vt);
	printf("%s %d ",a[vt].ten, a[vt].masv);
	printf("%.2f %.2f %.2f ",a[vt].d1, a[vt].d2, a[vt].d3);
	printf("%.2f",(float)(a[vt].d1+a[vt].d2+a[vt].d3)/3);
}
int main(){
	int n;
	SV a[100];
	scanf("%d",&n);
	nhap(a,n);
	tMin(a,n);
	return 0;
}
