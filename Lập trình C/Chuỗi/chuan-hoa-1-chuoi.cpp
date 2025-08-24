#include<stdio.h>
#include<string.h>
void Xoadaucach(char s[],unsigned int vt)
{
	unsigned int i;
	if(vt>=0&&vt<=strlen(s))
	for(i=vt;i<strlen(s);i++)
	{
		s[i]=s[i+1];
	}
	else
	return; 
}




void Themdaucach(char s[],unsigned int vt)
{
	unsigned int i;
	for(i=strlen(s);i>vt;i--)
	{
		s[i+1]=s[i];
	}
	s[strlen(s)+1]='\0';
	s[vt+1]=' ';
}




void Thuong(char s[])
{
	unsigned int i;
	for(i=0;i<strlen(s);i++)
	{
		if((s[i]>='A')&&(s[i]<='Z'))
		{
			s[i]=s[i]+32;
		}
	}
}




void Vitri1(char s[])
{
	unsigned int i=0;
	Thuong(s);
	while(i<strlen(s))
	{
		if(((s[i]==' ')&&(s[i+1]==' '))||((s[i]==',')&&(s[i+1]==' '))||((s[i]=='.')&&(s[i+1]==' '))){
		Xoadaucach(s,i+1);
	    }
	    else{
		i++;
	    }
		if(s[0]==' '){
		Xoadaucach(s,0);
	    }
		if(s[strlen(s)-1]==' '){
		Xoadaucach(s,strlen(s)-1);
		s[strlen(s)-1]='\0';
	    }
	}
}





void Hoa(char s[])
{
	unsigned int i;
	Vitri1(s);
	for(i=0;i<strlen(s);i++)
	{
		if(s[i]=='.'&&s[i+1]!=' ')
		{
			if((s[i+1]>='a')&&(s[i+1]<='z'))
			{
				s[i+1]=s[i+1]-32;
			}
		}
		if(s[0]!=' ')
		{
			if((s[0]>='a')&&(s[0]<='z'))
			{
				s[0]=s[0]-32;
			}
		}
	}
}




void Vitri2(char s[])
{
	unsigned int i=0;
	Hoa(s);	
	while(i<strlen(s))
	{
		if(((s[i]=='.')&&(s[i+1]!=' '))||((s[i]==',')&&(s[i+1]!=' ')))
		{
			Themdaucach(s,i);
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
	Vitri2(s1);
	fgets(s2,sizeof(s2),stdin);
	Vitri2(s2);
	printf("%s" , s1);
	printf("%s" , s2);
}
