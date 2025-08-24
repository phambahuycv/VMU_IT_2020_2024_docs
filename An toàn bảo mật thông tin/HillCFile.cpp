#include<stdio.h>				
#include<conio.h>
#include<time.h>
#include<Windows.h>
#define max 100
#define modu 26
#define mt 10

void xuatfile(char h[], char file[], int m)
{
	FILE*pFile;
	pFile=fopen(file,"wt"); // File du?c t?o n?m trong ? C .
	
	for(int i=0;i<m;i++)
	{
		char ch = h[i];
		fputc(ch, pFile);//Ghi giá tr? các ph?n t? trong m?ng vào file .
	}
	fclose(pFile); // Ðóng file .
}

int dodai(char file[]) //tìm do dai cua file .
{
	FILE*pFile;
	pFile=fopen(file,"r+t"); // M? file ra .
	
	int i = 0;
	if(pFile==NULL)
	{
		printf("\nKhong doc duoc File ");
	}
	else
	{

		while(true)
		{
			if(fgetc(pFile) == EOF)
			{
				break;
			
			}
			i++;
		}
	}
	return i;
	fclose(pFile); // Ðóng file .
}

void docfile(char e[], char file[], int m)
{
	FILE*pFile;
	pFile=fopen(file,"r+t"); // M? file ra .
	if(pFile==NULL)
	{
		printf("\nKhong doc duoc File ");
	}
	else
	{
		for(int i = 0; i < m; i++)
		{
			
			char x =fgetc(pFile);// Ð?c các giá tr? ph?n t? trong file gán vào x .
			e[i] = x;
			//printf("a[%d]=%c\n", i, e[i]); // Xu?t các giá tr? ra màn hình .
		}
	}
	e[m] = '\0';
	fclose(pFile); // Ðóng file .
}
void xuatmang(int e[], int m)
{
	printf("\nmang la : \n");
	for(int i = 0 ; i < m; i++)
	{
		printf("%4d", e[i]);
	}
}
void chuyensangmangso(char e[], int f[], int m)// chuyen ky tu sang so de xu ly.
{
	for(int i = 0 ; i < m; i++)
	{
		int x = e[i] - 97;
		//printf("%5d", x);
		f[i] = x;
	
	}
}

void mahoa(int a[][mt], int f[],int g[], char h[], int m , int n)
{

	int so = 0;
	for(int i = 0 ; i < m ; i += n)// mã hóa n s? m?t l?n .
	{
		
			for(int k = 0 ; k < n; k++) // ch?y c?t tru?c .
			{
				int x = 0;
				int y = i;
				
				for(int l = 0; l < n ; l++) // ch?y hàng sau .
				{
					x += f[y] * a[l][k];
					//printf("%5d", x);
					y++;

				}
				int z = x;
				//printf("%5d", x);
				x = 0;
				y = i;
				
				g[so] = z % 26;
				//printf("\n %4d %4d", g[so] , so);
				so++;
				
				
				
				
			}
			
	}
	//printf("\nban ma : ");
	for(int i = 0 ; i < m ; i++)
	{
		//printf("%4d",g[i]);
		h[i] = g[i] + 97;

	}
	h[m] = '\0';

}

void giaima(int d[][mt], int f[],int g[], char h[], int m , int n)
{

	int so = 0;
	for(int i = 0 ; i < m ; i += n)// mã hóa n s? m?t l?n .
	{
		
			for(int k = 0 ; k < n; k++) // ch?y c?t tru?c .
			{
				int x = 0;
				int y = i;
				//int o;
				for(int l = 0; l < n ; l++) // ch?y hàng sau .   
				{
					x += f[y] * d[l][k];
					//printf("%5d", x);
					y++;
					//o = l;

				}
				//printf("%5d", o);
				int z = x;
				//printf("\n%5d", x);
				x = 0;
				y = i;
				
				g[so] = z % 26;
				//printf("\n %4d %4d", g[so] , so);
				so++;
							
			}
			
	}
	//printf("\nban ma : ");
	for(int i = 0 ; i < m ; i++)
	{
		//printf("%4d",g[i]);
		h[i] = g[i] + 97;

	}
	h[m] = '\0';

}





