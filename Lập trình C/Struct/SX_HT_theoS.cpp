#include<stdio.h>
#include<string.h>
typedef struct{
	int maht, tamx, tamy;
	float bk, dt;
}HT;
void nhap(HT a[], int n){
	int i;
	for(i=0;i<n;i++){
		scanf("%d",&a[i].maht);
		scanf("%f",&a[i].bk);
		scanf("%d",&a[i].tamx);
		scanf("%d",&a[i].tamy);
	}
}
void hthi(HT a[], int n){
	int i;
	for(i=0;i<n;i++){
	printf("%d ",a[i].maht);	
	printf("%d ",a[i].tamx);
	printf("%d ",a[i].tamy);
	printf("%.3f\n",a[i].bk);
	}
}
void sx(HT a[], int n){
	int i,j;
	HT tg;
	for(i=0;i<n-1;i++){
		for(j=i+1;j<n;j++){
			a[i].dt=3.14159*a[i].bk*a[i].bk;
			a[j].dt=3.14159*a[j].bk*a[j].bk;
			if( a[i].dt < a[j].dt ) {
				tg=a[i];
				a[i]=a[j];
				a[j]=tg;
			}
		}
	}
}
int main(){
	int n;
	HT a[1000];
	scanf("%d", &n);
	nhap(a,n);
	printf("Danh sach hinh tron\n%d\n",n);
	sx(a,n);
	hthi(a,n);
	return 0;
}
