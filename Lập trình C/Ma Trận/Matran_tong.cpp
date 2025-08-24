#include<stdio.h>
void nhap(int a[][100], int h, int c){
	int i, j;
	for(i=0; i<h; i++)
	for(j=0; j<c; j++)
	scanf("%d", &a[i][j]);
}

void in(int a[][100], int h, int c){
	int i, j;
	for(i=0; i<h; i++){
		for(j=0; j<c; j++){
			printf("%d ", a[i][j]);
		}
		printf("\n");
	}
}

int main(){
	int a[100][100], b[100][100], matrantong[100][100];
	int h1, c1, h2, c2;
	int i, j;
	scanf("%d%d", &h1, &c1);
	nhap(a, h1, c1);
	
	scanf("%d%d", &h2, &c2);
	nhap(b, h2, c2);
	if(h1==h2 && c1==c2){
		printf("Ma tran tong\n");
		for(i=0; i<h1; i++){
			for(j=0; j<c1; j++){
				matrantong[i][j]= a[i][j]+ b[i][j];
			}
		}
		in(matrantong, h1, c1);
	}
	else{
		printf("Du lieu vao sai");
	}
}
