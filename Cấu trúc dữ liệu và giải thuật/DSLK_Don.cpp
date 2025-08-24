#include<stdio.h>
#include<string.h>
#include<stdlib.h>

/* Phan cau truc */
typedef struct{
    	char ten[30];
    	int ma;
    	float dtb;
}Data;

typedef struct tagNode{
    	Data infor;
    	struct tagNode *link;
}Node;

typedef struct{
    	Node *pHead;
		Node *pTail;
    	int spt;
}LList;


/* phan nhap, xuat */
void nhap_dl(Data *x){
	printf("Nhap ma: ");
	scanf("%d",&(x->ma));
	if(x->ma>0){
		printf("Nhap ten: ");
		scanf("%s",x->ten);
		//printf("Nhap ma: ");
		//scanf("%d",&(x->ma));
		printf("Nhap dtb: ");
		scanf("%f",&(x->dtb));
	} 
} 

void in(Data x){
	printf("\nTen: %s; ma: %d; diemtb: %.2f",x.ten,x.ma,x.dtb); 
	}
	
void initL(LList *L){
    	L->pHead = NULL;
    	L->pTail = NULL;
    	L->spt = 0;
}

int emptyL(LList L){
	return(L.spt==0);
} 

// chen dau
void insertHead(LList *L,Data x){
	Node *pp;
	pp=(Node*)malloc(sizeof(Node));
	pp->infor=x;
	pp->link=NULL;
	if(emptyL(*L)){
		L->pHead=pp;
		L->pTail=pp;
	}
	else{
		pp->link=L->pHead;
		L->pHead=pp;
	}
	L->spt++;
}

// them dau
void LIFO(LList *L){
	Data x;
	initL(L);
	do{
		nhap_dl(&x);
		if(x.ma!=0)insertHead(L,x);
	}while(x.ma!=0);
}

// in toan bo
void processL(LList L){
	Node *pp=L.pHead;
	while(pp!=NULL){
		in(pp->infor);
		pp=pp->link;
	}
}

/* Phan xoa */
// xoa dau
void del_Head(LList *L){
	Node *pp;
	if(emptyL(*L))return;
	else{
		pp=L->pHead;
		L->pHead=pp->link;
		free(pp);
		L->spt--;
		if(L->pHead=NULL)L->pTail=NULL;
	}
}

// xoa sau
void del_After(LList *L,Node *q){
	Node *pp;
	if(NULL==q)return;
	else{
		pp=q->link;
		q->link=pp->link;
		free(pp);
		L->spt--;
		if(NULL==L->pTail)L->pTail=q;
	}
}

// xoa nut K
void del_K(LList *L,int K){
	Node *pp=L->pHead,*q;
	while(pp!=NULL&&pp->infor.ma!=K){
		q=pp;
		pp=pp->link;
	}
	if(NULL==pp)return;
	else{
		if(pp==L->pHead)del_Head(L);
		else del_After(L,q);
	}
}

void tao_ds(LList *L){
    initL(L);
    Data x;
    do{
        nhap_dl(&x);
        if(x.ma>0) insertHead(L,x);
    }while(x.ma>0);
}

/* Phan tim kiem */
// tim kiem tuan tu
Node* TKTT(LList L,char x[30]){
	Node *i;
	for(i=L.pHead;i!=NULL;i=i->link){
		if(strstr(i->infor.ten,x)!=NULL)return i;
	}
	return NULL;
}



/* Phan sap xep */

// chon truc tiep
void Swap(Data &a, Data &b);
void SelectionSort(LList L){
	Node *vtmin,*i,*j;
	for(i=L.pHead;i->link!=NULL;i=i->link){
		vtmin=i;
		for(j=i->link;j!=NULL;j=j->link){
			if(j->infor.ma>vtmin->infor.ma)vtmin=j;
		}
		if(vtmin!=i){
			Data tg=i->infor;
			i->infor=vtmin->infor;
			vtmin->infor=tg;
		}
	}
}


