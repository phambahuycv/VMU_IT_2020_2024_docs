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
void Amax(NV a[], int n) {
	int max=0, i;
    for(i=1; i<n; i++) {
    	if(a[i].luong > a[max].luong) {
            max=i;		
		}
	}   
	printf("\n%s ", a[max].ten);
    printf("%d ", a[max].ma);
    printf("%.2f ", a[max].hsl);
    printf("%d ", a[max].pc);
    printf("%.2f", a[max].luong );
}
int main () {
	NV a[100];
	int n;
	scanf("%d", &n);
    input(a, n);
    printf("Nhan vien co luong lon nhat");
    Amax(a, n);
    return 0;   	
}