void nhap(int a[][mt] , int n)
{
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			printf("nhap phan tu thu a[%d], [%d] : ", i, j);
			scanf("%d",&a[i][j]);
		}

	}


}
void taomatran(int a[][mt], int n) // t?o ma tr?n ng?u nhiên
{
	srand(time(0));
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			a[i][j] =  rand() % 11; //hàm random
		}

	}


}
void xuat(int a[][mt], int n)
{
	printf("khoa K : \n");
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			printf("%5d", a[i][j]);
		}
		printf("\n");

	}


}

int dinhthuc(int a[][mt], int k) // tính d?nh th?c 
{
	int s = 1, det = 0, b[mt][mt];
	int i, j, m, n, c;
	if (k == 1)
	{
		return (a[0][0]);
	}
	else
	{
		det = 0;
		for (c = 0; c < k; c++)
		{
			m = 0;
			n = 0;
			for (i = 0; i < k; i++)
			{
				for (j = 0; j < k; j++)
				{
					b[i][j] = 0;
					if (i != 0 && j != c)
					{
						b[m][n] = a[i][j];
						if (n < (k - 2))
							n++;
						else
						{
							n = 0;
							m++;
						}
					}
				}
			}
			det = det + s * (a[0][c] * dinhthuc(b, k - 1));
			s = -1 * s;
		}
	}

	return (det);
}
int timso(int det) 
{
	int i = 1;
	while (true)
	{
		if ((i * det) % modu == 1)
		{
			return i;
		}
		i++;

	}
	return 0;

}
int timsoam(int det)
{
	int a = det * (-1);
	int i = 1;
	while (true)
	{
		if ((i * a) % modu == 25)
		{
			return i;
		}
		i++;

	}
	return 0;

}
void xoahangcot(int a[][mt], int &n , int dong, int cot)// xoá hang  va cot tuong ?ng
{
	for(int i = dong; i < n - 1; i++ )
	{
		for (int j = 0; j< n; j++)
		{
			a[i][j] = a[i+1][j];
		}
	}
	for(int i = 0; i < n - 1; i++ )
	{
		for (int j = cot; j< n; j++)
		{
			a[i][j] = a[i][j + 1];
		}
	}
	n--;


}

void matranphu(int a[][mt], int c[][mt], int n)// t?o ma tr?n ph?
{
	
	
	for(int i = 0 ; i < n; i++)
	{
		for(int j = 0 ; j < n; j++)
		{
			int x = n;
			    int b[mt][mt];
				for(int k = 0 ; k < n; k++)
				{
					for(int l = 0 ; l < n; l++)
					{
			
						 b[k][l] = a[k][l];
						 //printf("%4d", b[k][l]);
						 
			
		
					}
	
				}
				xoahangcot(b, x, j, i);
			  if((i + j) % 2 == 0)
				{
	
					c[i][j] = dinhthuc(b,n-1);
				}
				else
				{
                   c[i][j] = - dinhthuc(b, n -1);
			    }
			

			  //c[i][j] = con(b, x, i, j);
			
		
		}
	
	}
	//printf("\n");
	//xuat(c, n);

}

void matranphuz26(int c[][mt], int d[][mt], int n, int so) // t?o ma tr?n ngh?ch d?o trên modu
{
	for(int i = 0; i < n; i++)
	{
		for(int j = 0 ; j < n; j++)
		{
			if(c[i][j] >= 0)
			{
				d[i][j] = (((c[i][j] ) % modu) * so) % modu;
			}
			else
			{
				int x = modu - ((c[i][j] * (-1) ) % modu);
				d[i][j] = (x * so) % modu;

			}
		}
	}
	//printf("\n");
	//xuat(d, n);



}





