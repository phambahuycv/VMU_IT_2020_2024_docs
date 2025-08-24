#include <stdio.h>
#include <stdlib.h>
#include<string.h>

//Data
typedef struct{
    char ten[30];
    int masv;
    float d1, d2, d3;
}Data;

//Node
typedef struct tagNode{
    Data infor;
    struct tagNode *next, *pre ;
}Node;

//Double List
typedef struct{
    Node *pHead;
    Node *pTail;
    int spt;
}DList;

// Tao ds rong
void InitList (DList *L){
    L->pHead = NULL;
    L->pTail = NULL;
    L->spt = 0;
}

// kiem tra xem danh sach co dang rong
int emptyList (DList L){
    return (L.spt == 0);
}

// chen dau
void insert_Head(DList *L, Data x){
    Node *pp;
    pp= (Node*) malloc(sizeof(Node));
    pp->infor = x;
    pp->next = NULL;
    pp->pre = NULL;
    if(emptyList(*L)){
        L->pHead = pp;
        L->pTail = pp;
    }
    else{
        pp->next = L->pHead;
        L->pHead->pre=pp;
        L->pHead = pp;
    }
    L->spt++;
}

// chen vao cuoi
void insert_Tail(DList *L, Data x){
    	Node *pp;
    	pp = (Node*) malloc(sizeof(Node));
    	pp->infor = x;
    	pp->next = NULL;
    	pp->pre = NULL;
    	if(emptyList(*L)){
    			L->pHead = pp;
    			L->pTail = pp;
    	}
		else {
			L->pTail->next=pp;
    		pp->pre=L->pTail;
    		L->pTail = pp;
    	}
    	L->spt++;
}

// chen vao sau mot phan tu k
void insert_After(DList *L, Node *q, Data x){
	Node *pp;
	if(NULL==q) return;
	else{
		pp=(Node*) malloc(sizeof(Node));
		pp->infor = x;
		pp->next= q->next;
		q->next->pre=pp;
		q->next=pp;
		pp->pre=q;
		if(q==L->pTail) L->pTail=pp;
		L->spt++;
	}
}

// xoa dau
void del_Head (DList *L) {
	Node *pp;
	if( emptyList(*L) ) return;
	else { 
		pp = L->pHead;
		L->pHead = pp->next;
		free(pp);
		L->spt--;
		if(L->pHead==NULL) L->pTail=NULL;
	}
}

// xoa phan tu o cuoi
void del_After (DList *L, Node *q) {
Node *pp;
if( NULL==q) return;
else { 
	pp = q->next;
	q->next=pp->next;
	pp->next->pre=q;
	free(pp);
    L->spt--;
    if(NULL == L->pTail) L->pTail=q;
    }
}

// xoa phan tu k o vi tri bat ky
void del_K(DList *L, char K[30]){
	Node *pp=L->pHead, *q;
	while (pp!=NULL && !strstr(pp->infor.ten, K)){
		q=pp;
		pp=pp->next;
	}
	if(NULL==pp) return;
	else
		if(pp==L->pHead) del_Head(L);
		else del_After(L, q);
}

// nhap du lieu vao data
void nhapdl(Data *x){
    printf("Nhap ma: "); scanf("%d", &(x->masv));
    if(x->masv >0){
        printf("Nhap ten: "); scanf("%s", x->ten);fflush(stdin);
        printf("Nhap diem m1: "); scanf("%f", &(x->d1));fflush(stdin);
        printf("Nhap diem m2: "); scanf("%f", &(x->d2));fflush(stdin);
        printf("Nhap diem m3: "); scanf("%f", &(x->d3));fflush(stdin);
    }
}

// in ra du lieu
void indl(Data x){
    printf("%s, %d, %.2f, %.2f, %.2f\n",
    x.ten,x.masv,x.d1,x.d2,x.d3);
}

// tao danh sach bang nhap du lieu
void tao_ds(DList *L){
    InitList(L);
    Data x;
    do{
        nhapdl(&x);
        if(x.masv>0) insert_Head(L,x);
    }while(x.masv>0);
}

// lay phan tu dau danh sach
void duyet_dau_ds(DList L){
    Node *pp=L.pHead;
    while(pp!=NULL){
        indl(pp->infor);
        pp=pp->next;
    }
}

// lay phan tu o cuoi danh sach
void duyet_cuoi_ds(DList L){
    Node *pp=L.pTail;
    while(pp!=NULL){
        indl(pp->infor);
        pp=pp->pre;
    }
}

/*float dtb (Data x){
	return (x.d1+x.d2+x.d3)/3;
}
int ktra_hb(Data x){
	return (x.d1>=5.5&&x.d2>=5.5&&x.d3>=5.5&&dtb(x)>=7.0);
}
int ktra_hl(Data x){
	return (x.d1<=4.0||x.d2<=4.0||x.d3<=4.0);
}
void processList(DList L, DList *L1, DList *L2){
	InitDlist(L1);
	InitDlist(L2);
	Node *pp=L.pHead;
	while(pp!=NULL){
		if(ktra_hb(pp->infor)) insert_Head(L1, pp->infor);
		else
			if(ktra_hl(pp->infor)) insert_Head(L2, pp->infor);
	pp=pp->next;
	}
}*/


int main()
{
    DList ds;
    InitList(&ds);
    
    tao_ds(&ds);
    printf("duyet ds tu dau: \n");
    duyet_dau_ds(ds);
    printf("duyet ds tu cuoi: \n");
    duyet_cuoi_ds(ds);
    //del_K(ds,k);
    //printf("danh sach da xoa: \n");
    //duyet_dau_ds(ds)
    //processList(ds, &ds1, &ds2);
}
