#include<stdio.h>
#include<string.h>
typedef struct{
	int maht, tamx, tamy;
	float bk;
}HT;
void nhap(HT a[], int n){
	int i;
	for(i=0;i<n;i++){
		scanf("%d",&a[i].maht);
		scanf("%d",&a[i].tamx);
		scanf("%d",&a[i].tamy);
		scanf("%f",&a[i].bk);
	}
}
void hthi(HT a[], int n){
	int i;
	for(i=0;i<n;i++){
	printf("%d ",a[i].maht);
	printf("%.3f ",a[i].bk);	
	printf("%d ",a[i].tamx);
	printf("%d\n",a[i].tamy);

	}
}

int main(){
	int n;
	HT a[1000];
	scanf("%d", &n);
	nhap(a,n);
	printf("Danh sach hinh tron: %d\n",n);
	hthi(a,n);
	return 0;
}