int main()
{
	int a[mt][mt];
	int n;
	int c[mt][mt];
	int d[mt][mt];
	
	


	char e[max];//a
    int f[max];//b
	int g[max];//c
	char h[max];//d
	int x ;
quaylai:
	printf("-----------------MeNu-----------------");
	printf("\nchon 1 de ma hoa");
	printf("\nchon 2 de giai ma\n");
luachon:
	scanf("%d", &x);
	if(x == 1)
	{
		printf("\nnhap bac ma tran khoa ");
		scanf("%d",&n);
		duycong:
	//system("cls");
		taomatran(a, n);
		//xuat(a, n);
		int det = dinhthuc(a, n);
		
		
		if (det == 0 || det % 2 == 0)
		{
			goto duycong;
		}
		else
		{
			xuat(a, n);
		}
		//printf("\n ............... \n");
	//	int det = dinhthuc(a, n);
		printf("det : %d",det);
		int so ;
		if(det > 0)
		{
			so = timso(det);
		
		}
		else
		{
			so = timsoam(det);
		}
		
		//printf("so : %d", so);
		matranphu(a, c, n);
		matranphuz26(c, d, n, so);
		//printf("\n ............... \n");

		//



		    char filegoc[max];
			printf("\nnhap duong dan va file can ma hoa vidu C://input.txt : ");
			fflush(stdin);
		    gets(filegoc);
			int m = dodai(filegoc);
			printf("%d", m);
			docfile(e, filegoc, m);
			printf("\n");
			//printf("%s", a);
			chuyensangmangso(e, f, m);
			//xuatmang(f, m);
			mahoa(a, f, g, h, m, n);
			//xuatmang(g, m);
			//banma(g, h, m);
			//printf("%s", h);
			char filexuat[max];
			printf("\nnnhap duong dan va ten file can xuat ra C://banma.txt : ");
			fflush(stdin);
			gets(filexuat);
			xuatfile(h, filexuat, m);

	// chay lai ct
				
			printf("\n ban co muon chay lai chuong trinh ko chon y orr Y de chay lai or n N de thoat ");
		int tieptuc;

		fflush(stdin);
		tieptuc = getch();
		
		if(tieptuc=='y'||tieptuc=='Y')
		{
			goto quaylai;
		}
		else
		{
			getch();
			return 0;

		}

	//



	}
	else if(x == 2)
	{

            printf("nhap bac cho ma tran khoa \n");
			scanf("%d", &n);

		    printf("nhap ma tran khoa \n");
			
		    nhap(a, n);
			//
			   int det = dinhthuc(a, n);
			   int so ;
				if(det > 0)
				{
					so = timso(det);
		
				}
				else
				{
					so = timsoam(det);
				}
			   
				//printf("so : %d", so);
				matranphu(a, c, n);
				matranphuz26(c, d, n, so);
			//



		    char filegiai[max];
		    printf("\nnhap duong dan va file can giai ma vidu C://banma.txt : ");
			fflush(stdin);
		    gets(filegiai);
			int m = dodai(filegiai);
			//printf("%d",m);
			docfile(e, filegiai,m);
			chuyensangmangso(e, f, m);
			//xuatmang(f, m);
			giaima(d, f, g, h, m , n);


			//printf("%s", h);
			char filexuat1[max];
			printf("\nnhap duong dan va ten file can xuat ra C://giaima.txt : ");
			fflush(stdin);
			gets(filexuat1);
			xuatfile(h, filexuat1, m);
			fflush(stdin);
	//chay lai ct
			printf(" ban co muon chay lai chuong trinh ko chon y orr Y de chay lai or n N de thoat ");
		int tieptuc;

		fflush(stdin);
		tieptuc = getch();
		
		if(tieptuc=='y'||tieptuc=='Y')
		{
				goto quaylai;
		}
		else
		{
			getch();
			return 0;

		}
	//
	
	}
	else
	{
		printf("\nlua chon ko hop le moi chon lai : ");
		goto luachon;
	}



	//getch();
	//return 0;

}



