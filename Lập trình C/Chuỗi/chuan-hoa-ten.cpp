#include<stdio.h>
#include<string.h>
#include<ctype.h>

void Xoa(char s[], unsigned int k, unsigned int l)
{
	for(unsigned int i=k; i<l-1; i++)
	{
		s[i]=s[i+1];
	}
	s[l-1]='\0';
}

void XoaCach(char s[], unsigned int l)
{
	for(unsigned int i=0; i<l; i++)
	{
		if(s[i]==' ' && s[i+1]==' ')
		{
			Xoa(s,i+1,l);
			i--;
			l--;
		}
	}
	if(s[0]==' ') Xoa(s,0,l);
	l=strlen(s);
	if(s[l-1]==' ') s[l-1]='\0';
}

void Hoa(char s[], unsigned int l)
{
	s[0]=toupper(s[0]);
	for(unsigned int i=1; i<l; i++)
	{
		if(isalpha(s[i])==1 && s[i-1]!=' ') s[i]=toupper(s[i]);
		if(s[i]==' ') s[i+1]=toupper(s[i+1]);
	}
}

int main()
{
	char s[100];
	fflush(stdin);
	scanf("%[^\n]", s);
	unsigned int l=strlen(s);
	XoaCach(s,l);
	l=strlen(s);
	Hoa(s,l);
	printf("%s", s);
}
