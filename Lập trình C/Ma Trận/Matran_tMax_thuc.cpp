#include<stdio.h>

void nhap(float a[][100], int h, int c){
	int i,j;
	for(i=0; i<h; i++)
	for(j=0; j<c; j++){
	scanf("%f", &a[i][j]);
	}
}

void in(float a[100][100], int h, int c){
	int i;
	int j;
	int vth=0, vtc=0;
	for(i=0; i<h; i++)
    for(j=0; j<c; j++)
        if(a[i][j]>a[vth][vtc]){
            vth=i;
		    vtc=j;
        }
	    printf("Phan tu lon nhat co chi so hang %d, chi so cot %d, gia tri %.2f ", vth, vtc, a[vth][vtc]);
}

int main(){
    float a[100][100];
    int h, c;
    scanf("%d%d",&h, &c);
    nhap(a, h, c);
    in(a, h, c);
    return 0;
}