// doi cho truc tiep
void InterchangeSort(LList *L)
{
	Node *i, *j;
	for(i=L->pHead; i->link!=NULL; i=i->link)
		for(j=i->link; j!=NULL; j=j->link)
		// sap xep theo ten hoac cung ten theo ma
			if(strcmp(i->infor.ten, j->infor.ten) > 0 ||
			 ((strcmp(i->infor.ten, j->infor.ten) == 0) &&(i->infor.ma > j->infor.ma )))
				Swap(i->infor, j->infor);
}

Node* pre(LList L, Node *q)
{
	Node *pp;
	pp = L.pHead;
	if(pp == q) return NULL;
	while(pp->link!=q)
		pp=pp->link;
	return pp;
}

//chen truc tiep
void InsertionSort(LList L)
{
	Node *i, *j, *pos;
	Data x;
	for(i=L.pHead->link; i!=NULL; i=i->link)
	{
		x=i->infor;
		pos=i;
		while(pos!=L.pHead && 
		(strcmp(pre(L, pos)->infor.ten,x.ten) > 0 ||
		((strcmp(pre(L, pos)->infor.ten,x.ten) == 0)&&(pre(L, pos)->infor.ma> x.ma))))
		{
			pos->infor = pre(L,pos)->infor;
			pos=pre(L,pos);
		}
		pos->infor=x;
	}
}

//Noi bot
//void BubbleSort(LList L)
//{
//	Node *i, *j, *pp;
//	int dem;
//	for(i=L.pHead; i->link!=NULL; i=i->link)
//	{
//		pp = i;
//		dem++;
//		printf("%d\n", dem);
//		j=L.pTail;
//		for(j->link=L.pTail; j!=pp; j=pre(L,j))
//		{
//			//if(strcmp(j->infor.ten, pre(L, j)->infor.ten) > 0 ||
//			//(strcmp(j->infor.ten, pre(L, j)->infor.ten) == 0)&&(j->infor.ma > pre(L, j)->infor.ma))
//				Swap(j->infor, pre(L, j)->infor);
//		}
//	}
//}

//noi bot
void BubbleSort(LList L)
{
	Node *i, *j;
	for(i=L.pTail; i!=L.pHead; i=pre(L,i))
	{
		for(j=L.pHead; j!=i; j=j->link)
		{
			if(strcmp(j->infor.ten, j->link->infor.ten) > 0 ||
			(strcmp(j->infor.ten, j->link->infor.ten) == 0)&&(j->infor.ma > j->link->infor.ma))
				Swap(j->infor, j->link->infor);
		}
	}
}

void QuickSort(LList L)
{
	Node *i, *j;
	//if()
}

// doi vi tri
void Swap(Data &a, Data &b)
{
	Data tg = a;
	a = b;
	b = tg;
}

void Menu(){
	
}

int main(){
	LList L;
	int K,chon;
	Data x;
	char t[30];
	Node *pp;
	initL(&L);
	
	
	
	do{
		//system("cls");
		printf("\n");
		printf("==========FUNCTION============\n");
		printf("|                            |\n");
		printf("| 1: Them phan tu            |\n");
		printf("| 2: Xoa phan tu             |\n");
		printf("| 3: Duyet danh sach         |\n");
		printf("| 4: Tim theo ten            |\n");
		printf("| 5: Sap xep                 |\n");
		printf("| 0: Thoat                   |\n");
		printf("|                            |\n");
		printf("==============================\n");
		printf("Moi chon: ");
		scanf("%d", &chon);
		switch(chon){
			case 1://nhap_dl(&x);
				//if(x.ma!=0)insertHead(&L,x);
				tao_ds(&L);
				break;
			case 2:printf("\nNhap ma sv can xoa: ");
				scanf("%d",&K);
				del_K(&L,K);
				break;
			case 3:printf("\nDanh sach\n");
				processL(L);
				system("pause");
				break;
			case 4:printf("Nhap ten sv can timm: ");
				fflush(stdin);
				gets(t);
				pp=TKTT(L,t);
				if(pp!=NULL)in(pp->infor);
				else printf("Khong co");
				//system("pause");
				break;
			case 5:
				//InterchangeSort(L);
				//InsertionSort(L);
				BubbleSort(L);
				pp = L.pHead;
				while(pp!=NULL)
				{
					in(pp->infor);
					pp=pp->link;
				}
				break;
			case 0:exit;
		}
	}while(chon!=0);
	
	
	return 0; 
}
