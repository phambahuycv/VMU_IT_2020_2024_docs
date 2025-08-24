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
void tKe(SV a[], int n){
    int dem=0;
    for(int i=0; i<n; i++)
    if(a[i].d1 < 4.0 && a[i].d2 < 4.0 ||a[i].d1 < 4.0&& a[i].d3 < 4.0 ||a[i].d2 < 4.0&& a[i].d3 < 4.0)
    {
        printf("%d %s %.2f %.2f %.2f ", a[i].masv, a[i].ten, a[i].d1, a[i].d2, a[i].d3);
        printf("%.2f\n",(float)(a[i].d1+a[i].d2+a[i].d3)/3);
        dem++;
    }
    printf("Danh sach nay co %d sinh vien phai hoc lai",dem);
}
int main(){
	int n;
	SV a[200];
	scanf("%d",&n);
	nhap(a,n);
	printf("Danh sach sinh vien hoc lai\n");
	tKe(a,n);
}
