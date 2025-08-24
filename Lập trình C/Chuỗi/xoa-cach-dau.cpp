#include<stdio.h>
#include<string.h>
void Xoa(char s[],unsigned int vt)
{
    unsigned int i;
	for(i=vt;i<strlen(s);i++)
	{
		s[i]=s[i+1]; 
	}
}




void Kiemtra(char s[])
{
	unsigned int i=0;
	while(i<strlen(s)){
	if(s[0]==' ')
	{
		Xoa(s,0); 
	}
	else
	i++;
}
}




int main()
{
	char s1[100];
	char s2[100];
	fgets(s1,sizeof(s1),stdin);
	fgets(s2,sizeof(s2),stdin);
	Kiemtra(s1);
	Kiemtra(s2);
	printf("%s" , s1);
	printf("%s" , s2);
}
