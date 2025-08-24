#include <stdio.h>

int main()
{
	int a, b, k=0;
	scanf( "%d%d", &a, &b );
	if( a<=b )
	{
		for( int n=a; n<=b; n++ )
		{
			if( n>=2 )
			{
				int dem=0;
				for( int i=2; i<=n/2; i++ )
				{
					if( n%i==0 )
					{
						dem++;
					}
				}
		
				if( dem==0 )
				{
					printf( "%d ", n); k++;
				}
			}
		}
		
		if( k==0 )
		{
			printf( "Khong co" );
		}
	}
	
	else
	{
		for( int n=b; n<=a; n++ )
		{
			if( n>=2 )
			{
				int dem=0;
				for( int i=2; i<=n/2; i++ )
				{
					if( n%i==0 )
					{
						dem++;
					}
				}
		
				if( dem==0 )
				{
					printf( "%d ", n); k++;
				}
			}
		}
		
		if( k==0 )
		{
			printf( "Khong co" );
		}
	}
	return 0;
}
