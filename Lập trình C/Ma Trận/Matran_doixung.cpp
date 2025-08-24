#include <stdio.h>
#define MAX_SIZE 100

void nhapMaTran( int arr[][MAX_SIZE], int size ) {
	for( int i=0; i<size; i++ ) {
		for( int j=0; j<size; j++ ) {
			scanf( "%d", &arr[i][j] );
		}
	}
}

void kiemtraDx( int arr[][MAX_SIZE], int size ) {
	for( int i=0; i<size; i++ ) {
		for( int j=0; j<size; j++ ) {
			if( arr[i][j]!=arr[j][i] ) {
				printf( "Khong doi xung" );
				return;
			}
		}
	}
	printf( "Co doi xung" );
}

int main() {
	int arr1[MAX_SIZE][MAX_SIZE], arr2[MAX_SIZE][MAX_SIZE], size1, size2;
	scanf( "%d", &size1 );
	nhapMaTran( arr1, size1 );
	scanf( "%d", &size2 );
	nhapMaTran( arr2, size2 );
	printf( "Ma tran 1: ");	kiemtraDx( arr1, size1 );
	printf( "\n" );
	printf( "Ma tran 2: ");	kiemtraDx( arr2, size2 );
	return 0;
}
