#include<stdio.h>
#include<string.h>
typedef struct {
    char ten[20];
    int ma,pc;
    float hsl,luong;
}NV;
void input(NV a[], int n) {
	for(int i=0; i<n; i++) {
        scanf("%s", a[i].ten);
		scanf("%d", &a[i].ma);
		scanf("%f", &a[i].hsl);
		scanf("%d", &a[i].pc);
		a[i].luong=(float)a[i].hsl*2000000+a[i].pc;
		}
}
void Amin(NV a[], int n) {
	int min=0, i;
    for(i=1; i<n; i++) {
    	if(a[i].hsl < a[min].hsl) {
            min=i;		
		}
	}   
	printf("\n%s ", a[min].ten);
    printf("%d ", a[min].ma);
    printf("%.2f ", a[min].hsl);
    printf("%d ", a[min].pc);
    printf("%.2f", a[min].luong );
}
int main () {
	NV a[100];
	int n;
	scanf("%d", &n);
    input(a, n);
    printf("Nhan vien co he so luong thap nhat");
    Amin(a, n);
    return 0;   	
}
