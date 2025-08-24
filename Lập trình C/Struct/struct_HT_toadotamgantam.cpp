#include<stdio.h>
#include<string.h>
typedef struct {
    int ma, tamx, tamy;
    float bk, dt;
}Circle;
void input(Circle a[], int n) {
	for(int i=0; i<n; i++) {
        scanf("%d", &a[i].ma);
		scanf("%f", &a[i].bk);
		scanf("%d", &a[i].tamx);
		scanf("%d", &a[i].tamy);
		}
}
void ps(Circle a[], int n) {
    int min=0;
	for(int i=1; i<n; i++) {
    	if(a[i].tamx + a[i].tamy < a[min].tamx + a[min].tamy) {
    		min=i;
	    }
	}
	printf("\n%d ", a[min].ma);
	printf("%d ", a[min].tamx);
    printf("%d ", a[min].tamy);
    printf("%.3f ", a[min].bk);
}
int main () {
	Circle a[100];
	int n;
	scanf("%d", &n);
    input(a, n);
	ps(a, n);
    return 0;   	
}
